package com.baijr.essql.essqlbuild.express;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class QueryBuilder extends Query {

    private final List<Query> boolList = new ArrayList<Query>();
    private final List<Query> sortList = new ArrayList<Query>();
    private final List<String> fieldList = new ArrayList<String>();
    private int from = 0;
    private int to = 20;

    public QueryBuilder(String queryKey) {
        super(queryKey);
    }

    public QueryBuilder Bool(BoolQueryBuiler builder) {
        boolList.add(builder);
        return this;
    }

    public QueryBuilder Sorts(SortBuilder sortBuilder) {
        sortList.add(sortBuilder);
        return this;
    }

    public QueryBuilder From(int from) {
        this.from = from;
        return this;
    }

    public QueryBuilder To(int to) {
        this.to = to;
        return this;
    }

    public QueryBuilder Fields(String... fields) {
        fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + boolList.toString() + sortList.toString() + fieldList.toString();
    }
}
