package com.wzl.rxjava.mymvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;


import com.bumptech.glide.Glide;
import com.wzl.rxjava.mymvvm.api.NewsApi;
import com.wzl.rxjava.mymvvm.api.Retrofit2Helper;
import com.wzl.rxjava.mymvvm.bean.NewsBean;
import com.wzl.rxjava.mymvvm.bean.NewsDetailBean;
import com.wzl.rxjava.mymvvm.bean.NewsListBean;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsDateModel;
import com.wzl.rxjava.mymvvm.model.NewsModel;
import com.wzl.rxjava.mymvvm.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * 作者：Create on 2019/8/9 11:44  by  wzl
 * 描述：
 * 最近修改：2019/8/9 11:44 modify by wzl
 */
public class NewsViewModel extends ViewModel{


//    public final ObservableField<NewsModel> newsModel = new ObservableField();
//    private List<NewsModel> newsModelList = new ArrayList<NewsModel>();


    private NewsRepository newsRepository;

    //livedata
    public  MutableLiveData<List<IModelType>> newsData= new MutableLiveData();
//    private NewsDateModel newsDateModel = new NewsDateModel();
//    private NewsModel newsModel = new NewsModel();

    private NewsDateModel newsDateModel;
//    private NewsModel newsModel=new NewsModel();
    private NewsModel newsModel;
    private List<NewsModel> newsModelList = new ArrayList<NewsModel>();
    private int newsId;
    public static final String DATE="20190817";
    public static final String DATE2="20190816";



    public void loadData(){
        getNewsDate();
        getNews();
        getBeforeNewsDate(DATE);
        getBeforeNews(DATE);
        getBeforeNewsDate(DATE2);
        getBeforeNews(DATE2);
//        initListener();

    }




    public void getNewsDate() {

        NewsRepository newsRepository1= new NewsRepository(Retrofit2Helper.createretrofit().create(NewsApi.class));
        NewsApi newsApi=Retrofit2Helper.createretrofit().create(NewsApi.class);
                 newsApi.getLatestNews()
                .map(new Function<NewsListBean, List<IModelType>>() {
                    @Override
                    public List<IModelType> apply(NewsListBean bean) {
                        return convert1(bean);}
                }) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IModelType>>() {
                    public void onSubscribe(Disposable disposable) {}
                    public void onNext(List<IModelType> list) {

                            newsData.setValue(list);

                        }
                        public void onError(Throwable e) {
                        }
                        public void onComplete() {
                        }
                    });

    }//getdate结束




    public void getNews() {
        NewsRepository newsRepository2= new NewsRepository(Retrofit2Helper.createretrofit().create(NewsApi.class));
        NewsApi newsApi=Retrofit2Helper.createretrofit().create(NewsApi.class);
        Log.i("hHH",newsData.toString());
        newsApi.getLatestNews().
//        newsRepository2.getLatestNews().
                map(new Function<NewsListBean, List<IModelType>>() {
                    @Override
                    public List<IModelType> apply(NewsListBean bean) {
                        return convert2(bean);}
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IModelType>>() {
                    public void onSubscribe(Disposable disposable) {}
                    public void onNext(List<IModelType> list) {

                        newsData.setValue(list);
                        Log.i("hHHLLL",newsData.toString());

                    }
                    public void onError(Throwable e) {
                    }
                    public void onComplete() {
                    }
                });
    }//getnews结束





    public void getBeforeNewsDate(String date) {

        NewsApi newsApi=Retrofit2Helper.createretrofit().create(NewsApi.class);
        Log.i("hHH",newsData.toString());
        newsApi.getBeforeNews(date).
//        newsRepository2.getLatestNews().
        map(new Function<NewsListBean, List<IModelType>>() {
        @Override
         public List<IModelType> apply(NewsListBean bean) {
        return convert1(bean);}
         }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IModelType>>() {
                    public void onSubscribe(Disposable disposable) {}
                    public void onNext(List<IModelType> list) {
                        newsData.setValue(list);
                        Log.i("hHHLLL",newsData.toString());


                    }
                    public void onError(Throwable e) {
                    }
                    public void onComplete() {
                    }
                });

    }//过去的日期


    public void getBeforeNews(String date) {
        NewsRepository newsRepository2= new NewsRepository(Retrofit2Helper.createretrofit().create(NewsApi.class));
        NewsApi newsApi=Retrofit2Helper.createretrofit().create(NewsApi.class);
        Log.i("hHH",newsData.toString());
        newsApi.getBeforeNews(date).
//        newsRepository2.getLatestNews().
        map(new Function<NewsListBean, List<IModelType>>() {
    @Override
    public List<IModelType> apply(NewsListBean bean) {
        return convert2(bean);}
}).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IModelType>>() {
                    public void onSubscribe(Disposable disposable) {}
                    public void onNext(List<IModelType> list) {

                        newsData.setValue(list);
                        Log.i("hHHLLL",newsData.toString());

                    }
                    public void onError(Throwable e) {
                    }
                    public void onComplete() {
                    }
                });
    }//过去内容







    //返回内容bean->model->list
    public List<IModelType> convert2(NewsListBean list) {
//        List<IModelType> list2=new ArrayList<>();
        for (NewsBean bean : list.getStories()) {
            newsModel = new NewsModel();
            newsModel.setTitle(bean.getTitle());
            newsModel.setImage(bean.getImages().get(0));
            newsModel.setNewsId(bean.getId());
//            list2.addAll(assembleData());
//            newsModelList.add(newsModel);
            Log.i("hHHKKKK",newsData.toString());
            newsModelList.add(newsModel);
        }
//        newsModelList.add(newsModel);
        return assembleData();
    }//方法结束




    //返回日期bean->model->list
    public List<IModelType> convert1(NewsListBean list) {

        newsDateModel = new NewsDateModel();
        newsDateModel.setDate(list.getDate());

        return assembleData();
    }//方法结束

//
//    //返回日期bean->model->list
//    public List<IModelType> convert3(NewsListBean list) {
//
//        newsDateModel = new NewsDateModel();
//        newsDateModel.setDate(list.getDate());
//
//        return assembleData();
//    }//方法结束
//




    /**
     * 组装数据列表。
     */
    private List<IModelType> assembleData(){
          List<IModelType> list =new ArrayList<IModelType>();
         list.add(newsDateModel);
//         list.add(newsModel);
         list.addAll(newsModelList);
         return list;
        }


    }
