package com.example.babarmustafa.parkingsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.babarmustafa.parkingsystem.Adapters.TabsAdapter;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.LIst_Of_User;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.all_bokked_admin;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.all_feedback;

import java.util.ArrayList;

public class Welcome_For_Admin extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabsAdapter adapter;
    private ArrayList<Fragment> FragmentArrayList_for_compony;
    private LIst_Of_User tab1;
    private all_feedback tabe;
    private all_bokked_admin tabre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__for__admin);
        tab1 = new LIst_Of_User();
        tabe = new all_feedback();
        tabre = new all_bokked_admin();


        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_to_a);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_to_a);
        FragmentArrayList_for_compony = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_for_compony.add(tab1);
      FragmentArrayList_for_compony.add(tabe);
        FragmentArrayList_for_compony.add(tabre);


        mTabLayout.addTab(mTabLayout.newTab().setText("User_LIst"));
        mTabLayout.addTab(mTabLayout.newTab().setText("all_feedback"));
        mTabLayout.addTab(mTabLayout.newTab().setText("all_booked_places"));

        adapter = new TabsAdapter(getSupportFragmentManager(), FragmentArrayList_for_compony);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        new LIst_Of_User();
                        break;
                    case 1:
                        new all_feedback();
                        break;
                    case 2:
                        new all_bokked_admin();
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
