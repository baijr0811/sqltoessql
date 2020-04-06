package com.baijr.es2sql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class BoolBuilder extends BaseBuilder {

    private final List<FieldBuilder> must = new ArrayList<>();
    private final List<FieldBuilder> should = new ArrayList<>();
    private final List<FieldBuilder> must_not = new ArrayList<>();

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

    public BoolBuilder NOT(FieldBuilder builder) {
        must_not.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey;
    }

}
