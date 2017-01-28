package com.example.babarmustafa.parkingsystem.Adapters;

/**
 * Created by BabarMustafa on 1/27/2017.
 */

//public class Compony_name_show_adapter {
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.Usser_Booked;
import com.example.babarmustafa.parkingsystem.Models.USer_POsition;
import com.example.babarmustafa.parkingsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class  Compony_name_show_adapter extends BaseAdapter {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private  Compony_name_show_adapter listapater;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private ArrayList<USer_POsition> dataList;
    private Context context;

    public  Compony_name_show_adapter(ArrayList<USer_POsition> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public USer_POsition getItem(int position) {
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
        View view = inflater.inflate(R.layout.places_for_user, null);


        TextView forname = (TextView) view.findViewById(R.id.shoe);
//        CircularImageView pcircularImageView = (CircularImageView) view.findViewById(R.id.profile_view);

        final USer_POsition data = dataList.get(position);

        // String username = data.getName();
//        String iml = data.getProfile_image();
//        Toast.makeText(context, ""+iml, Toast.LENGTH_SHORT).show();



//mAuth.getCurrentUser().toString();

        //to still the condition after changes
        final USer_POsition todoChekd = (USer_POsition) getItem(position);
        forname.setText(dataList.get(position).getPosition_a());
//        System.out.print(""+data.getProfile_image());
        //Picasso.with(context).load(data.getProfile_image()).into(pcircularImageView);


        return view;
    }
}



