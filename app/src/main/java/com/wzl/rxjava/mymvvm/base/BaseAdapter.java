package com.wzl.rxjava.mymvvm.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Create on 2019/8/10 02:51  by  wzl
 * 描述：
 * 最近修改：2019/8/10 02:51 modify by wzl
 */
public abstract class BaseAdapter<M extends ModelType> extends RecyclerView.Adapter<BaseViewHolder<M>> {

    public List<M> items= new ArrayList();


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        holder.bindVH(items.get(position));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


    @Override
    public int getItemViewType(int position){
        return items.get(position).getViewType();
    }


    /**
     * 设置数据
     */
    public void setData(List<M> list) {
        if (list != null) {
            items.clear();
            items.addAll(list);
            notifyDataSetChanged();
        }
    }
    /**
     * 添加数据
     */
    public void addData(List<M> list) {
        int preSize = items.size();
        items.addAll(list);
        notifyItemRangeInserted(preSize, list.size());
    }

    /**
     * 清空数据
     */
    public void clearData() {
        items.clear();
    }

}
