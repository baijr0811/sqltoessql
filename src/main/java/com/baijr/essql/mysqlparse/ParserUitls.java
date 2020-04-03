package com.baijr.essql.mysqlparse;

import com.baijr.essql.mysqlparse.model.ParseModel;
import com.baijr.essql.mysqlparse.model.SortModel;
import com.baijr.essql.mysqlparse.model.WhereListModel;
import com.baijr.essql.mysqlparse.parser.SqlParser;
import com.baijr.essql.mysqlparse.parser.SqlType;
import com.baijr.essql.mysqlparse.parser.SqlWhereParser;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.ArrayList;
import java.util.List;

public class ParserUitls {

    public static ParseModel GetParesModel(String sql) {
        ParseModel parseModel = new ParseModel();
        PlainSelect plainSelect = GetPlainSelect(sql);
        List<String> fileds = SqlParser.SelectField(plainSelect);
        Limit limit = SqlParser.SelectLimit(plainSelect);
        List<OrderByElement> orderByElements = SqlParser.SelectOrderby(plainSelect);
        List<WhereListModel> whereListModels = SqlWhereParser.SelectWhere(plainSelect);
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
            throw new RuntimeException("SQL拼写错误");
        }
        if (SqlParser.GetSqlType(stmt).equals(SqlType.SELECT)) {
            return (PlainSelect) ((Select) stmt).getSelectBody();
        }
        throw new RuntimeException("暂时只支持SELECT");
    }

}
