package com.baijr.essql.essqlbuild.utils;

import com.baijr.essql.essqlbuild.builder.BoolBuilder;
import com.baijr.essql.essqlbuild.builder.FieldBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HWhere {

    private static final String MUST_NAME = "must";
    private static final String SHOULD_NAME = "should";
    private static final String MUST_NOT_NAME = "must_not";

    private static final String BOOL_NAME = "bool";

    public static BoolBuilder AND(FieldBuilder fieldBuilder) {
        return new BoolBuilder(BOOL_NAME).AND(fieldBuilder);

    }

    public static BoolBuilder OR(FieldBuilder fieldBuilder) {
        return new BoolBuilder(BOOL_NAME).OR(fieldBuilder);
    }

    public static BoolBuilder ANDNOT(FieldBuilder fieldBuilder) {
        return new BoolBuilder(BOOL_NAME).ANDNOT(fieldBuilder);
    }
}
