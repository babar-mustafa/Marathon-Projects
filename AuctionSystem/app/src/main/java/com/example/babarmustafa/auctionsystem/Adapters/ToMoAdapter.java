package com.example.babarmustafa.auctionsystem.Adapters;

/**
 * Created by BabarMustafa on 1/28/2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.babarmustafa.auctionsystem.Models.Data_Mobiles;
import com.example.babarmustafa.auctionsystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by imran on 9/26/2016.
 */

public class ToMoAdapter extends BaseAdapter  {
    private List<Data_Mobiles> dataList;
    private Context context;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public ToMoAdapter(List<Data_Mobiles> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.singleitem,null);

        TextView foename = (TextView) view.findViewById(R.id.nameview);
        TextView foecity = (TextView) view.findViewById(R.id.cityview);
        TextView foecityp = (TextView) view.findViewById(R.id.pcityview);



        final  Data_Mobiles data = dataList.get(position);

        String nam = data.getName_products();
        String cit =data.getP_city();
        String vv= data.getS_price();


        //to still the condition after changes
        final Data_Mobiles todoChekd = (Data_Mobiles) getItem(position);



        foename.setText(nam);
        foecity.setText(cit);
        foecityp.setText(vv + "");

        return view;
    }
}
