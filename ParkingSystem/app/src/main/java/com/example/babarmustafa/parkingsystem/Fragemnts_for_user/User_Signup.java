package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.babarmustafa.parkingsystem.Models.User_model;
import com.example.babarmustafa.parkingsystem.R;
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
public class User_Signup extends Fragment {
    private FirebaseAuth mAuth;
    DatabaseReference databse;
    EditText for_s_name;
    EditText for_s_email;
    EditText for_s_password;
    EditText for_s_confirm_password;
    Button for_s_signup;
    RadioGroup u_sex ;
    RadioButton radioButton;
    User_model user;
    public HashMap<String, String> hashObj = new HashMap<>();
    ProgressDialog progres;



    public User_Signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user__signup, container, false);
        databse = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();



        for_s_name = (EditText) view.findViewById(R.id.for_student_name);
        for_s_email = (EditText) view.findViewById(R.id.for_student_email);
        for_s_password = (EditText) view.findViewById(R.id.for_student_password);
        for_s_confirm_password = (EditText) view.findViewById(R.id.for_student_password_confirm);
        for_s_signup = (Button) view.findViewById(R.id.for_student_signup);
        u_sex = (RadioGroup) view.findViewById(R.id.radioSex);
        int selectedId=u_sex.getCheckedRadioButtonId();
        radioButton=(RadioButton)view.findViewById(selectedId);
        progres = new ProgressDialog(getActivity());
        for_s_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progres.setMessage("Creating a user One moment Please....");
                progres.show();
                progres.setCancelable(false);


                if (for_s_name.getText().toString().length() == 0) {
                    Toast.makeText(getContext(), "Name cannot be Blank", Toast.LENGTH_LONG).show();
                    for_s_name.setError("Enter the Name");
                    return;
                }  else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(for_s_email.getText().toString()).matches()) {
                    //Validation for Invalid Email Address
                    Toast.makeText(getContext(), "Invalid Email", Toast.LENGTH_LONG).show();
                    for_s_email.setError("Invalid Email address ");
                    return;
                }
                else if (for_s_password.getText().toString().length() < 5) {

                    Toast.makeText(getContext(), "Password too short", Toast.LENGTH_LONG).show();
                    for_s_password.setError(" Password must be 6 characters");
                    return;
                }

                if (for_s_password.equals(for_s_email)){
                    Toast.makeText(getContext(), "password Matched", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), "PaasWord Donot Matched Please Re-Enter The password", Toast.LENGTH_SHORT).show();
                }
                final String get_name_of_student = for_s_name.getText().toString();
                final String get_email_of_student = for_s_email.getText().toString();
                final String get_pass_of_student = for_s_password.getText().toString();
                String confirm_of_student = for_s_name.getText().toString();
                final String to_get_gender =  radioButton.getText().toString();

                mAuth.createUserWithEmailAndPassword(get_email_of_student,get_pass_of_student)
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

                                    user = new User_model(id, get_name_of_student, get_email_of_student, get_pass_of_student,to_get_gender);


                                    hashObj.put("UID", user.getUID());
                                    hashObj.put("Name", user.getName());
                                    hashObj.put("Email", user.getEmail());
                                    hashObj.put("Password", user.getPassword());
                                    hashObj.put("GEnder", user.getGEnder());

                                    Toast.makeText(getActivity(), "Student_info Created Succesfully", Toast.LENGTH_SHORT).show();
                                    databse
                                            .child("User_info")
                                            .child(user.getUID())
                                            .setValue(hashObj);

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
