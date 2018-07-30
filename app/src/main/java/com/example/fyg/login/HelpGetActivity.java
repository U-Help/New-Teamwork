package com.example.fyg.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HelpGetActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_get);

        mListView = (ListView) findViewById(R.id.listview);
        /**
         * listview绑定adapter
         */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        mListView.setAdapter(adapter);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        //绑定刷新时间
        mSwipeLayout.setOnRefreshListener(this);
        //设置颜色
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HelpGetActivity.this, i+"被单击了", Toast.LENGTH_LONG).show();
                startActivity(new Intent(HelpGetActivity.this, DetailActivity.class));
            }
        });
    }

    private ArrayList<String> getData() {
        list.add("Hello world!");
        list.add("CSDN:程序员小冰");
        list.add("An Android Developer");
        list.add("http://weibo.com/mcxiaobing");
        list.add("http://git.oschina.net/MCXIAOBING");
        list.add("https://github.com/QQ986945193");
        list.add("An Android Developer");
        list.add("http://weibo.com/mcxiaobing");
        list.add("http://git.oschina.net/MCXIAOBING");
        list.add("https://github.com/QQ986945193");
        list.add("An Android Developer");
        list.add("http://weibo.com/mcxiaobing");
        list.add("http://git.oschina.net/MCXIAOBING");
        list.add("https://github.com/QQ986945193");
        return list;
    }

    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //停止刷新
                mSwipeLayout.setRefreshing(false);

            }
        }, 3000);
    }
}
