package com.baijr.essql.essqlbuild.builder;


import com.baijr.essql.essqlbuild.utils.HBuilder;
import com.baijr.essql.essqlbuild.utils.HField;
import com.baijr.essql.essqlbuild.utils.HSort;
import com.baijr.essql.essqlbuild.utils.HWhere;

/**
 * @author baijr
 * @date 2020-04-01
 */
class MustTermQueryExpressBuilderTest {

    public static void main(String[] args) {
        Query query = HBuilder.Builder()
                .Bool(HWhere
                        .AND(HField
                                .Equal("a", "0")
                                .Equal("a1", "10")
                                .In("b", "1", "2", "3")
                                .Less("c", "4")
                                .NotNULL("n")
                                .NotNULL("l")
                        )
                        .OR(HField
                                .Equal("d", "5")
                                .Then("e", "6")
                                .LessEqual("e", "8")
                        )
                        .AND(HField
                                .NotNULL("nn")
                                .Then("f", "7")
                        )
                )
                .Sort(HSort.ASC("asc").DESC("desc"))
                .Fields("f", "x", "y", "z")
                .From(0)
                .To(20);
        System.out.println(query.ESSQL());
    }
}