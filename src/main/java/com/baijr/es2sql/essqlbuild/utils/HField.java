package com.baijr.es2sql.essqlbuild.utils;

import com.baijr.es2sql.essqlbuild.builder.BaseBuilder;
import com.baijr.es2sql.essqlbuild.builder.BoolBuilder;
import com.baijr.es2sql.essqlbuild.builder.FieldBuilder;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class HField {

    private static final String Field_NAME = "fields";


    public static FieldBuilder NotNULL(String... fields) {
        return new FieldBuilder(Field_NAME).NotNULL(fields);
    }

    public static FieldBuilder NULL(String... fields) {
        return new FieldBuilder(Field_NAME).NULL(fields);
    }

    public static FieldBuilder In(String field, String... value) {
        return new FieldBuilder(Field_NAME).In(field, value);
    }

    public static FieldBuilder Equal(String field, String value) {
        return new FieldBuilder(Field_NAME).Equal(field, value);
    }

    public static FieldBuilder NotEqual(String field, String value) {
        return new FieldBuilder(Field_NAME).NotEqual(field, value);
    }


    public static FieldBuilder Then(String field, String value) {
        return new FieldBuilder(Field_NAME).Then(field, value);
    }

    public static FieldBuilder ThenEqual(String field, String value) {
        return new FieldBuilder(Field_NAME).ThenEqual(field, value);
    }

    public static FieldBuilder Less(String field, String value) {
        return new FieldBuilder(Field_NAME).Less(field, value);
    }

    public static FieldBuilder LessEqual(String field, String value) {
        return new FieldBuilder(Field_NAME).LessEqual(field, value);

    }

    public static BaseBuilder ChildBool(BoolBuilder boolBuilder) {
        return new FieldBuilder(Field_NAME).ChildBool(boolBuilder);

    }

}
