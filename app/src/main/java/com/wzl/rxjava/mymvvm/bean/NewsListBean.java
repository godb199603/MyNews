package com.wzl.rxjava.mymvvm.bean;

import java.util.List;

/**
 * 作者：Create on 2019/8/9 23:51  by  wzl
 * 描述：
 * 最近修改：2019/8/9 23:51 modify by wzl
 */
public class NewsListBean {
    private String date;
    private List<NewsBean> stories;
    private List<TopNewsBean> top_stories;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<NewsBean> getStories() {
        return stories;
    }

    public void setStories(List<NewsBean> stories) {
        this.stories = stories;
    }
}
