package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.TimePicker;
import android.widget.Toast;

import com.example.babarmustafa.parkingsystem.BaseFragment;
import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
import com.example.babarmustafa.parkingsystem.R;
import com.example.babarmustafa.parkingsystem.time.SlideDateTimeListener;
import com.example.babarmustafa.parkingsystem.time.SlideDateTimePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Parking_Place_one extends BaseFragment {
    private FirebaseAuth auth;
    DatabaseReference databse;
    String current_usaer_login;
    String current_user_name;
    String current_user_email;
    String current_user_gender;
    String position_a;
    String position_aa;
    String position_aaa;
    String position_aaaa;
    String position_b;
    String position_bb;
    String position_bbb;
    String position_bbbb;
    private String format = "";
    public HashMap<String, String> hashObj = new HashMap<>();
    USer_POsition po;
    String rese;
    String hours;








    ImageButton for_row_one_m1;
    ImageButton for_row_one_m2;
    ImageButton for_row_one_m3;
    ImageButton for_row_one_m4;
    ImageButton for_row_two_m1;
    ImageButton for_row_two_m2;
    ImageButton for_row_two_m3;
    ImageButton for_row_two_m4;



    public Parking_Place_one() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_parking__place_one, container, false);

//String miilis = String.valueOf(System.currentTimeMillis());
//        Log.d("time", miilis);
//        Toast.makeText(getActivity(), ""+miilis, Toast.LENGTH_SHORT).show();
//        hours = (int) ((timeInMillis / (1000 * 60 * 60)));
//        minutes = (int) ((timeInMillis / (1000 * 60)) % 60);
//        seconds = (int) ((timeInMillis / 1000) % 60);
//
        final Calendar c = Calendar.getInstance();
        int currentTime = (c.get(Calendar.HOUR_OF_DAY) * 10000) +
                (c.get(Calendar.MINUTE) * 100) +
                (c.get(Calendar.SECOND));
        Toast.makeText(getActivity(), ""+currentTime, Toast.LENGTH_SHORT).show();


        int todaysDate =     (c.get(Calendar.YEAR) * 10000) +
                ((c.get(Calendar.MONTH) + 1) * 100) +
                (c.get(Calendar.DAY_OF_MONTH));
        Toast.makeText(getActivity(), ""+todaysDate, Toast.LENGTH_SHORT).show();

        auth = FirebaseAuth.getInstance();

        databse = FirebaseDatabase.getInstance().getReference();

        for_row_one_m1 = (ImageButton) view.findViewById(R.id.row_m_1);
        for_row_one_m2 = (ImageButton) view.findViewById(R.id.row_m_2);
        for_row_one_m3 = (ImageButton) view.findViewById(R.id.row_m_3);
        for_row_one_m4 = (ImageButton) view.findViewById(R.id.row_m_4);

        for_row_two_m1 = (ImageButton) view.findViewById(R.id.rowt_m_1);
        for_row_two_m2 = (ImageButton) view.findViewById(R.id.rowt_m_2);
        for_row_two_m3 = (ImageButton) view.findViewById(R.id.rowt_m_3);
        for_row_two_m4 = (ImageButton) view.findViewById(R.id.rowt_m_4);


        //fffff for row 2 work
        //*******************************************************
        for_row_two_m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bbbb = "Row 2 place Fourth";
                checkAndMake(position_bbbb,for_row_two_m4);
            }
        });
        for_row_two_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bbb = "Row 2 place Third";
                checkAndMake(position_bbb,for_row_two_m3);


            }
        });
///
        for_row_two_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bb = "Row 2 place Second";
                checkAndMake(position_bb,for_row_two_m2);

            }
        });

        ////
        for_row_two_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_b = "Row 1 place first";
                checkAndMake(position_b,for_row_two_m1);

            }
        });

        //****************************************************************
        //fffff for row 2 work
//eeeeee for row 1 work
        for_row_one_m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aaaa = "Row 1 place Fourth";
                checkAndMake(position_aaaa,for_row_one_m4);


            }
        });
        for_row_one_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aaa = "Row 1 place Third";
                checkAndMake(position_aaa,for_row_one_m3);

            }
        });
///
        for_row_one_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aa = "Row 1 place Second";
                checkAndMake(position_aa,for_row_one_m2);


            }
        });

   ////
        for_row_one_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_a = "Row 1 place first";
                checkAndMake(position_a,for_row_one_m1);

            }
        });
        //eeeeee for row 1 work
        return view;

    }




}
