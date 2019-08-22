package com.wzl.rxjava.mymvvm.base;

import android.databinding.BindingAdapter;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wzl.rxjava.mymvvm.utils.HtmlUtil;

/**
 * 作者：Create on 2019/8/11 03:18  by  wzl
 * 描述：
 * 最近修改：2019/8/11 03:18 modify by wzl
 */
 public class ImageViewBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImage(ImageView iv,String url){
        Glide.with(iv.getContext())
                .load(url)
                .into(iv);
    }



    @BindingAdapter("html")
    public static void setHtml(WebView iv, String data){
        iv.loadData(data, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
    }
}
