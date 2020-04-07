package com.baijr.es2sql.essqlbuild.sqlstring;


import com.baijr.es2sql.essqlbuild.builder.BaseBuilder;
import com.baijr.es2sql.essqlbuild.builder.BoolBuilder;
import com.baijr.es2sql.essqlbuild.builder.SortBuilder;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baijr
 * @date 2020-04-06
 */
public class QueryString {

    public static String getQuerySql(BoolBuilder boolBuilder) {
//          "query":{}
        StringBuilder builder = new StringBuilder();
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.QUERY);
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.COLON);
        builder.append(GlobalConsts.LEFT_BRACE);
        builder.append(boolBuilder.ESSQL());
        builder.append(GlobalConsts.RIGHT_BRACE);
        return builder.toString();
    }

    public static String getFromSql(long from) {

//                "from": 0,
        StringBuilder builder = new StringBuilder();
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.FROM);
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.COLON);
        builder.append(from);
        return builder.toString();
    }

    public static String getSizeSql(long size) {
        //        "size": 20,

        StringBuilder builder = new StringBuilder();
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.SIZE);
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.COLON);
        builder.append(size);
        return builder.toString();
    }

    public static String getSortSql(List<SortBuilder> list) {
//        "sort": [
//	]

        if (list != null && list.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.SORT);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_SQUARE);
            AtomicInteger i = new AtomicInteger();
            list.forEach(x -> {
                builder.append(x.ESSQL());
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });

            builder.append(GlobalConsts.RIGHT_SQUARE);
            return builder.toString();
        }
        return "";
    }

    public static String getFieldSql(List<String> list) {
//        "_source": ["biz_id", "is_delete", "spec_ids", "series_ids"],
        if (list != null && list.size() > 0 && !list.get(0).equals(GlobalConsts.ASTERISK)) {
            StringBuilder builder = new StringBuilder();
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.SOURCE);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_SQUARE);
            AtomicInteger i = new AtomicInteger();
            list.forEach(x -> {
                builder.append(GlobalConsts.QUOTE);
                builder.append(x);
                builder.append(GlobalConsts.QUOTE);
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });

            builder.append(GlobalConsts.RIGHT_SQUARE);
            return builder.toString();
        }
        return "";
    }


    public static String getSql(String sql) {
//        "bool":{}
        StringBuilder builder = new StringBuilder();
        builder.append(GlobalConsts.LEFT_BRACE);
        if (!"".equals(sql)) {
            builder.append(sql);
        }
        builder.append(GlobalConsts.RIGHT_BRACE);
        return builder.toString();
    }
}
