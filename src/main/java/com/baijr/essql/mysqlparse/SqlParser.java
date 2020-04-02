package com.baijr.essql.mysqlparse;

import com.baijr.essql.mysqlparse.model.SortModel;
import com.baijr.essql.mysqlparse.model.ParseModel;
import com.baijr.essql.mysqlparse.model.WhereListModel;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.execute.Execute;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.merge.Merge;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.statement.upsert.Upsert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParser {

    public static ParseModel GetParesModel(String sql) {
        ParseModel parseModel = new ParseModel();
        PlainSelect plainSelect = GetPlainSelect(sql);
        List<String> fileds = SqlParser.SelectField(plainSelect);
        Limit limit = SqlParser.SelectLimit(plainSelect);
        List<OrderByElement> orderByElements = SqlParser.SelectOrderby(plainSelect);
        List<WhereListModel> whereListModels = SqlParser.SelectWhere(plainSelect);
        //todo 分组
        GroupByElement groupByElement = SqlParser.SelectGroupby(plainSelect);
        parseModel.setFileds(fileds);

        if (limit.getOffset() != null) {
            parseModel.setFrom(Integer.parseInt(limit.getOffset().toString()));
        }
        if (limit.getRowCount() != null) {
            parseModel.setTo(Integer.parseInt(limit.getRowCount().toString()));
        }

        if (orderByElements != null && orderByElements.size() > 0) {
            List<SortModel> paresSorts = new ArrayList<>();
            for (OrderByElement orderByElement : orderByElements) {
                if (orderByElement.getExpression() instanceof Column) {
                    String filedName = ((Column) orderByElement.getExpression()).getColumnName();
                    paresSorts.add(new SortModel(filedName, orderByElement.isAsc() ? "ASC" : "DESC"));
                } else {
                    throw new RuntimeException("ORDER BY 太复杂了 ，请喝杯茶再来");
                }
            }
            parseModel.setParesSorts(paresSorts);
        }
        if (whereListModels.size() > 0) {
            parseModel.setWheres(whereListModels);
        }

        return parseModel;
    }


    static PlainSelect GetPlainSelect(String sql) {
        Statement stmt = null;
        try {
            stmt = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            throw new RuntimeException("SQL 太复杂了，请喝杯茶再来");
        }
        if (SqlParser.GetSqlType(stmt).equals(SqlType.SELECT)) {
            return (PlainSelect) ((Select) stmt).getSelectBody();
        }
        throw new RuntimeException("暂时只支持SELECT ，请喝杯茶再来");
    }


    static List<String> SelectField(PlainSelect plainSelect) {
        final List<String> fileds = new ArrayList<>();
        List<SelectItem> selectitems = plainSelect.getSelectItems();
        if (selectitems != null) {
            for (SelectItem selectItem : selectitems) {
                selectItem.accept(new SelectItemVisitorAdapter() {
                    @Override
                    public void visit(SelectExpressionItem item) {
                        if (item.getExpression() instanceof Column) {
                            fileds.add(((Column) item.getExpression()).getColumnName());
                        } else {
                            throw new RuntimeException("SELECT 字段暂时解析不了，请修正后再来");
                        }
                    }
                });
            }
        }
        if (fileds.size() == 0) {
            throw new RuntimeException("SELECT 字段为空，请修正后再来");
        }
        return fileds;
    }

    static List<WhereListModel> SelectWhere(PlainSelect plainSelect) {
        List<WhereListModel> whereListModels = new ArrayList<>();
        Expression expression = plainSelect.getWhere();
        WhereType whereType = GetWhereType(expression);
        if (whereType == WhereType.OR) {

        }

        return whereListModels;
    }


    static Limit SelectLimit(PlainSelect plainSelect) {
        return plainSelect.getLimit();
    }

    static GroupByElement SelectGroupby(PlainSelect plainSelect) {
        return plainSelect.getGroupBy();
    }

    /**
     * 查询order by
     */
    static List<OrderByElement> SelectOrderby(PlainSelect plainSelect) {
        return plainSelect.getOrderByElements();
    }

    static WhereType GetWhereType(Expression expression) {
        if (expression instanceof AndExpression) {
            return WhereType.AND;
        }
        if (expression instanceof EqualsTo) {
            return WhereType.EQUAL;
        }
        if (expression instanceof OrExpression) {
            return WhereType.OR;
        }
        if (expression instanceof MinorThan) {
            return WhereType.LESS;
        }
        if (expression instanceof MinorThanEquals) {
            return WhereType.LESSEQUAL;
        }
        if (expression instanceof GreaterThan) {
            return WhereType.THEN;
        }
        if (expression instanceof GreaterThanEquals) {
            return WhereType.THENEQUAL;
        }
        if (expression instanceof NotEqualsTo) {
            return WhereType.NOTEQUAL;
        }
        if (expression instanceof InExpression) {
            return WhereType.IN;
        }
        if (expression instanceof IsNullExpression) {
            {
                if (((IsNullExpression) expression).isNot()) {
                    return WhereType.NOTNULL;
                } else {
                    return WhereType.NULL;
                }
            }
        }
        if (expression instanceof Parenthesis) {
            return WhereType.Parent;
        }

        return WhereType.NONE;
    }


    static SqlType GetSqlType(Statement sqlStmt) {
        if (sqlStmt instanceof Alter) {
            return SqlType.ALTER;
        } else if (sqlStmt instanceof CreateIndex) {
            return SqlType.CREATEINDEX;
        } else if (sqlStmt instanceof CreateTable) {
            return SqlType.CREATETABLE;
        } else if (sqlStmt instanceof CreateView) {
            return SqlType.CREATEVIEW;
        } else if (sqlStmt instanceof Delete) {
            return SqlType.DELETE;
        } else if (sqlStmt instanceof Drop) {
            return SqlType.DROP;
        } else if (sqlStmt instanceof Execute) {
            return SqlType.EXECUTE;
        } else if (sqlStmt instanceof Insert) {
            return SqlType.INSERT;
        } else if (sqlStmt instanceof Merge) {
            return SqlType.MERGE;
        } else if (sqlStmt instanceof Replace) {
            return SqlType.REPLACE;
        } else if (sqlStmt instanceof Select) {
            return SqlType.SELECT;
        } else if (sqlStmt instanceof Truncate) {
            return SqlType.TRUNCATE;
        } else if (sqlStmt instanceof Update) {
            return SqlType.UPDATE;
        } else if (sqlStmt instanceof Upsert) {
            return SqlType.UPSERT;
        } else {
            return SqlType.NONE;
        }
    }

}
