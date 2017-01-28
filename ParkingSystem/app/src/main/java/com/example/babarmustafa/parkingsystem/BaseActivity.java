package com.example.babarmustafa.parkingsystem;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by BabarMustafa on 1/28/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startChecking();
    }

    private void startChecking(){
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkEnds();
                startChecking();
            }
        },1000);
    }

    private void checkEnds(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference databse = db.getReference();
        databse
                .child("Reserve Positions")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"));
                        Map<String, String> map = (Map)dataSnapshot.getValue();
                        if(map != null) {
                            try {
                                String dstr = map.get("date");
                                int hours = Integer.valueOf(map.get("hours"));
                                Date startDate = sdf.parse(dstr);

                                Calendar cal = Calendar.getInstance();
                                cal.setTime(startDate);
                                cal.add(Calendar.HOUR_OF_DAY, hours);
                                Date endDate = cal.getTime();

                                Date today = new Date();
                                if (today.after(endDate)) {
                                    databse.child("Reserve Positions").child(dataSnapshot.getKey()).removeValue();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

}
