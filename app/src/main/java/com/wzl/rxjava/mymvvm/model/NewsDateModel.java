package com.wzl.rxjava.mymvvm.model;

import com.wzl.rxjava.mymvvm.base.ModelType;

/**
 * 作者：Create on 2019/8/9 02:39  by  wzl
 * 描述：
 * 最近修改：2019/8/9 02:39 modify by wzl
 */
public class NewsDateModel implements IModelType{



    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




    @Override
    public int getViewType() {
        return NEWSDATE;
    }
}
