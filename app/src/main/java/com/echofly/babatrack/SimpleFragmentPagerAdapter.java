package com.echofly.babatrack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PinkNoiseFragment();
        } else if (position == 1) {
            return new WhiteNoiseFragment();
        } else if (position == 2) {
            return new BrownNoiseFragment();
        } else if (position == 3) {
            return new WeatherFragment();
        } else {
            return new NatureFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
