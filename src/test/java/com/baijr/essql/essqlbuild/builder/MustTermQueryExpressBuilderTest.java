package com.baijr.essql.essqlbuild.builder;


import com.baijr.essql.essqlbuild.utils.HBuilder;
import com.baijr.essql.essqlbuild.utils.HField;
import com.baijr.essql.essqlbuild.utils.HSort;
import com.baijr.essql.essqlbuild.utils.HWhere;


class MustTermQueryExpressBuilderTest {

    public static void main(String[] args) {
        Query query = HBuilder.Builder()
                .Bool(HWhere
                        .AND(HField
                                .Equal("a", "0")
                                .In("b", "1", "2", "3")
                                .Less("c", "4")
                        )
                        .OR(HField
                                .Equal("d", "5")
                                .Then("e", "6")
                        )
                )
                .Sorts(HSort.ASC("asc").DESC("desc"))
                .Fields("f", "x", "y", "z")
                .From(0)
                .To(20);
        System.out.println(query.ESSQL());
    }
}