package com.wzl.rxjava.mymvvm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;

import com.wzl.rxjava.mymvvm.api.NewsApi;
import com.wzl.rxjava.mymvvm.api.Retrofit2Helper;
import com.wzl.rxjava.mymvvm.bean.NewsBean;
import com.wzl.rxjava.mymvvm.bean.NewsDetailBean;
import com.wzl.rxjava.mymvvm.bean.NewsListBean;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsDetailModel;
import com.wzl.rxjava.mymvvm.utils.HtmlUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：Create on 2019/8/16 20:55  by  wzl
 * 描述：
 * 最近修改：2019/8/16 20:55 modify by wzl
 */
public class NewsDetailViewModel extends ViewModel{


    public ObservableField<String> headerimage=new ObservableField<String>();
    public ObservableField<String> headertitle=new ObservableField<String>();
    public ObservableField<String> headersource=new ObservableField<String>();
    public ObservableField<String> htmlData=new ObservableField<String>();
    public void loadData(int id) {
        getNewsDetail(id);
    }




        public void getNewsDetail(int id) {
//            NewsBean news = new NewsBean();
            NewsApi newsApi = Retrofit2Helper.createretrofit().create(NewsApi.class);
            newsApi.getNewsDetail(id)
                    .map(new Function<NewsDetailBean, NewsDetailModel>() {
                        @Override
                        public NewsDetailModel apply(NewsDetailBean bean) {
                            return convert(bean);
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsDetailModel>() {
                public void onSubscribe(Disposable disposable) {}
                public void onNext(NewsDetailModel model) {
                    headerimage.set(model.getHeaderimage());
                    headertitle.set(model.getHeadertitle());
                    headersource.set(model.getHeadersource());
                    htmlData.set(model.getHtmlData());
                }
                public void onError(Throwable e) {
                }
                public void onComplete() {
                }
            });

        }//getDetail



            private NewsDetailModel convert (NewsDetailBean bean){
                NewsDetailModel newsDetailModel=new NewsDetailModel();
                newsDetailModel.setHeaderimage(bean.getImage());
                newsDetailModel.setHeadertitle(bean.getTitle());
                newsDetailModel.setHeadersource(bean.getImageSource());
                String htmlData = HtmlUtil.createHtmlData(bean);
                newsDetailModel.setHtmlData(htmlData);
                return  newsDetailModel;
            }


//                    @Override
//                    public void call(NewsDetailBean newsDetail) {
//
//                            Glide.with(getActivity())
//                                    .load(newsDetail.getImage())
//                                    .into(mIvHeader);
//                            mTvTitle.setText(newsDetail.getTitle());
//                            mTvSource.setText(newsDetail.getImage_source());
//                            mWvNews.setDrawingCacheEnabled(true);
//
//                            String htmlData = HtmlUtil.createHtmlData(newsDetail, isNight);
//                            mWvNews.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
//                            mTvLoadEmpty.setVisibility(View.GONE);



}
