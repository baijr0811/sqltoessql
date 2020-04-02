package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.BoolBaseBuilderBuiler;
import com.baijr.essql.essqlbuild.builder.ExpressBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HWhere {

    private static final String MUST_NAME = "must";
    private static final String SHOULD_NAME = "should";
    private static final String MUST_NOT_NAME = "must_not";

    public static BoolBaseBuilderBuiler AND(ExpressBuilder expressBuilder) {
        return new BoolBaseBuilderBuiler(MUST_NAME).AND(expressBuilder);

    }

    public static BoolBaseBuilderBuiler OR(ExpressBuilder expressBuilder) {
        return new BoolBaseBuilderBuiler(SHOULD_NAME).OR(expressBuilder);
    }

    public static BoolBaseBuilderBuiler NOT(ExpressBuilder expressBuilder) {
        return new BoolBaseBuilderBuiler(MUST_NOT_NAME).NOT(expressBuilder);
    }
}
