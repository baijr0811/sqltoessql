package com.baijr.essql.essqlbuild.Utils;

import com.baijr.essql.essqlbuild.express.SortBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HSort {

    private static final String SORT_NAME = "sort";

    public static SortBuilder ASC(String sortField) {
        return new SortBuilder(SORT_NAME).ASC(sortField);
    }

    public static SortBuilder DESC(String sortField) {
        return new SortBuilder(SORT_NAME).DESC(sortField);
    }
}