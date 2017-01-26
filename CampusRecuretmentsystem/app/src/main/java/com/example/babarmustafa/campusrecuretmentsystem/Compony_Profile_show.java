package com.example.babarmustafa.campusrecuretmentsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Compony_Profile_show extends AppCompatActivity {

    String name ;
    String email;
    String web;
    TextView n;
    TextView e;
    TextView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compony__profile_show);
        n = (TextView) findViewById(R.id.com_name_to_s);
        e = (TextView) findViewById(R.id.com_email_to_s);
        w = (TextView) findViewById(R.id.com_web_to_s);

        name = getIntent().getStringExtra("compony_name");
        email = getIntent().getStringExtra("compony_email");
        web = getIntent().getStringExtra("compony_web");

        n.setText("Company Name:" +name);
        e.setText("Company Email:" +email);
        w.setText("Company Web:" +web);
    }
}
