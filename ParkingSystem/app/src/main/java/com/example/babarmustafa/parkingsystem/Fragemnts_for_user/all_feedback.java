package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.babarmustafa.parkingsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class all_feedback extends Fragment {
    private ListView emailList;
    private ArrayList<feedback_from_user> messages;
    private feed_show_Adapter listAdapter;
    feedback_from_user data;
    public static String c_name;
    String pId;
    ArrayList<String> list;
    String name_of_company;
    String web_of_comopany;
    String email_of_comopany;
    String pus_str;
    private FirebaseAuth auth;

    public all_feedback() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_all_feedback, container, false);
        list = new ArrayList<>();
        auth = FirebaseAuth.getInstance();
        emailList = (ListView) view.findViewById(R.id.list_viewe);
        messages = new ArrayList<>();
        listAdapter = new feed_show_Adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("for_admin_feedback")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(feedback_from_user.class);
                        list.add(data.getEmail());
                        feedback_from_user ino = new feedback_from_user(data.push_id,data.getName(),data.getEmail(),data.getFedback());
//                        c_name = data.getC_Name();

                        messages.add(ino);
                        listAdapter.notifyDataSetChanged();
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
        emailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                list.get(position);
              name_of_company = messages.get(position).getName();
        web_of_comopany = messages.get(position).getEmail();
              email_of_comopany = messages.get(position).getFedback();
                pus_str= messages.get(position).getPush_id();
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Rely From_FeedBack");
                builder.setPositiveButton("Reply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String details_for_user = "Dear: " +name_of_company;
                        details_for_user += "\nIN Response to your This Feedback: " +email_of_comopany;
                        details_for_user += "\nRespnse... ?" ;

                        details_for_user += "\nThank You!";
                        Intent intent =new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:"+web_of_comopany));
                        intent.putExtra(intent.EXTRA_SUBJECT,"Response from feedback");
                        intent.putExtra(intent.EXTRA_TEXT, details_for_user);
                        if(intent.resolveActivity(getActivity().getPackageManager())!= null){
                            startActivity(intent);
                        }
                    }
                });
                builder.setNegativeButton("Delte", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase
                                .getInstance()
                                .getReference()
                                .child("for_admin_feedback")
                                .child(pus_str)
                                .removeValue();
                        listAdapter.notifyDataSetChanged();
                        Toast.makeText(getActivity(), "feedback deleted succesfully", Toast.LENGTH_SHORT).show();


                    }
                });
builder.create().show();

            }
        });

        return view ;
    }

}
