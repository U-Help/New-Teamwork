package com.example.fyg.login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.String;


import okhttp3.MediaType;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText a1;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        a1 = findViewById(R.id.a1);
        initView();
    }

    private void initView(){
        //设置焦点事件
        a1.setOnFocusChangeListener(new OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if(hasFocus){
                    //这里加入name获取焦点事件时所要实现的逻辑
                }else{
                    //这里加入name失去焦点事件时所要实现的逻辑str
                    String str=a1.getText().toString();
                    //System.out.print(str);
                    if(str!="abc"){
                        Toast.makeText(ChangePasswordActivity.this, "原始密码错误", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
