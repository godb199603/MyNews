package com.wzl.rxjava.mymvvm.api;

import com.wzl.rxjava.mymvvm.bean.NewsDetailBean;
import com.wzl.rxjava.mymvvm.bean.NewsListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者：Create on 2019/8/8 23:54  by  wzl
 * 描述：
 * 最近修改：2019/8/8 23:54 modify by wzl
 */
public interface NewsApi {

    @GET("stories/latest")
    Observable<NewsListBean> getLatestNews();

    @GET("stories/before/{date}")
    Observable<NewsListBean> getBeforeNews(@Path("date") String date);

    @GET("story/{id}")
    Observable<NewsDetailBean> getNewsDetail(@Path("id") int id);

}
