package com.wzl.rxjava.mymvvm.ui.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wzl.rxjava.mymvvm.R;
import com.wzl.rxjava.mymvvm.base.BaseViewHolder;

import com.wzl.rxjava.mymvvm.base.ModelType;
import com.wzl.rxjava.mymvvm.databinding.ItemDateBinding;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsDateModel;
import com.wzl.rxjava.mymvvm.model.NewsModel;

/**
 * 作者：Create on 2019/8/9 01:55  by  wzl
 * 描述：
 * 最近修改：2019/8/9 01:55 modify by wzl
 */
public class NewsDateViewHolder extends BaseViewHolder<NewsDateModel>{


    private static ItemDateBinding Abinding;
    public NewsDateViewHolder(ViewDataBinding binding) {
        super(binding);

    }

    @Override
    public void bindVH(NewsDateModel newsDateModel) {

        Abinding.setItem(newsDateModel);
        //让绑定生效。
        Abinding.executePendingBindings();

    }


    public static BaseViewHolder<NewsDateModel> createViewHolder(ViewGroup parent) {
        //读取xml对内存
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //建立绑定关系
        Abinding = DataBindingUtil.inflate(inflater, R.layout.item_date, parent, false);
        NewsDateViewHolder viewHolder = new NewsDateViewHolder(Abinding);

        return viewHolder;
    }



}
