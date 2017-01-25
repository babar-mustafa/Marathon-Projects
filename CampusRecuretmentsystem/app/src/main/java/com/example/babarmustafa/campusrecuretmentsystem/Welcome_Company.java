package com.example.babarmustafa.campusrecuretmentsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Welcome_Company extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter adapter;
    private ArrayList<Fragment> FragmentArrayList_for_compony;
    private ComponyPost Tab;
    private Details_of_Student_for_Compony Tab00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__company);
        Tab = new ComponyPost();
        Tab00 = new Details_of_Student_for_Compony();


        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentArrayList_for_compony = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_for_compony.add(Tab);
        FragmentArrayList_for_compony.add(Tab00);


        mTabLayout.addTab(mTabLayout.newTab().setText("Compony Jobs"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Student Details"));

        adapter = new TabAdapter(getSupportFragmentManager(), FragmentArrayList_for_compony);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        new ComponyPost();
                        break;
                    case 1:
                        new Details_of_Student_for_Compony();
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
    }
}
