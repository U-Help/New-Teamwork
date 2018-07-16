package com.example.fyg.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText editUsername;
    private EditText editPassword;
    public static  final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister=findViewById(R.id.btnRegister);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                    postRegister();
            }
        });
    }

    public void postRegister(){
        OkHttpClient client=new OkHttpClient();
        String username=editUsername.getText().toString();
        String password=editPassword.getText().toString();

        HashMap<String,String> map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        JSONObject jsonObject=new JSONObject(map);
        String jsonStr=jsonObject.toString();
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request=new Request.Builder()
                .url("http://47.106.160.148:5000/register")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Looper.prepare();
                Toast.makeText(RegisterActivity.this,"Register Failed",Toast.LENGTH_LONG).show();
                Looper.loop();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this,response.body().string(),Toast.LENGTH_LONG).show();
                    Looper.loop();
                }
                else
                {
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this,"Register Response Failed "+response.body().string(),Toast.LENGTH_LONG).show();
                    Looper.loop();
                }
            }
        });
        finish();
    }

}





