package com.example.babarmustafa.campusrecuretmentsystem;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Company extends Fragment {
    private ViewPager viewPager;
    private android.support.design.widget.TabLayout TabLayout;
    private Student_Adapter adapter_for_S;
    private ArrayList<Fragment> FragmentArrayList_c;
    private Company_signin Tab1_c;
    private Company_signup Tab2_c;

    public Company() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_company, container, false);
        Tab1_c = new Company_signin();
        Tab2_c = new Company_signup();


        TabLayout = (TabLayout) view.findViewById(R.id.tab_c_layout);
        viewPager = (ViewPager) view.findViewById(R.id.view_C_pager);
        FragmentArrayList_c = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_c.add(Tab1_c);
        FragmentArrayList_c.add(Tab2_c);


        TabLayout.addTab(TabLayout.newTab().setText("SignIn_C"));
        TabLayout.addTab(TabLayout.newTab().setText("Signup_C"));


        adapter_for_S = new Student_Adapter(getActivity().getSupportFragmentManager(), FragmentArrayList_c);

        viewPager.setAdapter(adapter_for_S);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TabLayout));

        viewPager.setOffscreenPageLimit(2);

        TabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        new Company_signin();
                        break;
                    case 1:
                        new Company_signup();
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
