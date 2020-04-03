package com.baijr.essql.mysqlparse.model;

import com.baijr.essql.mysqlparse.parser.WhereType;

/**
 * @author baijr
 * @date 2020-04-01
 * WHERE字段属性
 */
public class WhereModel {

    private WhereType whereType;

    private String fieldName;

    private Object fieldValue;

    public WhereModel(WhereType whereType, String fieldName) {

        this.whereType = whereType;
        this.fieldName = fieldName;
    }

    WhereModel(WhereType whereType, String fieldName, String fieldValue) {
        this.whereType = whereType;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public WhereType getWhereType() {
        return whereType;
    }

    public void setWhereType(WhereType whereType) {
        this.whereType = whereType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
}
