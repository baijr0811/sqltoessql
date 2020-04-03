package com.baijr.essql.mysqlparse.parser;

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


    public static List<String> SelectField(PlainSelect plainSelect) {
        final List<String> fileds = new ArrayList<>();
        List<SelectItem> selectitems = plainSelect.getSelectItems();
        if (selectitems != null) {
            for (SelectItem selectItem : selectitems) {
                selectItem.accept(new SelectItemVisitorAdapter() {
                    @Override
                    public void visit(SelectExpressionItem item) {
                        if (item.getExpression() instanceof Column) {
                            fileds.add(((Column) item.getExpression()).getColumnName());
                        }
                    }

                    @Override
                    public void visit(AllColumns columns) {
                        fileds.add("*");
                    }
                });
            }
        }
        if (fileds.size() == 0) {
            throw new RuntimeException("SELECT 字段暂时解析不了，只支持Column查询");
        }

        return fileds;
    }


    public static Limit SelectLimit(PlainSelect plainSelect) {
        return plainSelect.getLimit();
    }

    public static GroupByElement SelectGroupby(PlainSelect plainSelect) {
        return plainSelect.getGroupBy();
    }

    public static List<OrderByElement> SelectOrderby(PlainSelect plainSelect) {
        return plainSelect.getOrderByElements();
    }


    public static SqlType GetSqlType(Statement sqlStmt) {
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
