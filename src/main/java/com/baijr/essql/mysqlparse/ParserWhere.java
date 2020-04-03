package com.baijr.essql.mysqlparse;

import com.baijr.essql.essqlbuild.builder.QueryBuilder;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;

/**
 * @author baijr
 * @date 2020-04-03
 * 构建查询语句
 */
public class ParserWhere {

    public static void SelectWhere(PlainSelect plainSelect, QueryBuilder query) {
        Expression expression = plainSelect.getWhere();
        if (expression == null) {
            EachBool(expression, query);
        }
    }

    static void EachBool(Expression expression, QueryBuilder query) {
        if (expression instanceof OrExpression) {
            OrExpression orExpression = ((OrExpression) expression);


        } else if (expression instanceof AndExpression) {


        } else if (expression instanceof InExpression) {


        } else if (expression instanceof IsNullExpression) {
            {
                if (((IsNullExpression) expression).isNot()) {

                } else {

                }
            }
        }

    }

    static void ParseExpress(Expression expression, QueryBuilder query) {

        if (expression instanceof EqualsTo) {
        } else if (expression instanceof MinorThan) {
        } else if (expression instanceof MinorThanEquals) {
        } else if (expression instanceof GreaterThan) {
        } else if (expression instanceof GreaterThanEquals) {
        } else if (expression instanceof NotEqualsTo) {
        } else if (expression instanceof Parenthesis) {
        }

    }


    // and (a=1 or b=2)
    static void EachParenthesis() {

    }

    static void Or2Model(OrExpression orExpression) {

    }

    static void And2Model(AndExpression expression) {

    }

    static void EqualsTo2Model(EqualsTo express) {
        if (express.getLeftExpression() instanceof Column) {
            Expression value = express.getRightExpression();
            if (ValueCheck(value)) {

            }
            throw new RuntimeException(express.getStringExpression() + "右叶子， 解析不了 ");
        } else {
            throw new RuntimeException(express.getStringExpression() + " 左叶子，解析不了 ");
        }
    }

    static void MinorThano2Model(OrExpression expression) {

    }

    static void MinorThanEquals2Model(OrExpression orExpression) {

    }

    static void GreaterThan2Model(OrExpression orExpression) {

    }

    static void GreaterThanEquals2Model(OrExpression orExpression) {

    }


    static void NotEqualsTo2Model(OrExpression orExpression) {

    }

    static void InTo2Model(OrExpression orExpression) {

    }


    static void NOTNULL2Model(OrExpression orExpression) {

    }

    static void NULL2Model(OrExpression orExpression) {

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
