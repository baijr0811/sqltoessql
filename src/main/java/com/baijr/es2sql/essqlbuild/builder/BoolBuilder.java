package com.baijr.es2sql.essqlbuild.builder;

import com.baijr.es2sql.essqlbuild.sqlstring.BoolString;
import com.baijr.es2sql.essqlbuild.sqlstring.FieldString;

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
        List<String> sqls = new ArrayList<>();
        String mustStr = BoolString.getMustSQL(must);
        String shouldStr = BoolString.getShouldSQL(should);
        String must_notStr = BoolString.getMustNotSQL(must_not);
        if (!"".equals(mustStr)) {
            sqls.add(mustStr);
        }
        if (!"".equals(shouldStr)) {
            sqls.add(shouldStr);
        }
        if (!"".equals(must_notStr)) {
            sqls.add(must_notStr);
        }
        return BoolString.getBoolSql(String.join(",", sqls));
    }

}
