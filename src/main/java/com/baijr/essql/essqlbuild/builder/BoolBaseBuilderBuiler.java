package com.baijr.essql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  baijr
 * @date 2020-04-03
 */
public class BoolBaseBuilderBuiler extends BaseBuilder {

    private final List<BaseBuilder> mustList = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> shouldList = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> mustnotList = new ArrayList<BaseBuilder>();

    public BoolBaseBuilderBuiler(String queryKey) {
        super(queryKey);
    }

    public BoolBaseBuilderBuiler AND(ExpressBuilder builder) {
        mustList.add(builder);
        return this;
    }

    public BoolBaseBuilderBuiler OR(ExpressBuilder builder) {
        shouldList.add(builder);
        return this;
    }

    public BoolBaseBuilderBuiler NOT(ExpressBuilder builder) {
        mustnotList.add(builder);
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + mustList.toString() + mustnotList.toString() + shouldList.toString();
    }
}
