
package com.example.babarmustafa.campusrecuretmentsystem;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Company_signup extends Fragment {
    private FirebaseAuth mAuth;
    DatabaseReference databse;
    EditText for_c_name;
    EditText for_c_email;
    EditText for_c_password;
    EditText for_c_confirm_password;
    EditText for_c_web;
    Button for_c_signup;
    Compony_Info user;
    public HashMap<String, String> hashObj = new HashMap<>();
    ProgressDialog progres;


    public Company_signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=  inflater.inflate(R.layout.fragment_company_signup, container, false);

        databse = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();



        for_c_name = (EditText) view.findViewById(R.id.for_compony_name);
        for_c_email = (EditText) view.findViewById(R.id.for_compony_email);
        for_c_password = (EditText) view.findViewById(R.id.for_compony_password);
        for_c_confirm_password = (EditText) view.findViewById(R.id.for_compony_password_confirm);
        for_c_signup = (Button) view.findViewById(R.id.for_compony_signup);
        for_c_web = (EditText) view.findViewById(R.id.for_compony_website);

        progres = new ProgressDialog(getActivity());
        // Inflate the layout for this fragment


        for_c_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progres.setMessage("Creating a user One moment Please....");
                progres.show();
                progres.setCancelable(false);


                if (for_c_name.getText().toString().length() == 0) {
                    Toast.makeText(getContext(), "Name cannot be Blank", Toast.LENGTH_LONG).show();
                    for_c_name.setError("Enter the Name");
                    return;
                }
                if (for_c_web.getText().toString().length() == 0) {
                    Toast.makeText(getContext(), "Website cannot be Blank", Toast.LENGTH_LONG).show();
                    for_c_web.setError("Enter the website");
                    return;
                }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(for_c_email.getText().toString()).matches()) {
                    //Validation for Invalid Email Address
                    Toast.makeText(getContext(), "Invalid Email", Toast.LENGTH_LONG).show();
                    for_c_email.setError("Invalid Email address ");
                    return;
                }
                else if (for_c_password.getText().toString().length() < 5) {

                    Toast.makeText(getContext(), "Password too short", Toast.LENGTH_LONG).show();
                    for_c_password.setError(" Password must be 6 characters");
                    return;
                }

                if (for_c_password.equals(for_c_email)){
                    Toast.makeText(getContext(), "password Matched", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), "PaasWord Donot Matched Please Re-Enter The password", Toast.LENGTH_SHORT).show();
                }
                final String get_name_of_compony = for_c_name.getText().toString();
                final String get_email_of_compony = for_c_email.getText().toString();
                final String get_pass_of_compony = for_c_password.getText().toString();
                final String confirm_of_compony = for_c_name.getText().toString();
                final String get_web_of_compony  =for_c_web.getText().toString();


                mAuth.createUserWithEmailAndPassword(get_email_of_compony,get_pass_of_compony)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //if authentication failed soo....
                                if (!task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "Authentication Failed",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else {

                                    String id = mAuth.getCurrentUser().getUid();

                                    user = new Compony_Info(id, get_name_of_compony, get_email_of_compony, get_pass_of_compony,get_web_of_compony);


                                    hashObj.put("c_UID", user.getC_UID());
                                    hashObj.put("c_Name", user.getC_Name());
                                    hashObj.put("c_Email", user.getC_Email());
                                    hashObj.put("c_Password", user.getC_Password());
                                    hashObj.put("c__webaddress", user.getC__webaddress());


                                    Toast.makeText(getActivity(), "Company_info Created Succesfully", Toast.LENGTH_SHORT).show();
                                    databse.child("Company_info").child(user.getC_UID()).setValue(hashObj);
                                    databse.child("Admin-Panel").child("Company_info_for_admin").child(user.getC_UID()).setValue(hashObj);
                                    progres.dismiss();
                                    //to close activity


                                }

                            }
                        });


            }
        });
        return view;
    }

}
