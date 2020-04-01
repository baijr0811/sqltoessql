package com.baijr.essql.essql.essqlbuild.express;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    private final List<Express> mustClauses = new ArrayList();
    private final List<Express> mustNotClauses = new ArrayList();
    private final List<Express> shouldClauses = new ArrayList();

    Builder() {

    }

    public Builder must(Express express) {
        if (express == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        } else {
            this.mustClauses.add(express);
            return this;
        }
    }
}
