package com.example.babarmustafa.auctionsystem.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.babarmustafa.auctionsystem.Adapters.ToMoAdapter;
import com.example.babarmustafa.auctionsystem.Details_Activity;
import com.example.babarmustafa.auctionsystem.Models.Data_Mobiles;
import com.example.babarmustafa.auctionsystem.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Laptops extends Fragment {
    private ListView emailList;
    String key;
    private List<Data_Mobiles> messages;
    private ToMoAdapter listAdapter;
    EditText editText, editText2;
    Button btn;
    ArrayList<String> list;
    public HashMap<String, String> hashObj = new HashMap<>();
    DatabaseReference database;
    String product_name;
    String product_city;

    public Laptops() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ciew = inflater.inflate(R.layout.fragment_laptops, container, false);
        database = FirebaseDatabase.getInstance().getReference();
        list = new ArrayList<>();
        editText = (EditText) ciew.findViewById(R.id.edit_text);
        editText2 = (EditText) ciew.findViewById(R.id.edit_text2);
        btn = (Button) ciew.findViewById(R.id.button_add);


        emailList = (ListView) ciew.findViewById(R.id.email_List);
        messages = new ArrayList<>();

        listAdapter = new ToMoAdapter(messages, getActivity());
        emailList.setAdapter(listAdapter);
        emailList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
list.get(position);
              product_name =   messages.get(position).getName_products();
               product_city =  messages.get(position).getP_city();
                Intent hsasjhd =new Intent(getActivity(), Details_Activity.class);
                startActivity(hsasjhd);
                hsasjhd.putExtra("p_of_name",product_name);
                hsasjhd.putExtra("p_of_city",product_city);

                return true;
            }

        });





//        final DatabaseReference myRef = database.getReference("AMessage");
//        final DatabaseReference myRef2 = database.getReference("City");

        // myRef.setValue("Hello Babar");
        // Read from the database

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                String city = editText2.getText().toString();
                Data_Mobiles data = new Data_Mobiles(text,city,database.child("Data").push().getKey().toString());
                hashObj.put("p_id", data.getP_id());
                hashObj.put("name_products", data.getName_products());
                hashObj.put("p_city", data.getP_city());

                database
                        .child("Mbiles_Data")
                        .child(database.child("Data").push().getKey().toString())
                        .setValue(hashObj);
//                SetValuetoFireBase();

            }


        });

        database.child("Mbiles_Data").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // This method is called once with the initial value and again
                // whenever Data at this location is updated.
                Data_Mobiles data = dataSnapshot.getValue(Data_Mobiles.class);

                list.add(data.getName_products());
                list.add(data.getP_city());
                messages.add(new Data_Mobiles(data.getName_products(),data.getP_city(),data.getP_id()));
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
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
        return ciew;
    }
//    private void SetValuetoFireBase() {
//        //myRef.push().setValue();
//        String text = editText.getText().toString();
//        String city = editText2.getText().toString();
//
//        //.setvalue send value to database and overide with new onw
//
//        Data_Mobiles data = new Data_Mobiles(database.child("Data").push().getKey().toString(),text,city);
//
//        database
//                .child("Data")
//                .child(data.getP_id())
//                .setValue(data);
//
//
//        editText.setText("");
//        editText2.setText("");
//
//
//
////        Data email = new Data(text, city, 0, checked);
////        messages.add(email);
////        listAdapter.notifyDataSetChanged();
//    }
}
