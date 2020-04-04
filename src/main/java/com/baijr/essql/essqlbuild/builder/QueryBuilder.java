package com.baijr.essql.essqlbuild.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class QueryBuilder extends BaseBuilder {

    private BaseBuilder bool = null;
    private final List<BaseBuilder> sort = new ArrayList<BaseBuilder>();
    private final List<String> _source = new ArrayList<String>();
    private int from = 0;
    private int to = 20;

    public QueryBuilder(String queryKey) {
        super(queryKey);
    }

    public QueryBuilder Bool(BoolBuilder builder) {
        bool = builder;
        return this;
    }

    public QueryBuilder Sort(SortBuilder sortBuilder) {
        sort.add(sortBuilder);
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
        _source.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey;
    }

    public String FIELDSQL() {
        return _source.toString();
    }

    public String BOOLSQL() {
        return bool.toString();
    }

    public String SORTSQL() {
        return sort.toString();
    }

    public String FORMSQL() {
        return String.valueOf(from);
    }

    public String TOSQL() {
        return String.valueOf(to);
    }
}
