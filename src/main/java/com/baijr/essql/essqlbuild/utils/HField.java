package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.FieldBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HField {

    private static final String TERM_NAME = "term";
    private static final String TERMS_NAME = "terms";
    private static final String EXISTS_NAME = "exists";
    private static final String GT_NAME = "gt";
    private static final String GTE_NAME = "gte";
    private static final String LT_NAME = "lt";
    private static final String LTE_NAME = "lte";



    public static FieldBuilder NotNULL(String...fields) {
        return new FieldBuilder(EXISTS_NAME).NotNULL(fields);
    }

    public static FieldBuilder In(String field, String... value) {
        return new FieldBuilder(TERMS_NAME).In(field, value);
    }

    public static FieldBuilder Equal(String field, String value) {
        return new FieldBuilder(TERM_NAME).Equal(field, value);
    }

    public static FieldBuilder Then(String field, String value) {
        return new FieldBuilder(GT_NAME).Then(field, value);
    }

    public static FieldBuilder ThenEqual(String field, String value) {
        return new FieldBuilder(GTE_NAME).ThenEqual(field, value);
    }

    public static FieldBuilder Less(String field, String value) {
        return new FieldBuilder(LT_NAME).Less(field, value);
    }

    public static FieldBuilder LessEqual(String field, String value) {
        return new FieldBuilder(LTE_NAME).LessEqual(field, value);

    }

}
