package com.baijr.essql.essql.essqlbuild.express;

public class MustTermQueryExpressBuilder extends ExpressBuilder {

    public static Express terms(String name, String value) {

        return new Builder();
    }

    public static Express term(String name, String value) {
        return null;
    }

    public static Express should(String name, String value) {
        return null;
    }
}
