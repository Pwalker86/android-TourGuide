package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by phil.walker on 2/6/17.
 */

public class SiteFragmentPagerAdapter extends FragmentStatePagerAdapter {
    public SiteFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FoodFragment();
        } else if (position == 1) {
            return new TheatreFragment();
        } else if (position == 2) {
            return new MusicFragment();
        } else {
            return new MiscFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Food";
        } else if (position == 1) {
            return "Theatre";
        } else if (position == 2) {
            return "Music";
        } else {
            return "Misc";
        }
    }
}
