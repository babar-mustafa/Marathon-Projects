package com.example.babarmustafa.campusrecuretmentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Jobs extends Fragment {
    private ListView emailList;
    private ArrayList<Job_Posted> messages;
    private All_job_Show_Adapter listAdapter;
    Job_Posted data;


    public Jobs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
   View view =  inflater.inflate(R.layout.fragment_jobs, container, false);
        emailList = (ListView) view.findViewById(R.id.list_view_all_jobs);
        messages = new ArrayList<>();
        listAdapter = new All_job_Show_Adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("Jobs_from_compony")
                .child("Jobs_Post")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(Job_Posted.class);
                        Job_Posted ifo = new Job_Posted(data.getPo_Description(),data.getPo_Name());
                        messages.add(ifo);
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
        return view;
    }

}
