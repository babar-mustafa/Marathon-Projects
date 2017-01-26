package com.example.babarmustafa.campusrecuretmentsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details_of_Student_for_Compony extends Fragment {
    private ListView emailList;
    private ArrayList<Student_info> messages;
    private Student_show_Adapter listAdapter;
    Student_info data;
    ArrayList<String> list;

    public Details_of_Student_for_Compony() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_of__student_for__compony, container, false);
        list = new ArrayList<>();
        emailList = (ListView) view.findViewById(R.id.list_view);
        messages = new ArrayList<>();
        listAdapter = new Student_show_Adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        FirebaseDatabase.getInstance()
                .getReference()
                .child("Admin-Panel")
                .child("Student_info_for_admin")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(Student_info.class);
                        list.add(data.getUID());
                        Student_info info = new Student_info(data.getUID(),data.getName(),data.getEmail(),data.getPassword(),data.getGEnder());
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
        emailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent call = new Intent(getActivity(),Studen_Profile_Show.class);

                list.get(position);
                String name_of_student = messages.get(position).getName();
                String email_of_student = messages.get(position).getEmail();
                String gender_of_student = messages.get(position).getGEnder();

                call.putExtra("student_name", name_of_student);
                call.putExtra("student_gender", gender_of_student);
                call.putExtra("student_email", email_of_student);

                startActivity(call);
            }
        });
        return  view;
    }

}
