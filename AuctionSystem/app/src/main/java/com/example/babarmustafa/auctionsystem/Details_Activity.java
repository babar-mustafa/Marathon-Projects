package com.example.babarmustafa.auctionsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babarmustafa.auctionsystem.Adapters.ToBoAdapter;
import com.example.babarmustafa.auctionsystem.Adapters.ToMoAdapter;
import com.example.babarmustafa.auctionsystem.Fragments.Laptops;
import com.example.babarmustafa.auctionsystem.Models.Data_Mobiles;
import com.example.babarmustafa.auctionsystem.Models.User_model;
import com.example.babarmustafa.auctionsystem.Models.bid_moddl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details_Activity extends AppCompatActivity {

    String name;
    String city;
    String to_id;
    String pro_name;
    String initial_bid;
    TextView to_name;
    TextView to_city;
    EditText bidding;
    Button id_btn;
    TextView to_p_s_price;
    //private FirebaseAuth mAuth;
    DatabaseReference databse;
    public HashMap<String, String> hashObj = new HashMap<>();
    bid_moddl use_r;
   // private List<User_model> messages;
    private FirebaseAuth mAuth;

    private ListView emailList;
    String key;
    private List<bid_moddl> messages;
    private ToBoAdapter listAdapter;
    TextView b_name;
    TextView b_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        name = getIntent().getStringExtra("p_of_name");
        city = getIntent().getStringExtra("p_of_city");
        to_id = getIntent().getStringExtra("p_of_id");
        initial_bid = getIntent().getStringExtra("s_price");

        databse = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
//        messages = new ArrayList<>();
        emailList = (ListView) findViewById(R.id.email_Lis);
        messages = new ArrayList<>();
        listAdapter = new ToBoAdapter(messages,this);
        emailList.setAdapter(listAdapter);


        databse
               .child("Bid_for_products")
                .child(to_id)
                .addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // This method is called once with the initial value and again
                // whenever Data at this location is updated.
                bid_moddl data = dataSnapshot.getValue(bid_moddl.class);

               // list.add(data.getP_id());
//                list.add(data.getP_city());
                messages.add(new bid_moddl(data.getBidded(),data.getBider_name()));
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


        b_name = (TextView) findViewById(R.id.name_oo);
        b_email = (TextView) findViewById(R.id.name_cioo);
        to_name = (TextView) findViewById(R.id.name_i);
        to_city = (TextView) findViewById(R.id.name_ci);
        to_p_s_price = (TextView) findViewById(R.id.name_ciiii);
        bidding = (EditText) findViewById(R.id.bid_amount_user);
        id_btn = (Button) findViewById(R.id.bid_button_add);

        b_name.setText(Laptops.current_user_name);
        b_email.setText(Laptops.current_user_email);
        to_name.setText(name);
        to_city.setText(city);
        to_p_s_price.setText(initial_bid + "");


        id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bid = bidding.getText().toString();
                String bidn = Laptops.current_user_name;

                use_r =new bid_moddl(bid,bidn);
                hashObj.put("bidded", use_r.getBidded());
                hashObj.put("bider_name", use_r.getBider_name());
//
//                hashObj.put("bider_name", use_r.getBider_email());



                databse
                        .child("Bid_for_products")
                        .child(to_id)
                        .push()
                        .setValue(hashObj);
            }
        });
    }
}
