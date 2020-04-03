package com.baijr.essql.mysqlparse.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-01
 * 字段列表
 */
public class WhereListModel {

    public void Add(WhereModel whereModel) {
        whereModelList.add(whereModel);
    }

    public List<WhereModel> getWhereModelList() {
        return whereModelList;
    }

    public void setWhereModelList(List<WhereModel> whereModelList) {
        this.whereModelList = whereModelList;
    }

    List<WhereModel> whereModelList = new ArrayList<>();
}

