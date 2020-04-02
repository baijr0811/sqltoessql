package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.BoolBaseBuilderBuiler;
import com.baijr.essql.essqlbuild.builder.BaseBuilderBuilder;
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


    public static BaseBuilderBuilder Builder() {
        return new BaseBuilderBuilder(QUERY_NAME);
    }

    public static BaseBuilderBuilder Bool(BoolBaseBuilderBuiler boolQueryBuiler) {
        return new BaseBuilderBuilder(BOOL_NAME).Bool(boolQueryBuiler);
    }

    public static BaseBuilderBuilder Sorts(SortBuilder sortBuilder) {
        return new BaseBuilderBuilder(SORT_NAME).Sorts(sortBuilder);
    }


    public static BaseBuilderBuilder Fields(String... fields) {
        return new BaseBuilderBuilder(SOURCE_NAME).Fields(fields);
    }


}
