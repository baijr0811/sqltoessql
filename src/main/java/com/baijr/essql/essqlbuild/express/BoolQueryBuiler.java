package com.baijr.essql.essqlbuild.express;

import java.util.ArrayList;
import java.util.List;

public class BoolQueryBuiler extends Query {

    private final List<Query> mustList = new ArrayList<Query>();
    private final List<Query> shouldList = new ArrayList<Query>();
    private final List<Query> mustnotList = new ArrayList<Query>();

    public BoolQueryBuiler(String queryKey, String templete) {
        super(queryKey, templete);
    }


    public BoolQueryBuiler Must(BoolQueryBuiler builder) {
        mustList.add(builder);
        return this;
    }

    public BoolQueryBuiler Should(BoolQueryBuiler builder) {
        shouldList.add(builder);
        return this;
    }

    public BoolQueryBuiler MustNot(BoolQueryBuiler builder) {
        mustnotList.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + templete;
    }
}
