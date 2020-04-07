package com.baijr.es2sql.essqlbuild.sqlstring;


import com.baijr.es2sql.essqlbuild.builder.FieldBuilder;
import com.baijr.es2sql.essqlbuild.model.Fields;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author baijr
 * @date 2020-04-06
 */
public class BoolString {


    public static String getMustSQL(List<FieldBuilder> list) {
//        "bool":{
//        "must":[],
//        }
        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            AtomicInteger i = new AtomicInteger();
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.MUST);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_SQUARE);
            list.forEach((x) -> {
                builder.append(x.ESSQL());
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });
            builder.append(GlobalConsts.RIGHT_SQUARE);
        }

        return builder.toString();
    }

    public static String getMustNotSQL(List<FieldBuilder> list) {
//        "bool":{
//        "must":[],
//        }
        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            AtomicInteger i = new AtomicInteger();
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.MUSTNOT);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_SQUARE);
            list.forEach((x) -> {
                builder.append(x.ESSQL());
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });
            builder.append(GlobalConsts.RIGHT_SQUARE);
        }

        return builder.toString();
    }

    public static String getShouldSQL(List<FieldBuilder> list) {
//        "bool":{
//        "must":[],
//        }
        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.SHOULD);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            AtomicInteger i = new AtomicInteger();
            builder.append(GlobalConsts.LEFT_SQUARE);
            list.forEach((x) -> {
                builder.append(x.ESSQL());
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });
            builder.append(GlobalConsts.RIGHT_SQUARE);
        }

        return builder.toString();
    }


    public static String getBoolSql(String sql) {
//        "bool":{}
        StringBuilder builder = new StringBuilder();
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.BOOL);
        builder.append(GlobalConsts.QUOTE);
        builder.append(GlobalConsts.COLON);
        builder.append(GlobalConsts.LEFT_BRACE);
        if (!"".equals(sql)) {
            builder.append(sql);
        }
        builder.append(GlobalConsts.RIGHT_BRACE);
        return builder.toString();
    }
}
