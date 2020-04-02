package com.baijr.essql.essqlbuild.express;

public abstract class Query implements Search {

    protected String queryKey;
    protected String templete;

    Query(String queryKey, String templete) {
        this.queryKey = queryKey;
        this.templete = templete;
    }


    @Override
    public String ESSQL() {
        return queryKey + templete;
    }
}
