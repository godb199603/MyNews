package com.wzl.rxjava.mymvvm.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wzl.rxjava.mymvvm.databinding.NewsFragmentBinding;
import com.wzl.rxjava.mymvvm.model.IModelType;

/**
 * 作者：Create on 2019/8/10 02:36  by  wzl
 * 描述：
 * 最近修改：2019/8/10 02:36 modify by wzl
 */
public abstract class BaseViewHolder<M extends ModelType> extends RecyclerView.ViewHolder {

    protected ViewDataBinding mbinding;
//构造方法
    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.mbinding=binding;
    }
//create方法



    public abstract void bindVH(M m);
//    {
//        if(m instance IModelType){
//        }
//    }//方法结束




}
