package com.baijr.essql.mysqlparse.parser;

import com.baijr.essql.mysqlparse.model.WhereListModel;
import com.baijr.essql.mysqlparse.model.WhereModel;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class SqlWhereParser {


    public static List<WhereListModel> SelectWhere(PlainSelect plainSelect) {
        Expression expression = plainSelect.getWhere();
        if (expression == null) {
            return null;
        }

        List<WhereListModel> whereListModels = new ArrayList<>();
        EachOrExpress(whereListModels, expression);
        return whereListModels;
    }

    static void EachOrExpress(List<WhereListModel> whereListModels, Expression expression) {
        WhereType whereType = GetWhereType(expression);
        if (whereType == WhereType.OR) {
            OrExpression orExpression = ((OrExpression) expression);
            if (GetWhereType(orExpression.getRightExpression()) == WhereType.IN) {

            }
            EachOrExpress(whereListModels, orExpression.getLeftExpression());
        }
    }

    static WhereModel ParseModel(Expression expression) {
        switch (GetWhereType(expression)) {
            case AND:
                return And2Model((AndExpression) expression);
            default:
                return null;
        }
    }


    // and (a=1 or b=2)
    static void EachParenthesis() {

    }

    static void Or2Model(OrExpression orExpression) {

    }

    static WhereModel And2Model(AndExpression expression) {
        if (expression.getLeftExpression() instanceof Column) {
            Expression value = expression.getRightExpression();
            if (ValueCheck(value)) {
                return new WhereModel(WhereType.AND, value.toString());
            }
            throw new RuntimeException(expression.getStringExpression() + "右叶子， 解析不了 ");
        }
        throw new RuntimeException(expression.getStringExpression() + " 左叶子，解析不了 ");
    }

    static void EqualsTo2Model(OrExpression orExpression, WhereModel whereModel) {

    }

    static void MinorThano2Model(OrExpression orExpression, WhereModel whereModel) {

    }

    static void MinorThanEquals2Model(OrExpression orExpression, WhereModel whereModel) {

    }

    static void GreaterThan2Model(OrExpression orExpression, WhereModel whereModel) {

    }

    static void GreaterThanEquals2Model(OrExpression orExpression, WhereModel whereModel) {

    }


    static void NotEqualsTo2Model(OrExpression orExpression, WhereModel whereModel) {

    }

    static void InTo2Model(OrExpression orExpression, WhereModel whereModel) {

    }


    static void NOTNULL2Model(OrExpression orExpression, WhereModel whereModel) {

    }

    static void NULL2Model(OrExpression orExpression, WhereModel whereModel) {

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


}
