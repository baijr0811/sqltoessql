package com.baijr.es2sql.essqlbuild.builder;


import com.baijr.es2sql.essqlbuild.model.Fields;
import com.baijr.es2sql.essqlbuild.sqlstring.BoolString;
import com.baijr.es2sql.essqlbuild.sqlstring.FieldString;
import com.baijr.es2sql.essqlbuild.sqlstring.QueryString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class FieldBuilder extends BaseBuilder {

    private static final String GT_NAME = "gt";
    private static final String GTE_NAME = "gte";
    private static final String LT_NAME = "lt";
    private static final String LTE_NAME = "lte";

    private final List<Fields> term = new ArrayList<>();
    private final List<Fields> terms = new ArrayList<>();
    private final List<Fields> exists = new ArrayList<>();
    private final List<Fields> range = new ArrayList<>();

    private final List<BoolBuilder> childBools = new ArrayList<>();

    public FieldBuilder(String queryKey) {
        super(queryKey);
    }

    public FieldBuilder Equal(String field, String value) {
        term.add(new Fields(field, value));
        return this;
    }

    public FieldBuilder In(String field, String... value) {
        terms.add(new Fields(field, Arrays.asList(value)));
        return this;
    }

    public FieldBuilder NotNULL(String... fields) {
        exists.add(new Fields(Arrays.asList(fields)));
        return this;

    }

    public FieldBuilder Then(String field, String value) {
        range.add(new Fields(GT_NAME, field, value));
        return this;
    }

    public FieldBuilder ThenEqual(String field, String value) {
        range.add(new Fields(GTE_NAME, field, value));
        return this;
    }

    public FieldBuilder Less(String field, String value) {
        range.add(new Fields(LT_NAME, field, value));
        return this;

    }

    public FieldBuilder LessEqual(String field, String value) {
        range.add(new Fields(LTE_NAME, field, value));
        return this;
    }

    public FieldBuilder ChildBool(BoolBuilder boolBuilder) {
        childBools.add(boolBuilder);
        return this;
    }

    @Override
    public String ESSQL() {
        List<String> sqls = new ArrayList<>();
        String termStr = FieldString.getTermSQL(term);
        String termsStr = FieldString.getTermsSQL(terms);
        String existsStr = FieldString.getExistsSQL(exists);
        String rangeStr = FieldString.getRangeSQL(range);
        String childStr = FieldString.getChildBoolSql(childBools);
        if (!"".equals(termStr)) {
            sqls.add(termStr);
        }
        if (!"".equals(termsStr)) {
            sqls.add(termsStr);
        }
        if (!"".equals(existsStr)) {
            sqls.add(existsStr);
        }
        if (!"".equals(rangeStr)) {
            sqls.add(rangeStr);
        }
        if (!"".equals(childStr)) {
            sqls.add(childStr);
        }
        return String.join(",", sqls);
    }


}
