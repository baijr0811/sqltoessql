package com.baijr.essql.essqlbuild;

import com.baijr.essql.essqlbuild.express.ExpressBuilder;
import com.baijr.essql.essqlbuild.express.BoolQueryBuiler;
import com.baijr.essql.essqlbuild.express.QueryBuilder;

public class BuilderHelper {
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

    public static QueryBuilder Builder(String templete) {
        return new QueryBuilder(QUERY_NAME, templete);
    }

    public static QueryBuilder bool(String templete) {
        return new QueryBuilder(BOOL_NAME, templete);
    }

    public static QueryBuilder sort(String templete) {
        return new QueryBuilder(SORT_NAME, templete);
    }

    public static QueryBuilder field(String templete) {
        return new QueryBuilder(SOURCE_NAME, templete);
    }

    public static BoolQueryBuiler must(String templete) {
        return new BoolQueryBuiler(MUST_NAME, templete);

    }

    public static BoolQueryBuiler should(String templete) {
        return new BoolQueryBuiler(SHOULD_NAME, templete);
    }

    public static BoolQueryBuiler mustnot(String templete) {
        return new BoolQueryBuiler(MUST_NOT_NAME, templete);
    }


    public static ExpressBuilder trem(String templete) {
        return new ExpressBuilder(TERM_NAME, templete);
    }

    public static ExpressBuilder trems(String templete) {
        return new ExpressBuilder(TERMS_NAME, templete);
    }

    public static ExpressBuilder exists(String templete) {
        return new ExpressBuilder(EXISTS_NAME, templete);
    }

    public static ExpressBuilder gt(String templete) {
        return new ExpressBuilder(GT_NAME, templete);
    }

    public static ExpressBuilder gte(String templete) {
        return new ExpressBuilder(GTE_NAME, templete);
    }

    public static ExpressBuilder lt(String templete) {
        return new ExpressBuilder(LT_NAME, templete);
    }

    public static ExpressBuilder lte(String templete) {
        return new ExpressBuilder(LTE_NAME, templete);

    }
}
