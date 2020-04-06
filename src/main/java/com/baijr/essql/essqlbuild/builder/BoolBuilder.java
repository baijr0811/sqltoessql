package com.baijr.essql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class BoolBuilder extends BaseBuilder {

    private BaseBuilder must = null;
    private BaseBuilder should = null;
    private BaseBuilder must_not = null;

    public BoolBuilder(String queryKey) {
        super(queryKey);
    }

    public BoolBuilder AND(FieldBuilder builder) {
        must = (builder);
        return this;
    }

    public BoolBuilder OR(FieldBuilder builder) {
        should = (builder);
        return this;
    }

    public BoolBuilder ANDNOT(FieldBuilder builder) {
        must_not = (builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey;
    }

    public String SHOUDSQL() {
        return should.toString();
    }

    public String MUSTSQL() {
        return must.toString();
    }

    public String MUSTNOTSQL() {
        return must_not.toString();
    }
}
