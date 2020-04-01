package com.baijr.essql.essql.essqlbuild.express;

import java.util.ArrayList;
import java.util.List;

public class ExpressBuilder implements Express {

    private final List<Express> mustClauses = new ArrayList();
    private final List<Express> mustNotClauses = new ArrayList();
    private final List<Express> shouldClauses = new ArrayList();


    public ExpressBuilder must(Express express) {
        if (express == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        } else {
            this.mustClauses.add(express);
            return this;
        }
    }

}
