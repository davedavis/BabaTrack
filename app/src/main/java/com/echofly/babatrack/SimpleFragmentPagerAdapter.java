package com.echofly.babatrack;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    private String tabTitles[] = new String[]{"Pink Noise", "White Noise", "Brown Noise", "Nature", "Weather"};

    SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
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

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        //return tabTitles[position];
        if (position == 0) {
            return mContext.getString(R.string.category_pink_noise);
        } else if (position == 1) {
            return mContext.getString(R.string.category_white_noise);
        } else if (position == 2) {
            return mContext.getString(R.string.category_brown_noise);
        } else if (position == 3) {
            return mContext.getString(R.string.category_nature);
        } else {
            return mContext.getString(R.string.category_weather);
        }
    }
}


