package com.baijr.essql.mysqlparse.parser;

/**
 * @author baijr
 * @date 2020-04-01
 * 定义查询类型
 */
public enum WhereType {
    AND,
    OR,
    IN,
    LESS,
    LESSEQUAL,
    THEN,
    THENEQUAL,
    NULL,
    NOTNULL,
    EQUAL,
    NOTEQUAL,
    Parent,
    NONE
}