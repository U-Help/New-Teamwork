package com.example.fyg.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FindGetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner mSpinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_get);

        // 获取界面布局文件中的Spinner组件
        mSpinner = (Spinner) findViewById(R.id.spin);

        String[] arr = { "初识Android开发", "Android初识开发", "Android中级开发",
                "Android高级开发", "Android开发进阶"};
        // 创建ArrayAdapter对象
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arr);
        // 为Spinner设置Adapter
        mSpinner.setAdapter(adapter);


        // 为Spinner设置选中事件监听器
        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String content = parent.getItemAtPosition(position).toString();
        if(parent.getId()==R.id.spin)
            Toast.makeText(FindGetActivity.this, "选择的收货地址是：" + content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
