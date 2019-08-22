package com.wzl.rxjava.mymvvm.repository;

import com.wzl.rxjava.mymvvm.api.NewsApi;
import com.wzl.rxjava.mymvvm.api.Retrofit2Helper;
import com.wzl.rxjava.mymvvm.bean.NewsListBean;

import io.reactivex.Observable;

/**
 * 作者：Create on 2019/8/9 22:18  by  wzl
 * 描述：
 * 最近修改：2019/8/9 22:18 modify by wzl
 */
public class NewsRepository {

    public NewsRepository(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    //    private static String TIME = "time";
   //    private NewsApi newsApi = Retrofit2Helper.createretrofit().create(NewsApi.class);
    private NewsApi newsApi;

   public Observable<NewsListBean> getLatestNews(){
       return newsApi.getLatestNews();
   }






//
//    public Observable<NewsList> getBeforeNews(){
//        return newsApi.getBeforeNews(TIME);
//    }




}
