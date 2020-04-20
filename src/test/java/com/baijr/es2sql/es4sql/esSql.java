package com.baijr.es2sql.es4sql;

import com.baijr.es2sql.SqlParseES;
import org.nlpcn.es4sql.SearchDao;
import org.nlpcn.es4sql.exception.SqlParseException;


import java.sql.SQLFeatureNotSupportedException;

public class esSql {

    public static void main(String[] args) throws SQLFeatureNotSupportedException, SqlParseException {
        String sql = "select sum(a) FROM DT";

        SearchDao searchDao = new SearchDao(null);
        String dsl = searchDao.explain(sql).explain().explain();
        System.out.println(dsl);
    }
}
