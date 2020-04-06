package com.baijr.es2sql.essqlbuild.utils;

import com.baijr.es2sql.essqlbuild.builder.BoolBuilder;
import com.baijr.es2sql.essqlbuild.builder.QueryBuilder;
import com.baijr.es2sql.essqlbuild.builder.SortBuilder;


/**
 * @author baijr
 * @date 2020-04-03
 */
public class HBuilder {

    private static final String QUERY_NAME = "query";

    public static QueryBuilder Builder() {
        return new QueryBuilder(QUERY_NAME);
    }

    public static QueryBuilder Bool(BoolBuilder boolBuilder) {
        return new QueryBuilder(QUERY_NAME).Bool(boolBuilder);
    }

    public static QueryBuilder Sorts(SortBuilder sortBuilder) {
        return new QueryBuilder(QUERY_NAME).Sort(sortBuilder);
    }


    public static QueryBuilder Fields(String... fields) {
        return new QueryBuilder(QUERY_NAME).Fields(fields);
    }


}
