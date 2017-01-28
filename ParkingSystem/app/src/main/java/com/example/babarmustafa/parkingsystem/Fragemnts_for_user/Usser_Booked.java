package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.babarmustafa.parkingsystem.Adapters.Compony_name_show_adapter;
import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
import com.example.babarmustafa.parkingsystem.R;
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
public class Usser_Booked extends Fragment {
    private ListView emailList;
    private ArrayList<USer_POsition> messages;
    private Compony_name_show_adapter listAdapter;
    USer_POsition data;
    public static String c_name;
    String pId;
    ArrayList<String> list;
    private FirebaseAuth mAuth ;
    DatabaseReference databse;
    public HashMap<String, String> hashObj = new HashMap<>();
    String current_name;
    String current_email;
    feedback_from_user fe;
    EditText to_feed;
    String push_id;
    public Usser_Booked() {
        // Required empty public constructor
    }

    public Usser_Booked(String position_a) {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view =  inflater.inflate(R.layout.fragment_usser__booked, container, false);
        list = new ArrayList<>();
        databse = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        emailList = (ListView) view.findViewById(R.id.list_view_for_componuyname);
        messages = new ArrayList<>();
        listAdapter = new Compony_name_show_adapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        databse
                .child("User_info")
                .child(mAuth.getCurrentUser().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Map<String, String> map = (Map)dataSnapshot.getValue();


                        current_name =map.get("Name");
                        current_email =map.get("Email");

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
        FirebaseDatabase.getInstance()
                .getReference()
                .child("ssingle_user_reserved")
                .child(mAuth.getCurrentUser().getUid())
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        data = dataSnapshot.getValue(USer_POsition.class);
                        list.add(data.getPosition_a());
                        USer_POsition in = new USer_POsition(data.getPosition_a());
                        messages.add(in);
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
                list.get(position);
                final String pos_to_park = messages.get(position).getPosition_a();
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("want to Leave");
                builder.setPositiveButton("Leave", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Reserve Positions").child(pos_to_park).removeValue();
                        listAdapter.notifyDataSetChanged();

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                        builder1.setTitle("FeedBack");
                        builder1.setMessage("PLease give Your Feedback");
                        View vieww = LayoutInflater.from(getActivity()).inflate(R.layout.feed_back_show, null);
                to_feed = (EditText) vieww.findViewById(R.id.for_feed_back);



                        builder1.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String u_feedback = to_feed.getText().toString();
push_id = databse.push().getKey();
                                fe = new feedback_from_user(push_id,current_name,current_email,u_feedback);
                                hashObj.put("fedback",fe.getFedback());
                                hashObj.put("Name",fe.getName());
                                hashObj.put("Email",fe.getEmail());
                                hashObj.put("push_id",fe.getPush_id());
                                databse
                                        .child("User_FeedBack")
                                        .child(mAuth.getCurrentUser().getUid())
                                        .child(push_id)
                                        .setValue(hashObj);
                                databse
                                        .child("for_admin_feedback")
//                                        .child(mAuth.getCurrentUser().getUid())
                                        .child(push_id)
                                        .setValue(hashObj);


                            }
                        });
builder1.setView(vieww);
                        builder1.create().show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
builder.create().show();

            }
        });
//        FirebaseDatabase.getInstance()
//                .getReference()
//                .child("ssingle_user_reserved")
//                .child(mAuth.getCurrentUser().getUid())
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        data = dataSnapshot.getValue(USer_POsition.class);
//                        list.add(data.getPosition_a());
//                        USer_POsition in = new USer_POsition(data.getPosition_a());
//                        messages.add(in);
//                        listAdapter.notifyDataSetChanged();
////
////
////                        //map.get();
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });


        return view;
    }

}
