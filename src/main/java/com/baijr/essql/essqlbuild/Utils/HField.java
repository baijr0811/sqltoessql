package com.baijr.essql.essqlbuild.Utils;

import com.baijr.essql.essqlbuild.express.ExpressBuilder;

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

    public static ExpressBuilder NotNULL(String field) {
        return new ExpressBuilder(EXISTS_NAME).NotNULL(field);
    }

    public static ExpressBuilder In(String field, String... value) {
        return new ExpressBuilder(TERMS_NAME).In(field, value);
    }

    public static ExpressBuilder Equal(String field, String value) {
        return new ExpressBuilder(TERM_NAME).Equal(field, value);
    }

    public static ExpressBuilder Then(String field, String value) {
        return new ExpressBuilder(GT_NAME).Then(field, value);
    }

    public static ExpressBuilder ThenEqual(String field, String value) {
        return new ExpressBuilder(GTE_NAME).ThenEqual(field, value);
    }

    public static ExpressBuilder Less(String field, String value) {
        return new ExpressBuilder(LT_NAME).Less(field, value);
    }

    public static ExpressBuilder LessEqual(String field, String value) {
        return new ExpressBuilder(LTE_NAME).LessEqual(field, value);

    }

}
