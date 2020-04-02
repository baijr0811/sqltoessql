package com.baijr.essql.essqlbuild.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  baijr
 * @date 2020-04-03
 */
public class Express {

    private String expressType;

    private String filed;

    private List<String> values = new ArrayList<String>();

    public Express(String expressType, String field, String value) {
        this.expressType = expressType;
        this.filed = field;
        this.values.add(value);
    }

    public Express(String expressType, String filed) {
        this.expressType = expressType;
        this.filed = filed;
    }

    public Express(String expressType, String filed, List<String> values) {
        this.expressType = expressType;
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
