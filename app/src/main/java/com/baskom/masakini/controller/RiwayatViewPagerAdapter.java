package com.baskom.masakini.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RiwayatViewPagerAdapter extends FragmentPagerAdapter {

    public RiwayatViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position ==0){
            return new DalamProsesFragment();
        }else return new OrderSelesaiFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
