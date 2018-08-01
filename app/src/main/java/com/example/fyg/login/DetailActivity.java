package com.example.fyg.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private Button btn_accept;
    private Button btn_giveup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        btn_accept = (Button) findViewById(R.id.btn_accept);
        btn_giveup = (Button) findViewById(R.id.btn_giveup);

        btn_accept.setOnClickListener(new MyClickListener1());
        btn_giveup.setOnClickListener(new MyClickListener2());

        TextView text = (TextView) this.findViewById(R.id.textView8);
        String str = "用户名：\n" +
                "取货地点：\n" +
                "收货地点：\n" +
                "收货时间：\n" +
                "价格：";
        text.setText(str);
    }

    class MyClickListener1 implements OnClickListener {
        @Override
        public void onClick(View v) {
            refresh();
        }
    }

    protected void refresh(){
        Toast.makeText(DetailActivity.this, "您接受了任务", Toast.LENGTH_LONG).show();
        TextView text = (TextView) this.findViewById(R.id.textView8);
        String str = "用户名：\n" +
                "取货地点：\n" +
                "收货地点：\n" +
                "收货时间：\n" +
                "价格：\n" +
                "取件密码：\n";
        text.setText(str);
        btn_giveup.setVisibility(View.INVISIBLE);
        btn_accept.setVisibility(View.INVISIBLE);
    }

    class MyClickListener2 implements OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(DetailActivity.this, "您取消了任务", Toast.LENGTH_LONG).show();
            startActivity(new Intent(DetailActivity.this, HelpGetActivity.class));
        }
    }
}

