package com.baijr.essql.mysqlparse.model;

import java.util.List;

/**
 * @author baijr
 * 2020-04-01
 */
public class ParseModel {

    private List<String> fileds;

    private int from;

    private int to;

    private List<SortModel> paresSorts;

    private List<WhereListModel> wheres;

    public List<WhereListModel> getWheres() {
        return wheres;
    }

    public void setWheres(List<WhereListModel> wheres) {
        this.wheres = wheres;
    }

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

    public List<SortModel> getParesSorts() {
        return paresSorts;
    }

    public void setParesSorts(List<SortModel> paresSorts) {
        this.paresSorts = paresSorts;
    }
}





