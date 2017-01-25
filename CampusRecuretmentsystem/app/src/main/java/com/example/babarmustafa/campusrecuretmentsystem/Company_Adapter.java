package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/25/2017.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class Company_Adapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> FragmentArrayList_c;
    private Context mContext;

    public Company_Adapter(FragmentManager fm, ArrayList<Fragment> FragmentArrayList_c) {
        super(fm);
        this.FragmentArrayList_c = FragmentArrayList_c;

    }

    @Override
    public Fragment getItem(int position) {
        return FragmentArrayList_c.get(position);
    }

    @Override
    public int getCount() {
        return FragmentArrayList_c.size();
    }
}

//public class Company_Adapter {
//}
