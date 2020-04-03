package com.baijr.essql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class BoolBaseBuilder extends BaseBuilder {

    private final List<BaseBuilder> mustList = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> shouldList = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> mustnotList = new ArrayList<BaseBuilder>();

    public BoolBaseBuilder(String queryKey) {
        super(queryKey);
    }

    public BoolBaseBuilder AND(ExpressBuilder builder) {
        mustList.add(builder);
        return this;
    }

    public BoolBaseBuilder OR(ExpressBuilder builder) {
        shouldList.add(builder);
        return this;
    }

    public BoolBaseBuilder ANDNOT(ExpressBuilder builder) {
        mustnotList.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey;
    }

    public String SHOUDSQL() {
        return shouldList.toString();
    }

    public String MUSTSQL() {
        return mustList.toString();
    }

    public String MUSTNOTSQL() {
        return mustnotList.toString();
    }
}
