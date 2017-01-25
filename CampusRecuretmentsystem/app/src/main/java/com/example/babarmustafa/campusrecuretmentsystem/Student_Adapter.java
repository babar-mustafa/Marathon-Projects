package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/25/2017.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class Student_Adapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> FragmentArrayList;
    private Context mContext;

    public Student_Adapter(FragmentManager fm, ArrayList<Fragment> FragmentArrayList) {
        super(fm);
        this.FragmentArrayList = FragmentArrayList;

    }

    @Override
    public Fragment getItem(int position) {
        return FragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentArrayList.size();
    }
}
