package com.baijr.es2sql.essqlbuild.sqlstring;


import com.baijr.es2sql.essqlbuild.model.Sort;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baijr
 * @date 2020-04-08
 */
public class SortString {


//    {
//        "year_ids": {
//        "order": "desc"
//    }
//
//    },
//    {
//        "biz_id": {
//        "order": "asc"
//    }
//    }

    public static String getSortSql(List<Sort> list) {
        if (list != null && list.size() > 0) {
            StringBuilder builder = new StringBuilder();
            AtomicInteger i = new AtomicInteger();
            list.forEach((x) -> {
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(x.getFiled());
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.LEFT_BRACE);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.ORDER);
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.COLON);
                builder.append(GlobalConsts.QUOTE);
                builder.append(x.getOrderby());
                builder.append(GlobalConsts.QUOTE);
                builder.append(GlobalConsts.RIGHT_BRACE);
                i.getAndIncrement();
                if (i.get() != list.size()) {
                    builder.append(GlobalConsts.COMMA);
                }
                builder.append(GlobalConsts.RIGHT_BRACE);
            });
            return builder.toString();
        }
        return "";
    }

}
