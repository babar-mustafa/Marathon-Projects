package com.example.babarmustafa.auctionsystem;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.babarmustafa.auctionsystem.Adapters.TabAdapter;
import com.example.babarmustafa.auctionsystem.Fragments.User_Signup;
import com.example.babarmustafa.auctionsystem.Fragments.User_login;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter adapter;
    private ArrayList<Fragment> FragmentArrayList_for_compony;
    private User_login Tab2566;
    private User_Signup Tab002597;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tab2566 = new User_login();
        Tab002597 = new User_Signup();


        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_to_u);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_to_u);
        FragmentArrayList_for_compony = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_for_compony.add(Tab2566);
        FragmentArrayList_for_compony.add(Tab002597);


        mTabLayout.addTab(mTabLayout.newTab().setText("User_Login"));
        mTabLayout.addTab(mTabLayout.newTab().setText("User_Signup"));

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
                        new User_login();
                        break;
                    case 1:
                        new User_Signup();
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
