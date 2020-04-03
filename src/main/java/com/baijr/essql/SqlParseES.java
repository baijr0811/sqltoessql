package com.baijr.essql;

import com.baijr.essql.essqlbuild.builder.Query;



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
