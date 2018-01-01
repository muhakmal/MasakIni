package com.baskom.masakini.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baskom.masakini.fragment.ResepTabFragment;
import com.baskom.masakini.fragment.VideoTabFragment;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ResepTabFragment();
        } else return new VideoTabFragment();
    }


    @Override
    public int getCount() {
        return 2;
    }
}
