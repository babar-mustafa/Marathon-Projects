package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/26/2017.
 */

//public class Compony_Post_Adapter {
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Compony_Post_Adapter extends BaseAdapter {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private   Compony_Post_Adapter  listapater;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private ArrayList<Job_Posted> dataList;
    private Context context;

    public Compony_Post_Adapter(ArrayList<Job_Posted> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Job_Posted getItem(int position) {
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
        View view = inflater.inflate(R.layout.jobs_single_view, null);


        TextView forname = (TextView) view.findViewById(R.id.to_disple_name_of_c);
        TextView for_job = (TextView) view.findViewById(R.id.to_disple_job_of_c);
//        CircularImageView pcircularImageView = (CircularImageView) view.findViewById(R.id.profile_view);

        final Job_Posted data = dataList.get(position);
    // Job_Posted job_posted = new Job_Posted();


        // String username = data.getName();
//        String iml = data.getProfile_image();
//        Toast.makeText(context, ""+iml, Toast.LENGTH_SHORT).show();



//mAuth.getCurrentUser().toString();

        //to still the condition after changes
        //final Compony_Info todoChekd = (Compony_Info) getItem(position);
        forname.setText(ComponyPost.name_of_compnay);
        for_job.setText(dataList.get(position).getPo_Description());
        //forname.setText(job_posted.getPo_Description());
//        System.out.print(""+data.getProfile_image());
        //Picasso.with(context).load(data.getProfile_image()).into(pcircularImageView);


        return view;
    }
}


