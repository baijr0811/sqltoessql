package com.baijr.essql.essqlbuild.builder;

import com.baijr.essql.essqlbuild.model.Sort;

import java.util.ArrayList;
import java.util.List;


/**
 * @author baijr
 * @date 2020-04-03
 */
public class SortBuilder extends BaseBuilder {

    private final List<Sort> sorts = new ArrayList<Sort>();

    public SortBuilder(String queryKey) {
        super(queryKey);
    }

    public SortBuilder ASC(String field) {
        sorts.add(new Sort(field, "asc"));
        return this;
    }

    public SortBuilder DESC(String field) {
        sorts.add(new Sort(field, "desc"));
        return this;
    }

    @Override
    public String ESSQL() {
        return sorts.toString();
    }
}
