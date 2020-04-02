package com.baijr.essql.essqlbuild.express;

/**
 * @author  baijr
 * @date 2020-04-03
 */
public abstract class Query implements Search {

    protected String queryKey;

    protected Query(String queryKey) {
        this.queryKey = queryKey;
    }

    @Override
    public abstract String ESSQL();
}
