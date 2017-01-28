package com.example.babarmustafa.parkingsystem;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
import com.example.babarmustafa.parkingsystem.time.SlideDateTimeListener;
import com.example.babarmustafa.parkingsystem.time.SlideDateTimePicker;
import com.google.firebase.auth.FirebaseAuth;
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
 * Created by BabarMustafa on 1/28/2017.
 */

public class BaseFragment extends Fragment {

    private FirebaseAuth auth=FirebaseAuth.getInstance();;
    DatabaseReference databse;
    String current_usaer_login;
    String current_user_name;
    String current_user_email;
    String current_user_gender;
    public HashMap<String, String> hashObj = new HashMap<>();
    USer_POsition po;

    protected void checkAndMake(final String pos, final ImageButton button){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databse = db.getReference();
        databse
                .child("Reserve Positions")
                .child(pos)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot != null){
                            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"));
                            Map<String, String> map = (Map)dataSnapshot.getValue();
                            if(map != null){
                                try{
                                    String dstr = map.get("date");
                                    int hours = Integer.valueOf(map.get("hours"));
                                    Date startDate = sdf.parse(dstr);

                                    Calendar cal =Calendar.getInstance();
                                    cal.setTime(startDate);
                                    cal.add(Calendar.HOUR_OF_DAY,hours);
                                    Date endDate = cal.getTime();

                                    Date today = new Date();
                                    if(today.after(startDate) && today.before(endDate)){
                                        Toast.makeText(getActivity(), "This place is already reserved on this date", Toast.LENGTH_SHORT).show();
                                    }else{
                                        insBooking(pos,button);
                                    }
                                }catch (Exception e){
                                    Log.e("TEST",e.getMessage());
                                    e.printStackTrace();
                                }
                            }else{
                                insBooking(pos,button);
                            }
                        }
                        else{
                            insBooking(pos,button);

                        }



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    protected void insBooking(final String pos, final ImageButton button){
        new SlideDateTimePicker.Builder(getActivity().getSupportFragmentManager())
                .setListener(new SlideDateTimeListener() {
                    @Override
                    public void onDateTimeSet(Date date,String hrs) {
                        final String rese= date.toString();
                        final String hours = hrs;

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
                                        details_for_user += "\nposition_a " + "Ground Floor" + pos;
                                        details_for_user += "\nThank You!";

                                        po = new USer_POsition(pos);
                                        hashObj.put("position_a", po.getPosition_a());
                                        hashObj.put("hours",hours);
                                        hashObj.put("date",rese);
                                        Intent intent =new Intent(Intent.ACTION_SENDTO);
                                        intent.setData(Uri.parse("mailto:"));
                                        intent.putExtra(intent.EXTRA_SUBJECT,"Placed Reserved LOcation" +"Row One position_a One");
                                        intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                                        if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                                            // startActivity(intent);
                                        }

                                        button.setBackgroundResource(R.drawable.parked);
                                        databse
                                                .child("Reserve Positions")
                                                .child(pos)
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
                })
                .setInitialDate(new Date())
                .build()
                .show();


    }
}
