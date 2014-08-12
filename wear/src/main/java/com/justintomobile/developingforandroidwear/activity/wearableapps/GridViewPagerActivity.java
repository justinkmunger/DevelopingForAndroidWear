package com.justintomobile.developingforandroidwear.activity.wearableapps;

import android.os.Bundle;
import android.support.wearable.activity.InsetActivity;
import android.support.wearable.view.GridViewPager;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.adapter.GridViewPagerAdapter;

public class GridViewPagerActivity extends InsetActivity {
    private GridViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onReadyForContent() {
        setContentView(R.layout.activity_fragmentgridviewpager);
        mPager = (GridViewPager) findViewById(R.id.fragmentgridviewpager_pager);
        mPager.setAdapter(new GridViewPagerAdapter(getApplicationContext()));
    }
}
