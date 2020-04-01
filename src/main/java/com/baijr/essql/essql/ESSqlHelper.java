package com.baijr.essql.essql;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;


/**
 * @author baijr
 * @date 2020-04-01
 */
public class ESSqlHelper {

    public static String SqlConvretESSql(String sql) {
        Statement stmt = null;
        try {
            stmt = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
        if (SqlParser.GetSqlType(stmt).equals(SqlType.SELECT)) {
            AnalyzeSql(((PlainSelect) ((Select) stmt).getSelectBody()));
        }
        return "暂时只支持SELECT";
    }

    private static void AnalyzeSql(PlainSelect plainSelect) {

    }

}
