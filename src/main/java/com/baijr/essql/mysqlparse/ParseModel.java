package com.baijr.essql.mysqlparse;

import java.util.List;

/**
 * @author baijr
 * 2020-04-01
 */
public class ParseModel {

    private List<String> fileds;

    private int from;

    private int to;

    private List<ParesSort> paresSorts;

    public List<String> getFileds() {
        return fileds;
    }

    public void setFileds(List<String> fileds) {
        this.fileds = fileds;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<ParesSort> getParesSorts() {
        return paresSorts;
    }

    public void setParesSorts(List<ParesSort> paresSorts) {
        this.paresSorts = paresSorts;
    }
}

class ParesSort {

    private String field;

    private String orderBy;

    ParesSort(String field, String orderBy) {
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
