package com.baijr.essql;

import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.arithmetic.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
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
 */
public class SqlParser {


    static String SelectField(PlainSelect plainSelect) {
        List<SelectItem> selectitems = plainSelect.getSelectItems();
        if (selectitems != null) {
            for (SelectItem selectItem : selectitems) {
                selectItem.accept(new SelectItemVisitorAdapter() {
                    @Override
                    public void visit(SelectExpressionItem item) {
                        if (item.getExpression() instanceof Column) {
                            String name = ((Column) item.getExpression()).getColumnName();
                        }
                    }
                });
            }
        }
        return "";
    }

    static String SelectWhere(PlainSelect plainSelect) {
        Expression expression = plainSelect.getWhere();
        List<String> fields = new ArrayList<>();
        expression.accept(new ExpressionVisitor() {
            @Override
            public void visit(BitwiseRightShift bitwiseRightShift) {

            }

            @Override
            public void visit(BitwiseLeftShift bitwiseLeftShift) {

            }

            @Override
            public void visit(NullValue nullValue) {

            }

            @Override
            public void visit(Function function) {

            }

            @Override
            public void visit(SignedExpression signedExpression) {

            }

            @Override
            public void visit(JdbcParameter jdbcParameter) {

            }

            @Override
            public void visit(JdbcNamedParameter jdbcNamedParameter) {

            }

            @Override
            public void visit(DoubleValue doubleValue) {

            }

            @Override
            public void visit(LongValue longValue) {

            }

            @Override
            public void visit(HexValue hexValue) {

            }

            @Override
            public void visit(DateValue dateValue) {

            }

            @Override
            public void visit(TimeValue timeValue) {

            }

            @Override
            public void visit(TimestampValue timestampValue) {

            }

            @Override
            public void visit(Parenthesis parenthesis) {

            }

            @Override
            public void visit(StringValue stringValue) {

            }

            @Override
            public void visit(Addition addition) {

            }

            @Override
            public void visit(Division division) {

            }

            @Override
            public void visit(IntegerDivision integerDivision) {

            }

            @Override
            public void visit(Multiplication multiplication) {

            }

            @Override
            public void visit(Subtraction subtraction) {

            }

            @Override
            public void visit(AndExpression andExpression) {

            }

            @Override
            public void visit(OrExpression orExpression) {

            }

            @Override
            public void visit(Between between) {

            }

            @Override
            public void visit(EqualsTo equalsTo) {

            }

            @Override
            public void visit(GreaterThan greaterThan) {

            }

            @Override
            public void visit(GreaterThanEquals greaterThanEquals) {

            }

            @Override
            public void visit(InExpression inExpression) {

            }

            @Override
            public void visit(FullTextSearch fullTextSearch) {

            }

            @Override
            public void visit(IsNullExpression isNullExpression) {

            }

            @Override
            public void visit(IsBooleanExpression isBooleanExpression) {

            }

            @Override
            public void visit(LikeExpression likeExpression) {

            }

            @Override
            public void visit(MinorThan minorThan) {

            }

            @Override
            public void visit(MinorThanEquals minorThanEquals) {

            }

            @Override
            public void visit(NotEqualsTo notEqualsTo) {

            }

            @Override
            public void visit(Column column) {

            }

            @Override
            public void visit(SubSelect subSelect) {

            }

            @Override
            public void visit(CaseExpression caseExpression) {

            }

            @Override
            public void visit(WhenClause whenClause) {

            }

            @Override
            public void visit(ExistsExpression existsExpression) {

            }

            @Override
            public void visit(AllComparisonExpression allComparisonExpression) {

            }

            @Override
            public void visit(AnyComparisonExpression anyComparisonExpression) {

            }

            @Override
            public void visit(Concat concat) {

            }

            @Override
            public void visit(Matches matches) {

            }

            @Override
            public void visit(BitwiseAnd bitwiseAnd) {

            }

            @Override
            public void visit(BitwiseOr bitwiseOr) {

            }

            @Override
            public void visit(BitwiseXor bitwiseXor) {

            }

            @Override
            public void visit(CastExpression castExpression) {

            }

            @Override
            public void visit(Modulo modulo) {

            }

            @Override
            public void visit(AnalyticExpression analyticExpression) {

            }

            @Override
            public void visit(ExtractExpression extractExpression) {

            }

            @Override
            public void visit(IntervalExpression intervalExpression) {

            }

            @Override
            public void visit(OracleHierarchicalExpression oracleHierarchicalExpression) {

            }

            @Override
            public void visit(RegExpMatchOperator regExpMatchOperator) {

            }

            @Override
            public void visit(JsonExpression jsonExpression) {

            }

            @Override
            public void visit(JsonOperator jsonOperator) {

            }

            @Override
            public void visit(RegExpMySQLOperator regExpMySQLOperator) {

            }

            @Override
            public void visit(UserVariable userVariable) {

            }

            @Override
            public void visit(NumericBind numericBind) {

            }

            @Override
            public void visit(KeepExpression keepExpression) {

            }

            @Override
            public void visit(MySQLGroupConcat mySQLGroupConcat) {

            }

            @Override
            public void visit(ValueListExpression valueListExpression) {

            }

            @Override
            public void visit(RowConstructor rowConstructor) {

            }

            @Override
            public void visit(OracleHint oracleHint) {

            }

            @Override
            public void visit(TimeKeyExpression timeKeyExpression) {

            }

            @Override
            public void visit(DateTimeLiteralExpression dateTimeLiteralExpression) {

            }

            @Override
            public void visit(NotExpression notExpression) {

            }

            @Override
            public void visit(NextValExpression nextValExpression) {

            }

            @Override
            public void visit(CollateExpression collateExpression) {

            }

            @Override
            public void visit(SimilarToExpression similarToExpression) {

            }

            @Override
            public void visit(ArrayExpression arrayExpression) {

            }
        });

        return "";
    }

    public static Limit SelectLimit(PlainSelect plainSelect) {
        return plainSelect.getLimit();
    }


    private static List<String> SelectGroupby(PlainSelect plainSelect) {
        GroupByElement GroupByColumnReferences = plainSelect.getGroupBy();
        return null;
    }

    /**
     * 查询order by
     */
    private static List<OrderByElement> SelectOrderby(PlainSelect plainSelect) {
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
