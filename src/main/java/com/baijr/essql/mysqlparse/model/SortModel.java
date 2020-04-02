package com.baijr.essql.mysqlparse.model;

public class SortModel {

    private String field;

    private String orderBy;

    public SortModel(String field, String orderBy) {
        this.field = field;
        this.orderBy = orderBy;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
