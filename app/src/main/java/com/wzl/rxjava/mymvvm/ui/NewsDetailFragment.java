package com.wzl.rxjava.mymvvm.ui;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzl.rxjava.mymvvm.R;
import com.wzl.rxjava.mymvvm.databinding.NewsDetailFragmentBinding;
import com.wzl.rxjava.mymvvm.model.NewsDetailModel;
import com.wzl.rxjava.mymvvm.viewmodel.NewsDetailViewModel;
import com.wzl.rxjava.mymvvm.viewmodel.NewsViewModel;


import android.support.v4.app.Fragment;

public class NewsDetailFragment extends Fragment {

    public NewsDetailViewModel newsDetailViewModel;
    public NewsDetailFragmentBinding mBinding;
    private static final String PARK_ID = "PARK_ID";


    public static NewsDetailFragment newInstance(int newsid) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putInt(PARK_ID,newsid);
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.news_detail_fragment, null, false);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.news_detail_fragment, container, false);


        return  mBinding.getRoot();
    }//create方法结束

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //重要方法
        newsDetailViewModel= ViewModelProviders.of(this).get(NewsDetailViewModel.class);

        initViewModel();
        int id=getArguments().getInt(PARK_ID);
        newsDetailViewModel.loadData(id);
    }




    private void initViewModel() {
        mBinding.setItem(newsDetailViewModel);
    }


}
