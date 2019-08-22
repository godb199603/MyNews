package com.wzl.rxjava.mymvvm.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wzl.rxjava.mymvvm.R;
import com.wzl.rxjava.mymvvm.databinding.NewsFragmentBinding;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.ui.adapter.NewsListAdapter;
import com.wzl.rxjava.mymvvm.ui.viewholder.NewsViewHolder2;
import com.wzl.rxjava.mymvvm.viewmodel.NewsViewModel;

import java.util.List;


/**
 * 作者：Create on 2019/8/8 22:11  by  wzl
 * 描述：
 * 最近修改：2019/8/8 22:11 modify by wzl
 */
public class NewsFragment extends Fragment {



public IgoNews igoNews;
private NewsListAdapter adapter;
public NewsFragmentBinding mBinding;
public NewsViewModel newsViewModel;
private NewsListAdapter.NewsAdapterListener adapterListener=new NewsListAdapter.NewsAdapterListener() {

    @Override
    public void onItemClick2(View view) {
        Toast.makeText(view.getContext(), "被点击了", Toast.LENGTH_SHORT).show();
        mBinding.textView.setText("FFFF");
    }
    @Override
    public void onItemClick(int newsId) {
//        Toast.makeText(view.getContext(), "被点击了", Toast.LENGTH_SHORT).show();
        mBinding.textView.setText("FFFF");
        igoNews.goNews(newsId);
    }

};









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.news_fragment, null, false);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false);


        return  mBinding.getRoot();
    }//create方法结束

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //重要方法
        newsViewModel= ViewModelProviders.of(this).get(NewsViewModel.class);

        initRecycler();
        initViewModel();
        subscribeUI();
    }


    private void initViewModel() {
        mBinding.setItem(newsViewModel);
//        NewsViewModel=mBinding.getItem();



    }

    private void initRecycler() {
        mBinding.rcvNewsList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter=new NewsListAdapter(adapterListener);
        mBinding.rcvNewsList.setAdapter(adapter);
    }



    /**
     * 订阅数据变化，相应UI。
     */
    private void subscribeUI() {
           newsViewModel.loadData();
           newsViewModel.newsData.observe(this,  new Observer<List<IModelType>>(){
            @Override
            public void onChanged(@Nullable final List<IModelType> list) {
                if (list != null) {
                    adapter.setData(list);
                }
            }

        });
    }//subscribe方法结束



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IgoNews) {
            igoNews = (IgoNews) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IgoNews");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        igoNews = null;
    }






    /**
     * 作者：Create  wzl
     * 描述：内部接口
     */
       public interface IgoNews{

        public void goNews(int newsId);

    }



}//类结束



