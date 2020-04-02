package com.baijr.essql.mysqlparse.model;

import com.baijr.essql.mysqlparse.WhereType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baijr
 * @date 2020-04-01
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

