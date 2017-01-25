package com.example.babarmustafa.campusrecuretmentsystem;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter adapter;
    private ArrayList<Fragment> mFragmentArrayList;
    private Admin mTab1;
    private Company mTab2;
    private Student mTab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTab1 = new Admin();
        mTab2 = new Company();
        mTab3 = new Student();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mFragmentArrayList = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        mFragmentArrayList.add(mTab1);
        mFragmentArrayList.add(mTab2);
        mFragmentArrayList.add(mTab3);

        mTabLayout.addTab(mTabLayout.newTab().setText("Admin"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Company"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Student"));

        adapter = new TabAdapter(getSupportFragmentManager(), mFragmentArrayList);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        new Admin();
                        break;
                    case 1:
                        new Company();
                        break;
                    case 3:
                        new Student();
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