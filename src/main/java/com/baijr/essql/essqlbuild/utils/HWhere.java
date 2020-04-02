package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.BoolBaseBuilder;
import com.baijr.essql.essqlbuild.builder.ExpressBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HWhere {

    private static final String MUST_NAME = "must";
    private static final String SHOULD_NAME = "should";
    private static final String MUST_NOT_NAME = "must_not";

    public static BoolBaseBuilder AND(ExpressBuilder expressBuilder) {
        return new BoolBaseBuilder(MUST_NAME).AND(expressBuilder);

    }

    public static BoolBaseBuilder OR(ExpressBuilder expressBuilder) {
        return new BoolBaseBuilder(SHOULD_NAME).OR(expressBuilder);
    }

    public static BoolBaseBuilder NOT(ExpressBuilder expressBuilder) {
        return new BoolBaseBuilder(MUST_NOT_NAME).NOT(expressBuilder);
    }
}
