package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.babarmustafa.parkingsystem.Adapters.user_show_Adapter;
import com.example.babarmustafa.parkingsystem.Models.User_model;
import com.example.babarmustafa.parkingsystem.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LIst_Of_User extends Fragment {
    private ListView emailList;
    private ArrayList<User_model> messages;
    private user_show_Adapter listAdapter;
    User_model data;
    public static String c_name;
    String pId;
    ArrayList<String> list;

    public LIst_Of_User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list__of__user, container, false);
        list = new ArrayList<>();

        emailList = (ListView) view.findViewById(R.id.list_view_fo);
        messages = new ArrayList<>();
        listAdapter = new user_show_Adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("User_info")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(User_model.class);
                        list.add(data.getUID());
                        User_model info = new User_model(data.getUID(),data.getName(),data.getEmail(),data.getPassword(),data.getGEnder());
//                        c_name = data.getC_Name();

                        messages.add(info);
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
