package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.BoolBuilder;
import com.baijr.essql.essqlbuild.builder.QueryBuilder;
import com.baijr.essql.essqlbuild.builder.SortBuilder;


/**
 * @author baijr
 * @date 2020-04-03
 */
public class HBuilder {
    private static final String QUERY_NAME = "query";

    private static final String BOOL_NAME = "bool";
    private static final String SORT_NAME = "sort";
    private static final String SOURCE_NAME = "_source";


    public static QueryBuilder Builder() {
        return new QueryBuilder(QUERY_NAME);
    }

    public static QueryBuilder Bool(BoolBuilder boolBuilder) {
        return new QueryBuilder(BOOL_NAME).Bool(boolBuilder);
    }

    public static QueryBuilder Sorts(SortBuilder sortBuilder) {
        return new QueryBuilder(SORT_NAME).Sorts(sortBuilder);
    }


    public static QueryBuilder Fields(String... fields) {
        return new QueryBuilder(SOURCE_NAME).Fields(fields);
    }


}
