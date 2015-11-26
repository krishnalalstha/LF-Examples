package com.lf.example;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Braindigit on 8/26/15.
 */
public class ViewPagerActivity extends AppCompatActivity {

    ViewPager myviewpager;
   // TabLayout mTabLayout;
    ArrayList<String> mInfoList = new ArrayList<String>() {

        {
            add("Man City");
            add("Man United");
            add("Arsenal");
            add("Liverpool");
            add("Chelsea");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        myviewpager = (ViewPager) findViewById(R.id.myviewpager);
        ViewpagerListAdapter mViewpagerListAdapter = new ViewpagerListAdapter(getSupportFragmentManager(), mInfoList);
        myviewpager.setAdapter(mViewpagerListAdapter);
       // mTabLayout.setTabsFromPagerAdapter(mViewpagerListAdapter);

    }
}
