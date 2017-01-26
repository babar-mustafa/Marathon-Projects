package com.example.babarmustafa.campusrecuretmentsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin extends Fragment {

    EditText a_email;
    EditText a_pas;
    Button a_for_sigin_in;

    public Admin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin, container, false);
        a_email = (EditText) view.findViewById(R.id.a_email);
        a_pas = (EditText) view.findViewById(R.id.a_pass);
        a_for_sigin_in = (Button) view.findViewById(R.id.a_buttobn);
        a_for_sigin_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(a_email.getText().toString().equals("babar_admin@gmail.com") && a_pas.getText().toString().equals("aaaa"))
                {
                    Intent tyuio = new Intent(getActivity(),Welcome_Admin.class);
                    startActivity(tyuio);
                }
                else{
                    Toast.makeText(getActivity(), "password or user name not Correct", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
