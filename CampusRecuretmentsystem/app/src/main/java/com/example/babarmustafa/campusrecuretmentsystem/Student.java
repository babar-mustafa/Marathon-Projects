package com.example.babarmustafa.campusrecuretmentsystem;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;


public class Student extends Fragment {

    private ViewPager viewPager;
    private TabLayout TabLayout;
    private Student_Adapter adapter_for_S;
    private ArrayList<Fragment> FragmentArrayList;
    private StudentSign_in Tab1;
    private Studen_sign_up Tab2;


    public Student() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view =   inflater.inflate(R.layout.fragment_student, container, false);
        Tab1 = new StudentSign_in();
        Tab2 = new Studen_sign_up();


        TabLayout = (TabLayout) view.findViewById(R.id.tabbb_layout);
        viewPager = (ViewPager) view.findViewById(R.id.viewwww_pager);
        FragmentArrayList = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList.add(Tab1);
        FragmentArrayList.add(Tab2);


        TabLayout.addTab(TabLayout.newTab().setText("SignIn"));
        TabLayout.addTab(TabLayout.newTab().setText("Signup"));


        adapter_for_S = new Student_Adapter(getActivity().getSupportFragmentManager(), FragmentArrayList);

        viewPager.setAdapter(adapter_for_S);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TabLayout));

        viewPager.setOffscreenPageLimit(2);

        TabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        new StudentSign_in();
                        break;
                    case 1:
                        new Studen_sign_up();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }


}
