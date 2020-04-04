package com.baijr.essql.essqlbuild.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class Fields {

    private String expressType;

    private String filed;

    private List<String> values = new ArrayList<String>();

    public Fields(List<String> values) {
        this.values = values;
    }

    public Fields(String expressType, String field, String value) {
        this.filed = field;
        this.expressType = expressType;
        this.values.add(value);
    }

    public Fields(String expressType, String filed) {
        this.expressType = expressType;
        this.filed = filed;
    }

    public Fields(String filed, List<String> values) {
        this.filed = filed;
        this.values = values;

    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }
}
