package com.baijr.essql.essqlbuild.builder;


import com.baijr.essql.essqlbuild.model.Fields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class FieldBuilder extends BaseBuilder {

    private final List<Fields> fiedls = new ArrayList<Fields>();

    public FieldBuilder(String queryKey) {
        super(queryKey);
    }

    public FieldBuilder Equal(String field, String value) {
        fiedls.add(new Fields(queryKey, field, value));
        return this;
    }

    public FieldBuilder In(String field, String... value) {
        fiedls.add(new Fields(queryKey, field, Arrays.asList(value)));
        return this;
    }

    public FieldBuilder NotNULL(String... fields) {
        fiedls.add(new Fields(queryKey, Arrays.asList(fields)));
        return this;

    }

    public FieldBuilder Then(String field, String value) {
        fiedls.add(new Fields(queryKey, field, value));
        return this;
    }

    public FieldBuilder ThenEqual(String field, String value) {
        fiedls.add(new Fields(queryKey, field, value));
        return this;
    }

    public FieldBuilder Less(String field, String value) {
        fiedls.add(new Fields(queryKey, field, value));
        return this;

    }

    public FieldBuilder LessEqual(String field, String value) {
        fiedls.add(new Fields(queryKey, field, value));
        return this;
    }

    @Override
    public String ESSQL() {
        return queryKey;
    }

    public String TERMSQL() {
        return fiedls.toString();
    }


}
