package com.baijr.essql;

import com.baijr.essql.essqlbuild.builder.Query;
import com.baijr.essql.mysqlparse.ParserUitls;


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
