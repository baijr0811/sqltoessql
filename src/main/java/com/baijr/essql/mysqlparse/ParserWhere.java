package com.baijr.essql.mysqlparse;

import com.baijr.essql.essqlbuild.builder.BoolBuilder;
import com.baijr.essql.essqlbuild.builder.FieldBuilder;
import com.baijr.essql.essqlbuild.builder.QueryBuilder;
import com.baijr.essql.essqlbuild.utils.HBuilder;
import com.baijr.essql.essqlbuild.utils.HField;
import com.baijr.essql.essqlbuild.utils.HWhere;
import com.sun.org.apache.xpath.internal.operations.Or;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;

import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 * 构建查询语句
 */
public class ParserWhere {

    public static void SelectWhere(PlainSelect plainSelect, QueryBuilder query) {

        Expression expression = plainSelect.getWhere();
        if (expression != null) {
            if (expression instanceof OrExpression) {
                BoolBuilder boolBuilder = new BoolBuilder("bool");
                EachORBool(expression, boolBuilder);
                query.Bool(boolBuilder);
            } else if (expression instanceof AndExpression) {
                FieldBuilder fieldBuilder = new FieldBuilder("fields");
                EachANDBool(expression, fieldBuilder);
                query.Bool(HWhere.AND(fieldBuilder));

            } else {
                FieldBuilder fieldBuilder = new FieldBuilder("fields");
                ParseExpress(expression, fieldBuilder);
                query.Bool(HWhere.AND(fieldBuilder));
            }
        }
    }


    static void EachORBool(Expression expression, BoolBuilder boolBuilder) {
        FieldBuilder fieldBuilder = new FieldBuilder("fields");
        if (expression instanceof AndExpression) {
            EachANDBool(expression, fieldBuilder);
            boolBuilder.OR(fieldBuilder);
        } else if (expression instanceof OrExpression) {
            OrExpression orExpression = (OrExpression) expression;
            EachANDBool(orExpression.getRightExpression(), fieldBuilder);
            boolBuilder.OR(fieldBuilder);
            EachORBool(orExpression.getLeftExpression(), boolBuilder);
        } else {
            ParseExpress(expression, fieldBuilder);
            boolBuilder.OR(fieldBuilder);
        }

    }

    static void EachANDBool(Expression expression, FieldBuilder fieldBuilder) {

        if (expression instanceof AndExpression) {
            AndExpression andExpression = ((AndExpression) expression);
            Expression rightExpression = andExpression.getRightExpression();
            EachANDBool(rightExpression, fieldBuilder);
            Expression leftExpression = andExpression.getLeftExpression();
            EachANDBool(leftExpression, fieldBuilder);
        } else {
            ParseExpress(expression, fieldBuilder);
        }

    }

    static void ParseExpress(Expression expression, FieldBuilder fieldBuilder) {
        if (expression instanceof EqualsTo) {
            EqualsTo equalsTo = ((EqualsTo) expression);
            if (equalsTo.getLeftExpression() instanceof Column && ValueCheck(equalsTo.getRightExpression())) {
                String fieldName = ((Column) equalsTo.getLeftExpression()).getColumnName();
                String value = equalsTo.getRightExpression().toString();
                fieldBuilder.Equal(fieldName, value);
            } else {
                throw new RuntimeException("Where 语句：" + equalsTo.getStringExpression() + "解析不了");
            }
        } else if (expression instanceof MinorThan) {
            MinorThan minorThan = ((MinorThan) expression);
            if (minorThan.getLeftExpression() instanceof Column && ValueCheck(minorThan.getRightExpression())) {
                String fieldName = ((Column) minorThan.getLeftExpression()).getColumnName();
                String value = minorThan.getRightExpression().toString();
                fieldBuilder.Less(fieldName, value);

            } else {
                throw new RuntimeException("Where 语句：" + minorThan.getStringExpression() + "解析不了");
            }

        } else if (expression instanceof MinorThanEquals) {

            MinorThanEquals minorThanEquals = ((MinorThanEquals) expression);
            if (minorThanEquals.getLeftExpression() instanceof Column && ValueCheck(minorThanEquals.getRightExpression())) {
                String fieldName = ((Column) minorThanEquals.getLeftExpression()).getColumnName();
                String value = minorThanEquals.getRightExpression().toString();
                fieldBuilder.LessEqual(fieldName, value);
            } else {
                throw new RuntimeException("Where 语句：" + minorThanEquals.getStringExpression() + "解析不了");
            }

        } else if (expression instanceof GreaterThan) {

            GreaterThan greaterThan = ((GreaterThan) expression);
            if (greaterThan.getLeftExpression() instanceof Column && ValueCheck(greaterThan.getRightExpression())) {
                String fieldName = ((Column) greaterThan.getLeftExpression()).getColumnName();
                String value = greaterThan.getRightExpression().toString();
                fieldBuilder.Then(fieldName, value);
            } else {
                throw new RuntimeException("Where 语句：" + greaterThan.getStringExpression() + "解析不了");
            }

        } else if (expression instanceof GreaterThanEquals) {

            GreaterThanEquals greaterThanEquals = ((GreaterThanEquals) expression);
            if (greaterThanEquals.getLeftExpression() instanceof Column && ValueCheck(greaterThanEquals.getRightExpression())) {
                String fieldName = ((Column) greaterThanEquals.getLeftExpression()).getColumnName();
                String value = greaterThanEquals.getRightExpression().toString();
                fieldBuilder.ThenEqual(fieldName, value);
            } else {
                throw new RuntimeException("Where 语句：" + greaterThanEquals.getStringExpression() + "解析不了");
            }

        } else if (expression instanceof NotEqualsTo) {

            NotEqualsTo notEqualsTo = ((NotEqualsTo) expression);
            if (notEqualsTo.getLeftExpression() instanceof Column) {
                String fieldName = ((Column) notEqualsTo.getLeftExpression()).getColumnName();
                String value = notEqualsTo.getRightExpression().toString();
                fieldBuilder.Equal(fieldName, value);
            } else {
                throw new RuntimeException("Where 语句：" + notEqualsTo.getStringExpression() + "解析不了");
            }

        } else if (expression instanceof IsNullExpression) {
            IsNullExpression isNullExpression = ((IsNullExpression) expression);
            if (isNullExpression.getLeftExpression() instanceof Column) {
                String fieldName = ((Column) isNullExpression.getLeftExpression()).getColumnName();
                if (isNullExpression.isNot()) {
                    fieldBuilder.NotNULL(fieldName);
                }

            } else {
                throw new RuntimeException("Where 语句：" + isNullExpression.toString() + "解析不了");
            }

        } else if (expression instanceof InExpression) {
            InExpression inExpression = ((InExpression) expression);
            if (inExpression.getLeftExpression() instanceof Column) {
                String fieldName = ((Column) inExpression.getLeftExpression()).getColumnName();
                List<Expression> values = ((ExpressionList) inExpression.getRightItemsList()).getExpressions();
                String[] ins = new String[values.size()];
                for (int i = 0; i < values.size(); i++) {
                    if (ValueCheck(values.get(i))) {
                        ins[i] = values.get(i).toString();
                    } else {
                        throw new RuntimeException("Where 语句：" + inExpression.toString() + "解析不了");
                    }
                }
                fieldBuilder.In(fieldName, ins);
            } else {
                throw new RuntimeException("Where 语句：" + inExpression.toString() + "解析不了");
            }

        } else {
            throw new RuntimeException("Where 语句：" + expression.toString() + "解析不了");
        }

    }

    // and (a=1 or b=2)
    static void EachParenthesis() {

    }

    static boolean ValueCheck(Expression expression) {
        if (expression instanceof LongValue) {
            return true;
        }
        if (expression instanceof StringValue) {
            return true;
        }
        if (expression instanceof DoubleValue) {
            return true;
        }
        if (expression instanceof TimestampValue) {
            return true;
        }
        if (expression instanceof DateValue) {
            return true;
        }
        if (expression instanceof TimeValue) {
            return true;
        }
        return false;
    }


}
