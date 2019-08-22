package com.wzl.rxjava.mymvvm.bean;

/**
 * 作者：Create on 2019/8/15 01:44  by  wzl
 * 描述：
 * 最近修改：2019/8/15 01:44 modify by wzl
 */
public class TopNewsBean {
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    private int type;
    private int id;

    private String gaPrefix;
    private String title;
}
