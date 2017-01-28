package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.TimePicker;
import android.widget.Toast;

import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
import com.example.babarmustafa.parkingsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Parking_Place_one extends Fragment {
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
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_bbbb)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{


                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_bbbb;
                                                    details_for_user += "\nThank You!";
                                                    po = new USer_POsition(position_bbbb);
                                                    hashObj.put("position_a", po.getPosition_a());
                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_bbbb)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_two_m4.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                           }
                        });


            }
        });
        for_row_two_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bbb = "Row 2 place Third";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_bbb)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_bbb;
                                                    details_for_user += "\nThank You!";
                                                    po = new USer_POsition(position_bbb);
                                                    hashObj.put("position_a", po.getPosition_a());

                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_bbb)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);


                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_two_m3.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });
///
        for_row_two_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_bb = "Row 2 place Second";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_bb)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_bb;
                                                    details_for_user += "\nThank You!";

                                                    po = new USer_POsition(position_bb);
                                                    hashObj.put("position_a", po.getPosition_a());
                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_bb)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);


                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_two_m2.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });

        ////
        for_row_two_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_b = "Row 1 place first";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_b)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_b;
                                                    details_for_user += "\nThank You!";
                                                    po = new USer_POsition(position_b);
                                                    hashObj.put("position_a", po.getPosition_a());
                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_b)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_two_m1.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });

        //****************************************************************
        //fffff for row 2 work
//eeeeee for row 1 work
        for_row_one_m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aaaa = "Row 1 place Fourth";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_aaaa)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_aaaa;
                                                    details_for_user += "\nThank You!";

                                                    po = new USer_POsition(position_aaaa);
                                                    hashObj.put("position_a", po.getPosition_a());
                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_aaaa)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);
                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_one_m4.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });
        for_row_one_m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aaa = "Row 1 place Third";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_aaa)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_aaa;
                                                    details_for_user += "\nThank You!";

                                                    po = new USer_POsition(position_aaa);
                                                    hashObj.put("position_a", po.getPosition_a());
                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_aaa)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_one_m3.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });
///
        for_row_one_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_aa = "Row 1 place Second";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_aa)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposition_a " + "Ground Floor" + position_aa;
                                                    details_for_user += "\nThank You!";

                                                    po = new USer_POsition(position_aa);
                                                    hashObj.put("position_a", po.getPosition_a());

                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }
                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_aa)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_one_m2.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });

   ////
        for_row_one_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position_a = "Row 1 place first";
                databse
                        .child("Reserve Positions")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(position_a)){
                                    Toast.makeText(getActivity(), "This place is Already Reserved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    current_usaer_login =  auth.getCurrentUser().getUid();
                                    databse
                                            .child("User_info")
                                            .child(current_usaer_login)
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Map<String, String> map = (Map)dataSnapshot.getValue();


                                                    current_user_name =map.get("Name");
                                                    current_user_email =map.get("Email");
                                                    current_user_gender =map.get("GEnder");


                                                    Random r = new Random();
                                                    int to_get_random_number = r.nextInt(50 - 0) + 65;

                                                    String details_for_user = "Namae:" +current_user_name;
                                                    details_for_user += "\nEmail ?" +current_user_email;
                                                    details_for_user += "\nGender ?" +current_user_gender;
                                                    details_for_user += "\nParking Number:" + to_get_random_number;
                                                    details_for_user += "\nposit" + position_a;
                                                    details_for_user += "\nThank You!";

                                                    po = new USer_POsition(position_a);

                                                    hashObj.put("position_a", po.getPosition_a());


                                                    Intent intent =new Intent(Intent.ACTION_SENDTO);
                                                    intent.setData(Uri.parse("mailto:"));
                                                    intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                                    intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                                    if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                                        startActivity(intent);
                                                    }


                                                    databse
                                                            .child("Reserve Positions")
                                                            .child(position_a)
                                                            .setValue(hashObj);
                                                    databse
                                                            .child("ssingle_user_reserved")
                                                            .child(auth.getCurrentUser().getUid())
                                                            .push()
                                                            .setValue(hashObj);

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                }

                                for_row_one_m1.setBackgroundResource(R.drawable.parked);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });
        //eeeeee for row 1 work
        return view;

    }

}
