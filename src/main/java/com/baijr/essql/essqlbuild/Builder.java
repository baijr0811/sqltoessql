package com.baijr.essql.essqlbuild;

import com.baijr.essql.essqlbuild.express.ExpressBuilder;
import com.baijr.essql.essqlbuild.express.BoolQueryBuiler;
import com.baijr.essql.essqlbuild.express.QueryBuilder;
import com.baijr.essql.essqlbuild.express.SortBuilder;


/**
 * @author  baijr
 * @date 2020-04-03
 */
public class Builder {
    private static final String QUERY_NAME = "query";

    private static final String BOOL_NAME = "bool";
    private static final String SORT_NAME = "sort";
    private static final String SOURCE_NAME = "_source";

    private static final String MUST_NAME = "must";
    private static final String SHOULD_NAME = "should";
    private static final String MUST_NOT_NAME = "must_not";


    private static final String TERM_NAME = "term";
    private static final String TERMS_NAME = "terms";
    private static final String EXISTS_NAME = "exists";
    private static final String GT_NAME = "gt";
    private static final String GTE_NAME = "gte";
    private static final String LT_NAME = "lt";
    private static final String LTE_NAME = "lte";

    public static QueryBuilder Builder() {
        return new QueryBuilder(QUERY_NAME);
    }

    public static QueryBuilder Bool(BoolQueryBuiler boolQueryBuiler) {
        return new QueryBuilder(BOOL_NAME).Bool(boolQueryBuiler);
    }

    public static QueryBuilder Sorts(SortBuilder sortBuilder) {
        return new QueryBuilder(SORT_NAME).Sorts(sortBuilder);
    }

    public static SortBuilder ASC(String sortField) {
        return new SortBuilder(SORT_NAME).ASC(sortField);
    }

    public static SortBuilder DESC(String sortField) {
        return new SortBuilder(SORT_NAME).DESC(sortField);
    }

    public static QueryBuilder Fields(String... fields) {
        return new QueryBuilder(SOURCE_NAME).Fields(fields);
    }

    public static BoolQueryBuiler AND(ExpressBuilder expressBuilder) {
        return new BoolQueryBuiler(MUST_NAME).AND(expressBuilder);

    }

    public static BoolQueryBuiler OR(ExpressBuilder expressBuilder) {
        return new BoolQueryBuiler(SHOULD_NAME).OR(expressBuilder);
    }

    public static BoolQueryBuiler NOT(ExpressBuilder expressBuilder) {
        return new BoolQueryBuiler(MUST_NOT_NAME).NOT(expressBuilder);
    }

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
