package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/25/2017.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class TabsAdapter_For_compony extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> FragmentArrayList_for_compony;
    private Context mContext;

    public TabsAdapter_For_compony(FragmentManager fm, ArrayList<Fragment> FragmentArrayList_for_compony) {
        super(fm);
        this.FragmentArrayList_for_compony = FragmentArrayList_for_compony;

    }

    @Override
    public Fragment getItem(int position) {
        return FragmentArrayList_for_compony.get(position);
    }

    @Override
    public int getCount() {
        return FragmentArrayList_for_compony.size();
    }
}

