package com.baijr.es2sql.essqlbuild.builder;


import com.baijr.es2sql.essqlbuild.utils.HBuilder;
import com.baijr.es2sql.essqlbuild.utils.HField;
import com.baijr.es2sql.essqlbuild.utils.HSort;
import com.baijr.es2sql.essqlbuild.utils.HWhere;

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
                                .In("b", "a", "b", "c")
                                .Less("c", "4")
                                .NotNULL("n")
                                .NotNULL("l")
                                .ChildBool(HWhere.AND(HField.Equal("a","b")))

                        )
                        .OR(HField
                                .Equal("d", "5")
                                .Then("e", "6")
                                .LessEqual("e", "8")
                        )
                        .NOT(HField
                                .NotNULL("nn")
                                .Then("f", "7")
                        )
                )
                .Sort(HSort.ASC("asc").DESC("desc"))
                .Fields("f", "x", "y", "z")
                .From(0)
                .Size(20);


        HField.In("a","a","2","3").ESSQL();
        System.out.println(query.ESSQL());
    }
}