package com.example.babarmustafa.campusrecuretmentsystem;

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

/**
 * Created by BabarMustafa on 1/26/2017.
 */

//public class All_job_Show_Adapter {
//}

public class  All_job_Show_Adapter  extends BaseAdapter {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private ArrayList<Job_Posted> dataList;
    private ArrayList<Compony_Info> dataLt;
    private Context context;

    public All_job_Show_Adapter(ArrayList<Job_Posted> dataList, ArrayList<Compony_Info> dataLt, Context context) {
        this.dataList = dataList;
        this.dataLt = dataLt;
        this.context = context;
    }

    public  All_job_Show_Adapter (ArrayList<Job_Posted> dataList, Context context) {
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
        View view = inflater.inflate(R.layout.all_jobs_view, null);


        TextView for_job_Pc_name = (TextView) view.findViewById(R.id.c_name_all);
        TextView des = (TextView) view.findViewById(R.id.c_des_all);

//        CircularImageView pcircularImageView = (CircularImageView) view.findViewById(R.id.profile_view);

        final Job_Posted data = dataList.get(position);

        //String username = data.getName();
//        String iml = data.getProfile_image();
//        Toast.makeText(context, ""+iml, Toast.LENGTH_SHORT).show();



//mAuth.getCurrentUser().toString();

        //to still the condition after changes
       // final Student_info todoChekd = (Student_info) getItem(position);
        Job_Posted job_posted = new Job_Posted();
        des.setText(data.getPo_Description());

       for_job_Pc_name.setText(data.getPo_Name());
//        System.out.print(""+data.getProfile_image());
        //Picasso.with(context).load(data.getProfile_image()).into(pcircularImageView);


        return view;
    }
}

