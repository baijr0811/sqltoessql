package com.baijr.essql.essql.essqlbuild.express;

import java.util.ArrayList;
import java.util.List;

public class Builder implements Express {
    private final List<Express> mustClauses = new ArrayList();
    private final List<Express> mustNotClauses = new ArrayList();
    private final List<Express> shouldClauses = new ArrayList();


    public Builder must(Express express) {
        if (express == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        } else {
            this.mustClauses.add(express);
            return this;
        }
    }


    Express should(Express express) {
        if (express == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        } else {
            this.mustNotClauses.add(express);
            return this;
        }
    }


    Express mustnot(Express express) {
        if (express == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        } else {
            this.shouldClauses.add(express);
            return this;
        }
    }
}
