package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


//public Parking_Place_two() {
//        // Required empty public constructor
//        }

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.babarmustafa.parkingsystem.BaseFragment;
import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
import com.example.babarmustafa.parkingsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;



/**
 * A simple {@link Fragment} subclass.
 */
public class Parking_Place_two extends BaseFragment {
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


    public HashMap<String, String> hashObj = new HashMap<>();
    USer_POsition po;






    ImageButton for_row_one_m1;
    ImageButton for_row_one_m2;
    ImageButton for_row_one_m3;
    ImageButton for_row_one_m4;
    ImageButton for_row_two_m1;
    ImageButton for_row_two_m2;
    ImageButton for_row_two_m3;
    ImageButton for_row_two_m4;


    public Parking_Place_two (){
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_parking__place_two, container, false);


        auth = FirebaseAuth.getInstance();
        databse = FirebaseDatabase.getInstance().getReference();

        for_row_one_m1 = (ImageButton) view.findViewById(R.id.ifrow_m_1);
        for_row_one_m2 = (ImageButton) view.findViewById(R.id.ifrow_m_2);
        for_row_one_m3 = (ImageButton) view.findViewById(R.id.ifrow_m_3);
        for_row_one_m4 = (ImageButton) view.findViewById(R.id.ifrow_m_4);

        for_row_two_m1 = (ImageButton) view.findViewById(R.id.ifrowt_m_1);
        for_row_two_m2 = (ImageButton) view.findViewById(R.id.ifrowt_m_2);
        for_row_two_m3 = (ImageButton) view.findViewById(R.id.ifrowt_m_3);
        for_row_two_m4 = (ImageButton) view.findViewById(R.id.ifrowt_m_4);
        //fffff for row 2 work
        //*******************************************************
        for_row_two_m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bbbb = "First Floor Row 2 user_to_model Fourth";
                checkAndMake(position_bbbb,for_row_two_m4);


            }
        });
        for_row_two_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bbb = "First Floor Row 2 user_to_model Third";
                checkAndMake(position_bbb,for_row_two_m3);


            }
        });
///
        for_row_two_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bb = "First Floor Row 2 user_to_model Second";
                checkAndMake(position_bb,for_row_two_m2);

            }
        });

        ////
        for_row_two_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_b = "First Floor Row 1 user_to_model first";
                checkAndMake(position_b,for_row_two_m1);


            }
        });

        //****************************************************************
        //fffff for row 2 work
//eeeeee for row 1 work
        for_row_one_m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aaaa = "First Floor Row 1 user_to_model Fourth";
                checkAndMake(position_aaaa,for_row_one_m4);

            }
        });
        for_row_one_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aaa = "First Floor Row 1 user_to_model Third";
                checkAndMake(position_aaa,for_row_one_m3);


            }
        });
///
        for_row_one_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aa = "First Floor Row 1 user_to_model Second";
                checkAndMake(position_aa,for_row_one_m2);

            }
        });

        ////
        for_row_one_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_a = "First Floor Row 1 user_to_model first";
                checkAndMake(position_a,for_row_one_m1);


            }
        });
        //eeeeee for row 1 work
        return view;

    }

}
