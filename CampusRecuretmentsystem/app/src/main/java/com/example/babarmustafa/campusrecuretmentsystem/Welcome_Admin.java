package com.example.babarmustafa.campusrecuretmentsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Welcome_Admin extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter adapter;
    private ArrayList<Fragment> FragmentArrayList_for_adminy;
    private ComponyNAme_to_Students Tab2566;
    private Details_of_Student_for_Compony Tab097;
    private Jobs Tab002597;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__admin);
        Tab2566 = new ComponyNAme_to_Students();
        Tab097 = new Details_of_Student_for_Compony();
        Tab002597 = new Jobs();


        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_to_a);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_to_a);
        FragmentArrayList_for_adminy = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_for_adminy.add(Tab2566);
        FragmentArrayList_for_adminy.add(Tab097);
        FragmentArrayList_for_adminy.add(Tab002597);


        mTabLayout.addTab(mTabLayout.newTab().setText("All Companies"));
        mTabLayout.addTab(mTabLayout.newTab().setText("All Students"));
        mTabLayout.addTab(mTabLayout.newTab().setText("All Jobs"));


        adapter = new TabAdapter(getSupportFragmentManager(), FragmentArrayList_for_adminy);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        new ComponyNAme_to_Students();
                        break;
                    case 1:
                        new Details_of_Student_for_Compony();
                        break;
                    case 2:
                        new Jobs();
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
