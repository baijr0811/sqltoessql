package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.BoolBuilder;
import com.baijr.essql.essqlbuild.builder.ExpressBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HWhere {

    private static final String MUST_NAME = "must";
    private static final String SHOULD_NAME = "should";
    private static final String MUST_NOT_NAME = "must_not";

    public static BoolBuilder AND(ExpressBuilder expressBuilder) {
        return new BoolBuilder(MUST_NAME).AND(expressBuilder);

    }

    public static BoolBuilder OR(ExpressBuilder expressBuilder) {
        return new BoolBuilder(SHOULD_NAME).OR(expressBuilder);
    }

    public static BoolBuilder ANDNOT(ExpressBuilder expressBuilder) {
        return new BoolBuilder(MUST_NOT_NAME).ANDNOT(expressBuilder);
    }
}
