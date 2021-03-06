package com.baijr.es2sql.mysqlparse;

import com.baijr.es2sql.essqlbuild.builder.Query;
import com.baijr.es2sql.essqlbuild.builder.QueryBuilder;
import com.baijr.es2sql.essqlbuild.utils.HBuilder;
import com.baijr.es2sql.essqlbuild.utils.HSort;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */

public class ParserUitls {

    public static Query ParesQuery(String sql) {

        PlainSelect plainSelect = GetPlainSelect(sql);

        //构建查询语句
        QueryBuilder query = HBuilder.Builder();
        ParserFields(plainSelect, query);
        ParserLimit(plainSelect, query);
        ParserSorts(plainSelect, query);
        ParserGroupBy(plainSelect, query);

        ParserWhere.SelectWhere(plainSelect, query);

        return query;
    }

    /**
     * 构建字段
     *
     * @param plainSelect
     * @param query
     */
    static void ParserFields(PlainSelect plainSelect, QueryBuilder query) {
        List<SelectItem> selectitems = plainSelect.getSelectItems();
        if (selectitems != null) {
            for (SelectItem selectItem : selectitems) {
                selectItem.accept(new SelectItemVisitorAdapter() {
                    @Override
                    public void visit(SelectExpressionItem item) {
                        if (item.getExpression() instanceof Column) {
                            query.Fields(((Column) item.getExpression()).getColumnName());
                        } else {
                            throw new RuntimeException("SELECT" + item.getExpression().toString() + "无法解析，只支持Column查询");
                        }
                    }

                    @Override
                    public void visit(AllColumns columns) {
                        query.Fields("*");
                    }
                });
            }
        }
    }

    /**
     * 构建分页
     *
     * @param plainSelect
     * @param query
     */
    static void ParserLimit(PlainSelect plainSelect, QueryBuilder query) {

        Limit limit = plainSelect.getLimit();
        if (limit != null && limit.getOffset() != null) {
            query.From(Integer.parseInt(limit.getOffset().toString()));
        }
        if (limit != null && limit.getRowCount() != null) {
            query.Size(Integer.parseInt(limit.getRowCount().toString()));
        }
    }

    /**
     * 构建排序
     *
     * @param plainSelect
     * @param query
     */
    static void ParserSorts(PlainSelect plainSelect, QueryBuilder query) {
        List<OrderByElement> orderByElements = plainSelect.getOrderByElements();
        if (orderByElements != null && orderByElements.size() > 0) {
            for (OrderByElement orderByElement : orderByElements) {
                if (orderByElement.getExpression() instanceof Column) {
                    String filedName = ((Column) orderByElement.getExpression()).getColumnName();
                    if (orderByElement.isAsc()) {
                        query.Sort(HSort.ASC(filedName));
                    } else {
                        query.Sort(HSort.DESC(filedName));
                    }
                } else {
                    throw new RuntimeException("ORDER BY 太复杂了 ，请喝杯茶再来");
                }
            }
        }
    }

    static void ParserGroupBy(PlainSelect plainSelect, QueryBuilder query) {
        //todo 分组
        GroupByElement groupByElement = plainSelect.getGroupBy();
    }

    static PlainSelect GetPlainSelect(String sql) {
        Statement stmt = null;
        try {
            stmt = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            throw new RuntimeException("SQL拼写错误");
        }
        //只支持查询
        if (stmt instanceof Select) {
            return (PlainSelect) ((Select) stmt).getSelectBody();
        }
        throw new RuntimeException("暂时只支持SELECT");
    }

}
