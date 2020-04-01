package com.baijr.essql.essql.essqlbuild.express;

import com.autohome.contentmain.common.elasticsearch.essql.essqlbuild.QueryBuilder;

/**
 * @author baijr
 * Query查下
 */
public class BoolQueryBuilder extends QueryBuilder {

    private String boolQueryStrStart = "\"bool\":{ ";
    private String boolQueryStrEnd = " } ";

    public Express express;

    public BoolQueryBuilder(Express express) {
        this.express = express;
    }

    @Override
    public String GetBoolQuery() {
        return boolQueryStrStart + expessQuery() + boolQueryStrEnd;
    }

    private String expessQuery() {
        return "";
    }
}
