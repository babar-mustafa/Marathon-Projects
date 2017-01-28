package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
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
public class all_bokked_admin extends Fragment {
    private ListView emailList;
    private ArrayList<USer_POsition> messages;
    private all_jaga_show_adapter listAdapter;
    USer_POsition data;

    public all_bokked_admin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_all_bokked_admin, container, false);
//        list = new ArrayList<>();
//        auth = FirebaseAuth.getInstance();
        emailList = (ListView) view.findViewById(R.id.li);
        messages = new ArrayList<>();
        listAdapter = new all_jaga_show_adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("Reserve Positions")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(USer_POsition.class);
//                        list.add(data.getEmail());
                        USer_POsition io = new USer_POsition(data.getPosition_a());
//                        c_name = data.getC_Name();

                        messages.add(io);
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
