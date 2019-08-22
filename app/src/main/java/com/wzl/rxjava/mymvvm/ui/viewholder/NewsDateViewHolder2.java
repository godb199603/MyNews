package com.wzl.rxjava.mymvvm.ui.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzl.rxjava.mymvvm.R;
import com.wzl.rxjava.mymvvm.base.BaseViewHolder;
import com.wzl.rxjava.mymvvm.databinding.ItemDateBinding;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsDateModel;

/**
 * 作者：Create on 2019/8/15 00:02  by  wzl
 * 描述：
 * 最近修改：2019/8/15 00:02 modify by wzl
 */
public class NewsDateViewHolder2  extends BaseViewHolder<IModelType>{



    private static ItemDateBinding Abinding;
    public NewsDateViewHolder2(ViewDataBinding binding) {
        super(binding);

    }

    @Override
    public void bindVH(IModelType newsDateModel) {

        Abinding.setItem((NewsDateModel) newsDateModel);
        //让绑定生效。
        Abinding.executePendingBindings();

    }


    public static BaseViewHolder<IModelType> createViewHolder(ViewGroup parent) {
        //读取xml对内存
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //建立绑定关系
        Abinding = DataBindingUtil.inflate(inflater, R.layout.item_date, parent, false);
        NewsDateViewHolder2 viewHolder = new NewsDateViewHolder2(Abinding);

        return viewHolder;
    }







}//holder结束


