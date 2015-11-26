package com.lf.example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lf.example.fragment.ViewFragment;

import java.util.ArrayList;

public class ViewpagerListAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> infoList;

    public ViewpagerListAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        this.infoList = list;
    }

    @Override
    public Fragment getItem(int position) {
        String params = infoList.get(position);
        return ViewFragment.newInstance(params);
    }

    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return infoList.get(position);
    }
}
