package com.wzl.rxjava.mymvvm.model;

import com.wzl.rxjava.mymvvm.base.ModelType;

/**
 * 作者：Create on 2019/8/9 00:58  by  wzl
 * 描述：
 * 最近修改：2019/8/9 00:58 modify by wzl
 */
public class NewsModel implements IModelType{

    private String title;
    private String image;
    private int newsId;
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




    @Override
    public int getViewType() {
        return NEWS;
    }
}
