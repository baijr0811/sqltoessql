package com.baijr.es2sql.essqlbuild.utils;

import com.baijr.es2sql.essqlbuild.builder.BoolBuilder;
import com.baijr.es2sql.essqlbuild.builder.FieldBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HWhere {

    private static final String BOOL_NAME = "bool";

    public static BoolBuilder AND(FieldBuilder fieldBuilder) {
        return new BoolBuilder(BOOL_NAME).AND(fieldBuilder);

    }

    public static BoolBuilder OR(FieldBuilder fieldBuilder) {
        return new BoolBuilder(BOOL_NAME).OR(fieldBuilder);
    }

    public static BoolBuilder NOT(FieldBuilder fieldBuilder) {
        return new BoolBuilder(BOOL_NAME).NOT(fieldBuilder);
    }
}
