package com.example.babarmustafa.auctionsystem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.babarmustafa.auctionsystem.Models.User_model;
import com.example.babarmustafa.auctionsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by babar on 1/29/2017.
 */


public class Signup_Adapter extends BaseAdapter {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Signup_Adapter listapater;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private ArrayList<User_model> dataList;
    private Context context;

    public Signup_Adapter(ArrayList<User_model> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public User_model getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        // final View inflater = LayoutInflater.from(MainView.this).inflate(R.layout.for_messages,null);
        View view = inflater.inflate(R.layout.signle_user_show, null);


        TextView forname = (TextView) view.findViewById(R.id.v_username);
        CircularImageView pcircularImageView = (CircularImageView) view.findViewById(R.id.profile_view);

        final User_model data = dataList.get(position);

        String username = data.getName();
//        String iml = data.getProfile_image();
//        Toast.makeText(context, ""+iml, Toast.LENGTH_SHORT).show();



//mAuth.getCurrentUser().toString();

        //to still the condition after changes
        final User_model todoChekd = (User_model) getItem(position);
        forname.setText(dataList.get(position).getName());
//        System.out.print(""+data.getProfile_image());
        Picasso.with(context).load(R.drawable.usernullimage).into(pcircularImageView);


        return view;
    }
}
