package com.baijr.es2sql.es4sql;

import com.baijr.es2sql.SqlParseES;
import org.nlpcn.es4sql.SearchDao;
import org.nlpcn.es4sql.exception.SqlParseException;


import java.sql.SQLFeatureNotSupportedException;

public class esSql {

    public static void main(String[] args) throws SQLFeatureNotSupportedException, SqlParseException {
        String sql = "select a,b,c from t" +
                " where a=1 and b=2 and c in(1,2,3) and d>5 and d<100 and f<=6 and (x=1 or y=2) and z is not null " +
                "or w is null and c=3 " +
                "or ax=3 and nt<>5" +
                " order by c asc ,d desc " +
                " limit 1,2";

        SearchDao searchDao = new SearchDao(null);
        String dsl = searchDao.explain(sql).explain().explain();
        System.out.println(dsl);
    }
}
