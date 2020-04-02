package com.baijr.essql.mysqlparse;


import com.baijr.essql.essqlbuild.model.Express;
import com.baijr.essql.mysqlparse.model.WhereListModel;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParserTest {

    public static void main(String[] args) {
        String sql = " select a,b,c from t" +
                " where a=1 and b=2 and c in(1,2,3) and d>5 and f<=6 and (x=1 or y=2) and z is not null " +
                "or w is null and c=3 " +
                "or ax=3" +
                " order by c asc ,d desc " +
                " limit 1,2";

        Statement stmt = null;
        try {
            stmt = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            throw new RuntimeException("SQL 太复杂了，请喝杯茶再来");
        }

        if (SqlParser.GetSqlType(stmt).equals(SqlType.SELECT)) {
            PlainSelect plainSelect = (PlainSelect) ((Select) stmt).getSelectBody();
            List<String> fileds = SqlParser.SelectField(plainSelect);
            Limit limit = SqlParser.SelectLimit(plainSelect);
            List<OrderByElement> orderByElements = SqlParser.SelectOrderby(plainSelect);
            List<WhereListModel> whereListModels = SqlParser.SelectWhere(plainSelect);
            GroupByElement groupByElement = SqlParser.SelectGroupby(plainSelect);
        }


    }

}
