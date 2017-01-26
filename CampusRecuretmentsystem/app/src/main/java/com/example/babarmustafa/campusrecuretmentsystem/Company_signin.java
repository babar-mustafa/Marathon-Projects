package com.example.babarmustafa.campusrecuretmentsystem;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Company_signin extends Fragment {
    ProgressDialog progres;
    Button for_sigin_in;
    TextView jump_to_signup;
    EditText s_email;
    EditText s_passs;
    private FirebaseAuth auth;
    String usernameforlogin;
    String passwordforlogin;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    DatabaseReference databse;

    public Company_signin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view =  inflater.inflate(R.layout.fragment_company_signin, container, false);
        databse = FirebaseDatabase.getInstance().getReference();
        s_email = (EditText) view.findViewById(R.id.e_c_email);
        s_passs = (EditText) view.findViewById(R.id.e_c_pass);
        for_sigin_in = (Button) view.findViewById(R.id.login_c_buttobn);
        jump_to_signup = (TextView) view.findViewById(R.id.c_singup_calling_button);


        auth = FirebaseAuth.getInstance();
        progres = new ProgressDialog(getActivity());

        for_sigin_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progres.setMessage("Signing in....");
                progres.show();
                if (s_email.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "You Should to wirte the Email ", Toast.LENGTH_LONG).show();
                    s_email.setError("Enter The User Name ");
                    return;
                }

//                else if (a_pas.getText().toString().length() > 6) {
//                    Toast.makeText(MainActivity.this, "Password Must be 6 digits or more than 6 ", Toast.LENGTH_LONG).show();
//                    a_pas.setError("Enter The password ");
//                    return;
//                }
                else if (s_passs.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "You Must input The Password", Toast.LENGTH_LONG).show();
                    s_passs.setError("Enter The password ");
                    return;
                }


                usernameforlogin = s_email.getText().toString();
                passwordforlogin = s_passs.getText().toString();
                auth.signInWithEmailAndPassword(usernameforlogin, passwordforlogin)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = task.getResult().getUser();
                                    String Uid = user.getUid();
                                    databse
                                            .child("Company_info")
                                            .child(Uid)
                                            .addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    Compony_Info c_info = dataSnapshot.getValue(Compony_Info.class);
                                                    if(c_info != null){
                                                        Intent call = new Intent(getActivity(), Welcome_Company.class);
                                                        startActivity(call);
                                                    }
                                                    else{
                                                        Toast.makeText(getActivity(), "user not Found", Toast.LENGTH_SHORT).show();

                                                    }

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {
                                                    Toast.makeText(getActivity(), "yo are Not Company", Toast.LENGTH_SHORT).show();
                                                }
                                            });


                                }



                            }
                        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        jump_to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Company_signup()).addToBackStack(null).commit();
//                Intent i = new Intent(MainActivity.this, Signup_Form.class);
//                startActivity(i);
            }
        });

        return view;
    }

}
