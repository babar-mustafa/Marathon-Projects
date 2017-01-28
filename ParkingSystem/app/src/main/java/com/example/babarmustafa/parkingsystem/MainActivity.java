package com.example.babarmustafa.parkingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity extends AppCompatActivity {
    CircularImageView for_user;
    CircularImageView for_admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for_user = (CircularImageView) findViewById(R.id.user);
        for_admin = (CircularImageView) findViewById(R.id.admin);

        for_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(MainActivity.this,User_login_view.class);
                startActivity(call);
            }
        });

        for_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(MainActivity.this,Welcome_For_Admin.class);
                startActivity(call);
            }
        });

    }
}
