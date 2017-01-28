package com.example.babarmustafa.parkingsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.babarmustafa.parkingsystem.Adapters.TabAdapter;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.Parking_Place_one;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.Parking_Place_three;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.Parking_Place_two;
import com.example.babarmustafa.parkingsystem.Fragemnts_for_user.Usser_Booked;

import java.util.ArrayList;

public class Welcome_for_User extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter adapter;
    private ArrayList<Fragment> FragmentArrayList_for_compony;
    private Parking_Place_one one;
    private Parking_Place_two two;
    private Parking_Place_three thre;
    private Usser_Booked th;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_for__user);
        one = new Parking_Place_one();
        two = new Parking_Place_two();
        thre = new Parking_Place_three();
        th = new Usser_Booked();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_to_user);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_to_user);
        FragmentArrayList_for_compony = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        FragmentArrayList_for_compony.add(one);
        FragmentArrayList_for_compony.add(two);
        FragmentArrayList_for_compony.add(thre);
        FragmentArrayList_for_compony.add(th);




        mTabLayout.addTab(mTabLayout.newTab().setText("PLaces One"));
        mTabLayout.addTab(mTabLayout.newTab().setText("user_to_model Two"));
        mTabLayout.addTab(mTabLayout.newTab().setText("user_to_model Three"));
        mTabLayout.addTab(mTabLayout.newTab().setText("user_to_model REserved"));


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
                        new Parking_Place_one();
                        break;
                    case 1:
                        new Parking_Place_two();
                        break;
                    case 2:
                        new Parking_Place_three();
                        break;
                    case 3:
                        new Usser_Booked();
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
