package com.baijr.es2sql.essqlbuild.builder;

import com.baijr.es2sql.essqlbuild.sqlstring.FieldString;
import com.baijr.es2sql.essqlbuild.sqlstring.GlobalConsts;
import com.baijr.es2sql.essqlbuild.sqlstring.QueryString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-03
 */
public class QueryBuilder extends BaseBuilder {

    private BoolBuilder bool = null;
    private final List<SortBuilder> sort = new ArrayList<>();
    private final List<String> _source = new ArrayList<>();
    private int from = 0;
    private int size = 20;

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

    public QueryBuilder Size(int size) {
        this.size = size;
        return this;
    }

    public QueryBuilder Fields(String... fields) {
        _source.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public String ESSQL() {
        List<String> sqls = new ArrayList<>();
        String queryStr = QueryString.getQuerySql(bool);
        String fromStr = QueryString.getFromSql(from);
        String sizeStr = QueryString.getSizeSql(size);
        String _sourceStr = QueryString.getFieldSql(_source);
        String sortStr = QueryString.getSortSql(sort);
        if (!"".equals(queryStr)) {
            sqls.add(queryStr);
        }
        if (!"".equals(fromStr)) {
            sqls.add(fromStr);
        }
        if (!"".equals(sizeStr)) {
            sqls.add(sizeStr);
        }
        if (!"".equals(_sourceStr)) {
            sqls.add(_sourceStr);
        }
        if (!"".equals(sortStr)) {
            sqls.add(sortStr);
        }
        return QueryString.getSql(String.join(",", sqls));
    }

}
