package com.baijr.essql.essqlbuild.express;


import java.util.ArrayList;
import java.util.List;

public class ExpressBuilder extends Query {

    private final List<Query> termList = new ArrayList<Query>();
    private final List<Query> termsList = new ArrayList<Query>();
    private final List<Query> existsList = new ArrayList<Query>();
    private final List<Query> gtList = new ArrayList<Query>();
    private final List<Query> ltList = new ArrayList<Query>();
    private final List<Query> lteList = new ArrayList<Query>();
    private final List<Query> gteList = new ArrayList<Query>();

    public ExpressBuilder(String queryKey, String templete) {
        super(queryKey, templete);
    }


    public ExpressBuilder trem(ExpressBuilder expressBuilder) {
        termList.add(expressBuilder);
        return this;
    }

    public ExpressBuilder trems(ExpressBuilder expressBuilder) {
        termsList.add(expressBuilder);
        return this;
    }

    public ExpressBuilder exists(ExpressBuilder expressBuilder) {
        existsList.add(expressBuilder);
        return this;

    }

    public ExpressBuilder gt(ExpressBuilder expressBuilder) {
        gtList.add(expressBuilder);
        return this;
    }

    public ExpressBuilder gte(ExpressBuilder expressBuilder) {
        gteList.add(expressBuilder);
        return this;
    }

    public ExpressBuilder lt(ExpressBuilder expressBuilder) {
        ltList.add(expressBuilder);
        return this;

    }

    public ExpressBuilder lte(ExpressBuilder expressBuilder) {
        lteList.add(expressBuilder);
        return this;
    }

    @Override
    public String ESSQL() {
        return null;
    }
}
