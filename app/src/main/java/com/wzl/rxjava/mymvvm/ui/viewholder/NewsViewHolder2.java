package com.wzl.rxjava.mymvvm.ui.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wzl.rxjava.mymvvm.R;
import com.wzl.rxjava.mymvvm.base.BaseViewHolder;
import com.wzl.rxjava.mymvvm.databinding.ItemNewsListBinding;
import com.wzl.rxjava.mymvvm.model.IModelType;
import com.wzl.rxjava.mymvvm.model.NewsModel;

/**
 * 作者：Create on 2019/8/14 23:57  by  wzl
 * 描述：
 * 最近修改：2019/8/14 23:57 modify by wzl
 */

    public class NewsViewHolder2 extends BaseViewHolder<IModelType> {


        private static NewsListener newslistener;
        private static ItemNewsListBinding Bbinding;
        public NewsViewHolder2(ViewDataBinding binding,NewsListener listener) {
            super(binding);

        this.newslistener=listener;
        }

        @Override
        public void bindVH(IModelType newsModel) {
//                NewsListener listener2=new NewsListener() {
//                @Override
//                public void onItemClick(View view) {
//                Toast.makeText(view.getContext(), "被点击了", Toast.LENGTH_SHORT).show();
//
//                }
//            };
//            newslistener=new NewsListener() {
//                @Override
//                public void onItemClick(View view) {
//                }
//            };
            Bbinding.setListener(newslistener);
            Bbinding.setItem((NewsModel) newsModel);

            //让绑定生效。
            Bbinding.executePendingBindings();

        }


        public static BaseViewHolder<IModelType> CreateViewHolder(ViewGroup parent,NewsListener listener) {
            //读取xml对内存
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            //建立绑定关系
            Bbinding = DataBindingUtil.inflate(inflater, R.layout.item_news_list, parent, false);
            NewsViewHolder2 viewHolder = new NewsViewHolder2(Bbinding,listener);

            return viewHolder;
        }




    public interface NewsListener{
            public void onItemClick2(View view);
            public void onItemClick(int newsId);
    }

}

