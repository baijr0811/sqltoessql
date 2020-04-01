package com.baijr.essql.essql.essqlbuild.express;

public class MustTermQueryExpressBuilder implements Express {

    String name;
    String value;

    public MustTermQueryExpressBuilder(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
