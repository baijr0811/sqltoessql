package com.baijr.essql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class BoolBuilder extends BaseBuilder {

    private final List<BaseBuilder> must = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> should = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> must_not = new ArrayList<BaseBuilder>();

    public BoolBuilder(String queryKey) {
        super(queryKey);
    }

    public BoolBuilder AND(FieldBuilder builder) {
        must.add(builder);
        return this;
    }

    public BoolBuilder OR(FieldBuilder builder) {
        should.add(builder);
        return this;
    }

    public BoolBuilder ISNOTNULL(FieldBuilder builder) {
        must_not.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey;
    }

}
