package com.baijr.es2sql;

import com.baijr.es2sql.essqlbuild.builder.Query;
import com.baijr.es2sql.mysqlparse.ParserUitls;


/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParseES {

    public static String ToESSql(String sql) {
        Query query = ParserUitls.ParesQuery(sql);
        return query.ESSQL();
    }
}
