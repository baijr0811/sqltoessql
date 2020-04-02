package com.baijr.essql.mysqlparse.model;

import com.baijr.essql.mysqlparse.WhereType;

class WhereModel {

    private WhereType whereType;

    private String fieldName;

    private String fieldValue;

    WhereModel(WhereType whereType, String fieldName) {

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

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
