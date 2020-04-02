package com.baijr.essql.essqlbuild.express;


import java.util.ArrayList;
import java.util.List;

public class QueryBuilder extends Query {

    private final List<Query> boolList = new ArrayList<Query>();
    private final List<Query> sortList = new ArrayList<Query>();
    private final List<Query> fieldList = new ArrayList<Query>();

    public QueryBuilder(String queryKey, String templete) {
        super(queryKey, templete);
    }

    public QueryBuilder Bool(QueryBuilder builder) {
        boolList.add(builder);
        return this;
    }

    public QueryBuilder Sort(QueryBuilder builder) {
        sortList.add(builder);
        return this;
    }

    public QueryBuilder Fields(QueryBuilder builder) {
        fieldList.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + boolList.toString() + sortList.toString() + fieldList.toString();
    }
}
