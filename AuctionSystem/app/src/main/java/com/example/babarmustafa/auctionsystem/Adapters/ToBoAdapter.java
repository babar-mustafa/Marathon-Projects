package com.example.babarmustafa.auctionsystem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.babarmustafa.auctionsystem.Models.Data_Mobiles;
import com.example.babarmustafa.auctionsystem.Models.bid_moddl;
import com.example.babarmustafa.auctionsystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by babar on 1/29/2017.
 */

//public class ToBoAdapter {
//}

public class ToBoAdapter extends BaseAdapter {
    private List<bid_moddl> dataList;
    private Context context;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public ToBoAdapter(List<bid_moddl> dataList, Context context) {
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
        View view = inflater.inflate(R.layout.single_bid,null);

        TextView foename = (TextView) view.findViewById(R.id.bidview);
        TextView foenamep = (TextView) view.findViewById(R.id.bidiew);



        final  bid_moddl data = dataList.get(position);

        String nam = data.getBidded();
        String namp = data.getBider_name();



        //to still the condition after changes
        final bid_moddl todoChekd = (bid_moddl) getItem(position);



        foename.setText(nam + "");
        foenamep.setText(namp);


        return view;
    }
}
