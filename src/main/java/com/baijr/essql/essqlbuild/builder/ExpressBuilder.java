package com.baijr.essql.essqlbuild.builder;


import com.baijr.essql.essqlbuild.model.Express;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class ExpressBuilder extends BaseBuilder {

    private final List<Express> terms = new ArrayList<Express>();

    private final List<String> exists = new ArrayList<>();

    public ExpressBuilder(String queryKey) {
        super(queryKey);
    }

    public ExpressBuilder Equal(String field, String value) {
        terms.add(new Express(queryKey, field, value));
        return this;
    }

    public ExpressBuilder In(String field, String... value) {
        terms.add(new Express(queryKey, field, Arrays.asList(value)));
        return this;
    }

    public ExpressBuilder NotNULL(String... fields) {
        exists.addAll(Arrays.asList(fields));
        return this;

    }

    public ExpressBuilder Then(String field, String value) {
        terms.add(new Express(queryKey, field, value));
        return this;
    }

    public ExpressBuilder ThenEqual(String field, String value) {
        terms.add(new Express(queryKey, field, value));
        return this;
    }

    public ExpressBuilder Less(String field, String value) {
        terms.add(new Express(queryKey, field, value));
        return this;

    }

    public ExpressBuilder LessEqual(String field, String value) {
        terms.add(new Express(queryKey, field, value));
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey + terms.toString();
    }
}
