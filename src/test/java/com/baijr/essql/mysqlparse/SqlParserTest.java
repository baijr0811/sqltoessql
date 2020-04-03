package com.baijr.essql.mysqlparse;


import net.sf.jsqlparser.JSQLParserException;
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


        String sql1 = " select * from t";

        Statement stmt = null;
        try {
            stmt = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            throw new RuntimeException("SQL 太复杂了，请喝杯茶再来");
        }

    }

}
