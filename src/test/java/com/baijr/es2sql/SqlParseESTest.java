package com.baijr.es2sql;

/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParseESTest {

    public static void main(String[] args) {
        String sql = " select a,b,c from t" +
                " where  a=1 and (b=2 or c=3) " +
                " order by c asc ,d desc " +
                " limit 1,2";


        String esSql = SqlParseES.ToESSql(sql);
        System.out.println(esSql);
    }

}