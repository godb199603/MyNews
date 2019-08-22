package com.wzl.rxjava.mymvvm.ui.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wzl.rxjava.mymvvm.R;
import com.wzl.rxjava.mymvvm.base.BaseViewHolder;
import com.wzl.rxjava.mymvvm.base.ModelType;
import com.wzl.rxjava.mymvvm.databinding.ItemDateBinding;
import com.wzl.rxjava.mymvvm.databinding.ItemNewsListBinding;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsDateModel;
import com.wzl.rxjava.mymvvm.model.NewsModel;

/**
 * 作者：Create on 2019/8/9 01:52  by  wzl
 * 描述：
 * 最近修改：2019/8/9 01:52 modify by wzl
 */
public class NewsViewHolder extends BaseViewHolder<NewsModel> {


    private static ItemNewsListBinding Bbinding;
    public NewsViewHolder(ViewDataBinding binding) {
        super(binding);

    }

    @Override
    public void bindVH(NewsModel newsModel) {


        Bbinding.setItem(newsModel);
        //让绑定生效。
        Bbinding.executePendingBindings();
    }


    public static BaseViewHolder<NewsModel> CreateViewHolder(ViewGroup parent) {
        //读取xml对内存
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //建立绑定关系
        Bbinding = DataBindingUtil.inflate(inflater, R.layout.item_news_list, parent, false);
        NewsViewHolder viewHolder = new NewsViewHolder(Bbinding);
        return viewHolder;
    }

}