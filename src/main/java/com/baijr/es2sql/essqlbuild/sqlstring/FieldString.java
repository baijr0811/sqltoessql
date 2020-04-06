package com.baijr.es2sql.essqlbuild.sqlstring;

import com.baijr.es2sql.essqlbuild.model.Fields;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baijr
 * @date 2020-04-06
 */
public class FieldString {


    public static String getTermSQL(List<Fields> list) {

//        {
//            "term": {
//            "main_data_type": {
//                "value": "koubei"
//            }
//        }
//        }

        StringBuilder builder = new StringBuilder();

        if (list != null && list.size() > 0) {
            AtomicInteger i = new AtomicInteger();
            list.forEach((x) -> {
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.TERM);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(x.getFiled());
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.VALUE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                if (x.getValues().size() > 0) {
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(x.getValues().get(0));
                    builder.append(GlobalConsts.QUOTE);
                }
                builder.append(GlobalConsts.RIGHT_BRACE);
                builder.append(GlobalConsts.RIGHT_BRACE);
                builder.append(GlobalConsts.RIGHT_BRACE);
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });

        }

        return builder.toString();

    }

    public static String getTermsSQL(List<Fields> list) {
//        {
//            "terms":{
//            "biz_id":["86695945","86685247"]
//        }
//        }

        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            if (list != null && list.size() > 0) {
                AtomicInteger i = new AtomicInteger();
                list.forEach((x) -> {
                    builder.append(GlobalConsts.LEFT_BRACE);
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(GlobalConsts.TERM);
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(GlobalConsts.COLON);
                    builder.append(GlobalConsts.LEFT_BRACE);
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(x.getFiled());
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(GlobalConsts.COLON);

                    if (x.getValues().size() > 0) {
                        AtomicInteger i1 = new AtomicInteger();
                        builder.append(GlobalConsts.LEFT_SQUARE);
                        x.getValues().forEach(y -> {
                            builder.append(GlobalConsts.QUOTE);
                            builder.append(y);
                            builder.append(GlobalConsts.QUOTE);
                            i1.getAndIncrement();
                            if (i1.get() != x.getValues().size()) {
                                builder.append(GlobalConsts.COMMA);
                            }
                        });
                    }
                    builder.append(GlobalConsts.RIGHT_BRACE);
                    builder.append(GlobalConsts.RIGHT_BRACE);
                    i.getAndIncrement();
                    if (i.get() != list.size()) {
                        builder.append(GlobalConsts.COMMA);
                    }
                });

            }

        }

        return builder.toString();
    }

    public static String getExistsSQL(List<Fields> list) {
        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {


        }

        return builder.toString();
    }


    public static String getRangeSQL(List<Fields> list) {
        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {


        }

        return builder.toString();
    }
}
