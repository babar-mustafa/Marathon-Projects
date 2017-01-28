package com.example.babarmustafa.parkingsystem.Adapters;

/**
 * Created by BabarMustafa on 1/27/2017.
 */

//public class user_show_Adapter {
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.babarmustafa.parkingsystem.Models.User_model;
import com.example.babarmustafa.parkingsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class  user_show_Adapter extends BaseAdapter {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private  Compony_name_show_adapter listapater;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private ArrayList<User_model> dataList;
    private Context context;

    public  user_show_Adapter(ArrayList<User_model> dataList, Context context) {
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
        View view = inflater.inflate(R.layout.show_user, null);


        TextView forname = (TextView) view.findViewById(R.id.for_user_naem);
//        CircularImageView pcircularImageView = (CircularImageView) view.findViewById(R.id.profile_view);

        final User_model data = dataList.get(position);

        // String username = data.getName();
//        String iml = data.getProfile_image();
//        Toast.makeText(context, ""+iml, Toast.LENGTH_SHORT).show();



//mAuth.getCurrentUser().toString();

        //to still the condition after changes
        final User_model todoChekd = (User_model) getItem(position);
        forname.setText(dataList.get(position).getName());
//        System.out.print(""+data.getProfile_image());
        //Picasso.with(context).load(data.getProfile_image()).into(pcircularImageView);


        return view;
    }
}

