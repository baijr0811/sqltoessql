package com.baijr.es2sql.essqlbuild.model;


/**
 * @author  baijr
 * @date 2020-04-03
 */
public class Sort {

    private String orderby;

    private String filed;

    public Sort(String filed, String orderby) {
        this.orderby = orderby;
        this.filed = filed;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }
}
