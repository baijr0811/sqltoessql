package com.baijr.essql.essqlbuild.express;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  baijr
 * @date 2020-04-03
 */
public class BoolQueryBuiler extends Query {

    private final List<Query> mustList = new ArrayList<Query>();
    private final List<Query> shouldList = new ArrayList<Query>();
    private final List<Query> mustnotList = new ArrayList<Query>();

    public BoolQueryBuiler(String queryKey) {
        super(queryKey);
    }

    public BoolQueryBuiler AND(ExpressBuilder builder) {
        mustList.add(builder);
        return this;
    }

    public BoolQueryBuiler OR(ExpressBuilder builder) {
        shouldList.add(builder);
        return this;
    }

    public BoolQueryBuiler NOT(ExpressBuilder builder) {
        mustnotList.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + mustList.toString() + mustnotList.toString() + shouldList.toString();
    }
}
