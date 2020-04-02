package com.baijr.essql.essqlbuild.Utils;

import com.baijr.essql.essqlbuild.express.BoolQueryBuiler;
import com.baijr.essql.essqlbuild.express.ExpressBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HWhere {

    private static final String MUST_NAME = "must";
    private static final String SHOULD_NAME = "should";
    private static final String MUST_NOT_NAME = "must_not";

    public static BoolQueryBuiler AND(ExpressBuilder expressBuilder) {
        return new BoolQueryBuiler(MUST_NAME).AND(expressBuilder);

    }

    public static BoolQueryBuiler OR(ExpressBuilder expressBuilder) {
        return new BoolQueryBuiler(SHOULD_NAME).OR(expressBuilder);
    }

    public static BoolQueryBuiler NOT(ExpressBuilder expressBuilder) {
        return new BoolQueryBuiler(MUST_NOT_NAME).NOT(expressBuilder);
    }
}
