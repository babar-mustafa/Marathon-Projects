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
public class ComponyNAme_to_Students extends Fragment {
    private ListView emailList;
    private ArrayList<Compony_Info> messages;
    private Compony_name_show_adapter listAdapter;
    Compony_Info data;
    public static String c_name;

    public ComponyNAme_to_Students() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_compony_name, container, false);
        emailList = (ListView) view.findViewById(R.id.list_view_for_componuyname);
        messages = new ArrayList<>();
        listAdapter = new Compony_name_show_adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("Admin-Panel")
                .child("Company_info_for_admin")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(Compony_Info.class);
                        Compony_Info info = new Compony_Info(data.getC_UID(),data.getC_Name(),data.getC_Email(),data.getC_Password(),data.getC__webaddress());
                        c_name = data.getC_Name();
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
