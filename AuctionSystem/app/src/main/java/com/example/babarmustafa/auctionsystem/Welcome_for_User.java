package com.example.babarmustafa.auctionsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.babarmustafa.auctionsystem.Adapters.TabsAdapter;
import com.example.babarmustafa.auctionsystem.Fragments.Laptops;
import com.example.babarmustafa.auctionsystem.Fragments.Members;
import com.example.babarmustafa.auctionsystem.Fragments.Mobiles;
import com.example.babarmustafa.auctionsystem.Fragments.User_Signup;

import java.util.ArrayList;

public class Welcome_for_User extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabsAdapter adapter;
    private ArrayList<Fragment> FragmentArrayList_for_compony;
    private Laptops tab1;
    private Mobiles tab2;
    private Members tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_for__user);
        tab1 = new Laptops();
        tab2 = new Mobiles();
        tab3= new Members();


        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_to_u);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_to_u);
        FragmentArrayList_for_compony = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_for_compony.add(tab1);
        FragmentArrayList_for_compony.add(tab2);
        FragmentArrayList_for_compony.add(tab3);


        mTabLayout.addTab(mTabLayout.newTab().setText("Mobiles"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Laptops"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Members"));


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
                        new Laptops();
                        break;
                    case 1:
                        new Mobiles();
                        break;
                    case 2:
                        new Members();
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
