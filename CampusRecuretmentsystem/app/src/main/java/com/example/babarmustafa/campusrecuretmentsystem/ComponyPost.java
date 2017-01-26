package com.example.babarmustafa.campusrecuretmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComponyPost extends Fragment {
    EditText for_job_post;
    Button for_post;
    String job_details_from_compony;
    private FirebaseAuth mAuth;
    DatabaseReference databse;
    public HashMap<String, String> hashObj = new HashMap<>();
    Compony_Info user;
    Job_Posted post;
    public static String name_of_compnay;
    private ListView emailList;
    private ArrayList<Job_Posted> messages;
    private Compony_Post_Adapter listAdapter;
    Job_Posted data;


    public ComponyPost() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_compony_post, container, false);
        for_job_post = (EditText) view.findViewById(R.id.job_description);
        for_post = (Button) view.findViewById(R.id.compony_post);
        databse = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        emailList = (ListView) view.findViewById(R.id.list_view_for_ccurrent_compony_jobs);
        messages = new ArrayList<>();
        listAdapter = new Compony_Post_Adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("Admin-Panel")
                .child("Jobs_Post")
                .child(mAuth.getCurrentUser().getUid())
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(Job_Posted.class);
                        Job_Posted ino = new Job_Posted(data.getPo_Description());
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

        databse
                .child("Company_info")
                .child(mAuth.getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Map<String, String> map = (Map)dataSnapshot.getValue();
                         name_of_compnay  = map.get("c_Name");

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });




        for_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                job_details_from_compony = for_job_post.getText().toString();
                post = new Job_Posted(job_details_from_compony);
                user = new Compony_Info();

                hashObj.put("po_UID", mAuth.getCurrentUser().getUid());
                hashObj.put("po_Name",name_of_compnay);
                hashObj.put("po_Description" ,post.getPo_Description());
                databse
                        .child("Admin-Panel")
                        .child("Jobs_Post")
                        .child( mAuth.getCurrentUser().getUid())
                        .push()
                        .setValue(hashObj);
                databse
                        .child("Jobs_from_compony")
                        .child("Jobs_Post")
                        .push()
                        .setValue(hashObj);


            }
        });
        return view;
    }

}
