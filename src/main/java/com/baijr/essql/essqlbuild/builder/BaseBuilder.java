package com.baijr.essql.essqlbuild.builder;

/**
 * @author  baijr
 * @date 2020-04-03
 */
public abstract class BaseBuilder implements Query {

    protected String queryKey;

    protected BaseBuilder(String queryKey) {
        this.queryKey = queryKey;
    }

    @Override
    public abstract String ESSQL();
}
