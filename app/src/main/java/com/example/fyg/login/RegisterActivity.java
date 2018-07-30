package com.example.fyg.login;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText editEmail;
    private EditText editUsername;
    private EditText editPassword;
    private EditText editTelephone;
    private TextView tv;
    public static  final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister=findViewById(R.id.btnPush);
        editEmail=findViewById(R.id.editTelephone);
        editUsername=findViewById(R.id.editPassword);
        editPassword=findViewById(R.id.editAddress);
        editTelephone=findViewById(R.id.editTelephone);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                judge();
            }
        });
    }

    public void judge() {
        String email=editEmail.getText().toString();
        String username=editUsername.getText().toString();
        String password=editPassword.getText().toString();
        String telephone=editTelephone.getText().toString();
        if (isEmail(email)==false) {
            tv = (TextView) findViewById(R.id.tv);
            tv.setText("邮箱格式错误");
        } else if (isMobile(telephone)==false) {
            tv = (TextView) findViewById(R.id.tv);
            tv.setText("手机号错误");
        } else if (isPassword(password)==false) {
            tv = (TextView) findViewById(R.id.tv);
            tv.setText("密码只能为6-16位字母数字组合");
        } else {
            postRegister(email,username,password,telephone);
        }
    }

    public static boolean isPassword(String password) {
        String REGEX_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        return Pattern.matches(REGEX_PASSWORD, password);
    }
    public static boolean isUserName(String username) {
        String REGEX_USERNAME = "^[a-zA-Z]\\\\w{5,17}$";
        return Pattern.matches(REGEX_USERNAME, username);
    }
    public static boolean isMobile(String mobile) {
        String REGEX_MOBILE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
    public static boolean isEmail(String email) {
        if (email == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        if (m.matches())
            return true;
        else
            return false;
    }


    public void postRegister(String email,String username,String password,String telephone) {
        OkHttpClient client = new OkHttpClient();
        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("username", username);
        map.put("password", password);
        map.put("telephone", telephone);
        JSONObject jsonObject = new JSONObject(map);
        String jsonStr = jsonObject.toString();
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url("http://47.106.160.148:5000/register")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Looper.prepare();
                Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_LONG).show();
                Looper.loop();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                    Looper.loop();
                } else {
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this, "Register Response Failed " + response.body().string(), Toast.LENGTH_LONG).show();
                    Looper.loop();
                }
            }
        });
        finish();
    }
}





