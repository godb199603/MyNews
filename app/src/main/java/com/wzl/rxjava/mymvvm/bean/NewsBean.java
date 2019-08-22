package com.wzl.rxjava.mymvvm.bean;

import java.util.List;

/**
 * 作者：Create on 2019/8/9 23:52  by  wzl
 * 描述：
 * 最近修改：2019/8/9 23:52 modify by wzl
 */
public class NewsBean {

    private List<String> images;
    private int type;
    private int id;
    private String gaPrefix;
    private String title;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
