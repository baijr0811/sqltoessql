package com.baijr.essql.essqlbuild.express;


import com.baijr.essql.essqlbuild.Builder;

class MustTermQueryExpressBuilderTest {

    public static void main(String[] args) {
        Query query = Builder.Builder()
                .Bool(Builder.AND
                                (Builder.
                                        Equal("and=", "0")
                                        .In("andin", "1", "2", "3")
                                        .Less("and<", "4")
                                ).OR(Builder.
                                Equal("or=", "5")
                                .Then("or>", "6")
                        )
                ).Sorts(Builder.ASC("asc").DESC("desc"))
                .Fields("f", "x", "y", "z");
        System.out.println(query.ESSQL());
    }
}