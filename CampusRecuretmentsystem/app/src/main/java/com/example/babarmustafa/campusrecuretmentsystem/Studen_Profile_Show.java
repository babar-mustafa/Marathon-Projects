package com.example.babarmustafa.campusrecuretmentsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Studen_Profile_Show extends AppCompatActivity {
    String name ;
    String email;
    String gender;
    TextView n;
    TextView e;
    TextView g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studen__profile__show);
        n = (TextView) findViewById(R.id.s_name_to_com);
        e = (TextView) findViewById(R.id.s_email_to_com);
        g = (TextView) findViewById(R.id.s_gender_to_com);

        name = getIntent().getStringExtra("student_name");
        email = getIntent().getStringExtra("student_email");
        gender = getIntent().getStringExtra("student_gender");

        n.setText("Company Name:" +name);
        e.setText("Company Email:" +email);
        g.setText("Company Web:" +gender);
    }
}
