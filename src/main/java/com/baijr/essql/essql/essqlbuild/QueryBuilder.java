package com.baijr.essql.essql.essqlbuild;

public abstract class QueryBuilder implements Query {

    private String warpQueryStrStart = " \"query\":{ ";
    private String warpQueryStrEnd = " } ";

    public abstract String GetBoolQuery();


    @Override
    public String ESSql() {
        return warpQueryStrStart + GetBoolQuery() + warpQueryStrEnd;
    }

}
