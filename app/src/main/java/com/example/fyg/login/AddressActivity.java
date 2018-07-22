package com.example.fyg.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AddressActivity extends AppCompatActivity {
    private Button btnAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        btnAddr=findViewById(R.id.btnAddr);
        btnAddr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this, AddaddrActivity.class));
            }
        });
    }
}
