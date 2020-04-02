package com.baijr.essql;

/**
 * @author baijr
 * @date 2020-04-01
 */
public class SqlParseESTest {

    public static void main(String[] args) {
        String esSql = SqlParseES.ToESSql("select a from b");
        System.out.println(esSql);
    }

}
