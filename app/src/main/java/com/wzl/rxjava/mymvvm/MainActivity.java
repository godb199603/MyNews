package com.wzl.rxjava.mymvvm;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wzl.rxjava.mymvvm.ui.NewsDetailFragment;
import com.wzl.rxjava.mymvvm.ui.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsFragment.IgoNews{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过布局文件绑定一个fragment
        NewsFragment newsFragment=new NewsFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_container,newsFragment);

        transaction.commit();

    }


    public void showNewsDetail(int newsId){
        NewsDetailFragment newsDetailFragment=NewsDetailFragment.newInstance(newsId);
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(newsDetailFragment.getTag());

        transaction.replace(R.id.fragment_container,newsDetailFragment);
        transaction.commit();

    }

    @Override
    public void goNews(int newsId) {
        showNewsDetail(newsId);
    }
}//类结束


