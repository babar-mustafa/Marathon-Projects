package com.example.babarmustafa.auctionsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {

    String name;
    String city;
    TextView to_name;
    TextView to_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        to_name = (TextView) findViewById(R.id.name_i);
        to_city = (TextView) findViewById(R.id.name_cii);
        name = getIntent().getStringExtra("p_of_name");
        city = getIntent().getStringExtra("p_of_city");

        to_name.setText(name);
        to_city.setText(city);
    }
}
