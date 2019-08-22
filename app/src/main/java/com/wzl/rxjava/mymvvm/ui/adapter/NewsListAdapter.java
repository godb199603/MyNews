package com.wzl.rxjava.mymvvm.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wzl.rxjava.mymvvm.base.BaseAdapter;
import com.wzl.rxjava.mymvvm.base.BaseViewHolder;
import com.wzl.rxjava.mymvvm.base.ModelType;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsDateModel;
import com.wzl.rxjava.mymvvm.ui.viewholder.NewsDateViewHolder;
import com.wzl.rxjava.mymvvm.ui.viewholder.NewsDateViewHolder2;
import com.wzl.rxjava.mymvvm.ui.viewholder.NewsViewHolder;
import com.wzl.rxjava.mymvvm.ui.viewholder.NewsViewHolder2;


import static com.wzl.rxjava.mymvvm.model.IModelType.NEWS;
import static com.wzl.rxjava.mymvvm.model.IModelType.NEWSDATE;

/**
 * 作者：Create on 2019/8/9 01:52  by  wzl
 * 描述：
 * 最近修改：2019/8/9 01:52 modify by wzl
 */
public class NewsListAdapter extends BaseAdapter<IModelType> {


    public NewsListAdapter(NewsAdapterListener listener) {
        this.listener = listener;
    }

    private NewsAdapterListener listener;


    @NonNull
    @Override

        public BaseViewHolder<IModelType> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case NEWSDATE:
                return NewsDateViewHolder2.createViewHolder(viewGroup);

            case NEWS:
                return NewsViewHolder2.CreateViewHolder(viewGroup,listener);
        }
      return null;
    }





    public interface NewsAdapterListener extends NewsViewHolder2.NewsListener{

        @Override
        public void onItemClick(int newsId);
        @Override
        public void onItemClick2(View view);
    }



}


