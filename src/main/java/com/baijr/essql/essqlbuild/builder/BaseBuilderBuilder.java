package com.baijr.essql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class BaseBuilderBuilder extends BaseBuilder {

    private final List<BaseBuilder> boolList = new ArrayList<BaseBuilder>();
    private final List<BaseBuilder> sortList = new ArrayList<BaseBuilder>();
    private final List<String> fieldList = new ArrayList<String>();
    private int from = 0;
    private int to = 20;

    public BaseBuilderBuilder(String queryKey) {
        super(queryKey);
    }

    public BaseBuilderBuilder Bool(BoolBaseBuilderBuiler builder) {
        boolList.add(builder);
        return this;
    }

    public BaseBuilderBuilder Sorts(SortBuilder sortBuilder) {
        sortList.add(sortBuilder);
        return this;
    }

    public BaseBuilderBuilder From(int from) {
        this.from = from;
        return this;
    }

    public BaseBuilderBuilder To(int to) {
        this.to = to;
        return this;
    }

    public BaseBuilderBuilder Fields(String... fields) {
        fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + boolList.toString() + sortList.toString() + fieldList.toString();
    }
}
