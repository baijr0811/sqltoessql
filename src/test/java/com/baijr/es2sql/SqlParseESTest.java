package com.baijr.es2sql;

/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParseESTest {

    public static void main(String[] args) {
        String sql = " select a,b,c from t" +
                " where a=1 and b=2 and c in(1,2,3) and d>5 and d<100 and f<=6 and (x=1 or y=2) and z is not null " +
                "or w is null and c=3 " +
                "or ax=3 and nt<>5" +
                " order by c asc ,d desc " +
                " limit 1,2";

        String esSql = SqlParseES.ToESSql(sql);
        System.out.println(esSql);
    }

}
