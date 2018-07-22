package com.example.fyg.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends AppCompatActivity /*implements  SwipeRefreshLayout.OnRefreshListener*/{
    private SwipeRefreshLayout swiper;
    private ListView mListview;

    private List<String> list = new ArrayList<>();

    private ArrayAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);

        /*swiper = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        swiper.setOnRefreshListener(this);

        swiper.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mListview = (ListView) findViewById(R.id.list_view);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());

        mListview.setAdapter(adapter);*/
    }
   /* private List<String> getData(){
        list.add("hello");
        list.add("this is a beautiful world");
        list.add("an android app is used by you");
        list.add("its name is 'U-Help'");
        return list;
    }

    @Override
    public void onRefresh(){
        //刷新
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //结束后停止刷新
                swiper.setRefreshing(false);
            }
        },3000);
        //一般从后端获取数据
        //  new Handler().post(new Runnable(){
        //      @Override
        //      public void run(){
        //          获取数据
        //          refreshData();
        //          swiper.setRefreshing(false);
        //      }
        //  });
    }
    /*private void refreshData(){
        list.add(0,String.valueOf((int)(Math.random()*10)));
        adapter.notifyDataSetChanged();
    }*/

}
