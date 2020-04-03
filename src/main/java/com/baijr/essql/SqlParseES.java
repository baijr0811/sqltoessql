package com.baijr.essql;

import com.baijr.essql.essqlbuild.builder.Query;
import com.baijr.essql.essqlbuild.utils.HBuilder;
import com.baijr.essql.mysqlparse.ParserUitls;
import com.baijr.essql.mysqlparse.model.ParseModel;
import com.baijr.essql.mysqlparse.parser.SqlParser;


/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParseES {

    public static String ToESSql(String sql) {
        ParseModel parseModel = ParserUitls.GetParesModel(sql);
        Query query = HBuilder.Builder();

        return query.ESSQL();
    }
}
