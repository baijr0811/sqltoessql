package com.baijr.essql;

import com.baijr.essql.mysqlparse.ParseModel;
import com.baijr.essql.mysqlparse.SqlParser;
import com.baijr.essql.mysqlparse.SqlType;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;


/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParseES {

    public static String Sql2ESSql(String sql) {
        ParseModel parseModel = SqlParser.GetParesModel(sql);
        return null;
    }
}
