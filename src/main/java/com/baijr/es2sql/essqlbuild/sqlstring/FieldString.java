package com.baijr.es2sql.essqlbuild.sqlstring;

import com.baijr.es2sql.essqlbuild.builder.BoolBuilder;
import com.baijr.es2sql.essqlbuild.model.Fields;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

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

    public static String getNotTermSQL(List<Fields> list) {

//        {
//            "term": {
//            "main_data_type": {
//                "value": "koubei"
//            }
//        }
//        }

        StringBuilder builder = new StringBuilder();

        if (list != null && list.size() > 0) {
            builder.append(GlobalConsts.LEFT_BRACE);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.BOOL);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_BRACE);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.MUSTNOT);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_SQUARE);

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

            builder.append(GlobalConsts.RIGHT_SQUARE);
            builder.append(GlobalConsts.RIGHT_BRACE);
            builder.append(GlobalConsts.RIGHT_BRACE);
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
                    builder.append(GlobalConsts.TERMS);
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
                        builder.append(GlobalConsts.RIGHT_SQUARE);
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
//        {
//            "exists":
//            {
//                "field": "title"
//            }
//        }

        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            AtomicInteger i = new AtomicInteger();
            list.forEach((x) -> {
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.EXISTS);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.FIELD);
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
                    builder.append(GlobalConsts.RIGHT_SQUARE);
                }

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

    public static String getNullSQL(List<Fields> list) {
//        {
//            "bool": {
//            "must_not": [
//            {
//
//                "exists":
//                {
//                    "field": "title"
//                }
//
//            }
//           ]
//        }
//        }

        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {

            builder.append(GlobalConsts.LEFT_BRACE);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.BOOL);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_BRACE);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.MUSTNOT);
            builder.append(GlobalConsts.QUOTE);
            builder.append(GlobalConsts.COLON);
            builder.append(GlobalConsts.LEFT_SQUARE);

            AtomicInteger i = new AtomicInteger();
            list.forEach((x) -> {
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.EXISTS);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.FIELD);
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
                    builder.append(GlobalConsts.RIGHT_SQUARE);
                }

                builder.append(GlobalConsts.RIGHT_BRACE);
                builder.append(GlobalConsts.RIGHT_BRACE);
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });

            builder.append(GlobalConsts.RIGHT_SQUARE);
            builder.append(GlobalConsts.RIGHT_BRACE);
            builder.append(GlobalConsts.RIGHT_BRACE);

        }

        return builder.toString();
    }


    public static String getRangeSQL(List<Fields> list) {

//        {
//            "range": {
//            "biz_id": {
//                "gte": 1,
//                "lte": 2000000000
//            }
//        }
//        }

        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            Map<String, List<Fields>> fields = list.stream().collect(Collectors.groupingBy(Fields::getFiled));
            AtomicInteger i = new AtomicInteger();
            fields.forEach((field, fieldsList) -> {
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.RANGE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(field);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                AtomicInteger i1 = new AtomicInteger();
                fieldsList.stream().forEach(y -> {
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(y.getExpressType());
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(GlobalConsts.COLON);
                    builder.append(GlobalConsts.QUOTE);
                    builder.append(y.getValues().get(0));
                    builder.append(GlobalConsts.QUOTE);
                    i1.getAndIncrement();
                    if (i1.get() != fieldsList.size()) {
                        builder.append(GlobalConsts.COMMA);
                    }
                });
                builder.append(GlobalConsts.RIGHT_BRACE);
                builder.append(GlobalConsts.RIGHT_BRACE);
                builder.append(GlobalConsts.RIGHT_BRACE);
                i.getAndIncrement();
                if (i.get() != fields.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });
        }

        return builder.toString();
    }

    public static String getChildBoolSql(List<BoolBuilder> list) {
        StringBuilder builder = new StringBuilder();
        if (list != null && list.size() > 0) {
            AtomicInteger i = new AtomicInteger();
            list.forEach((x) -> {
                builder.append(GlobalConsts.LEFT_BRACE);
                if (!"".equals(x.ESSQL())) {
                    builder.append(x.ESSQL());
                }
                builder.append(GlobalConsts.RIGHT_BRACE);
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
            });
        }
        return builder.toString();

    }
}
