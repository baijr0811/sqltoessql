package com.baijr.essql.essql.essqlbuild.express;


import com.baijr.essql.essql.essqlbuild.BoolQueryBuilder;
import com.baijr.essql.essql.essqlbuild.QueryBuilder;
import org.junit.Test;

class MustTermQueryExpressBuilderTest {

    @Test
    public void Test() {
        QueryBuilder queryBuilder = new QueryBuilder() {
            @Override
            public String GetBoolQuery() {


                Express express = new Builder().must(MustTermQueryExpressBuilder.term("a", "b"));

                return new BoolQueryBuilder(express).GetBoolQuery();
            }
        };
    }
}