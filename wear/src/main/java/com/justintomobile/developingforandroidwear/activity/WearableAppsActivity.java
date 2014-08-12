package com.justintomobile.developingforandroidwear.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.activity.wearableapps.BoxInsetLayoutActivity;
import com.justintomobile.developingforandroidwear.activity.wearableapps.ConfirmationTestActivity;
import com.justintomobile.developingforandroidwear.activity.wearableapps.DismissOverlayViewActivity;
import com.justintomobile.developingforandroidwear.activity.wearableapps.FragmentGridViewPagerActivity;
import com.justintomobile.developingforandroidwear.activity.wearableapps.GridViewPagerActivity;
import com.justintomobile.developingforandroidwear.activity.wearableapps.MyInsetActivity;
import com.justintomobile.developingforandroidwear.activity.wearableapps.WearViewStubActivity;
import com.justintomobile.developingforandroidwear.adapter.WearableAppsListAdapter;
import com.justintomobile.developingforandroidwear.enums.WearableAppsType;

public class WearableAppsActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView mWearableListView;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_wearableapps);
        mWearableListView = (WearableListView)findViewById(R.id.list);
        mWearableListView.setAdapter(new WearableAppsListAdapter(this));
        mWearableListView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Intent intent = null;

        WearableAppsType wearableAppsType =
                (WearableAppsType)viewHolder.itemView.getTag();

        switch (wearableAppsType) {
            case GRIDVIEWPAGER:
                intent = new Intent(this, GridViewPagerActivity.class);
                break;
            case FRAGMENTGRIDVIEWPAGER:
                intent = new Intent(this, FragmentGridViewPagerActivity.class);
                break;
            case DISMISSOVERLAYVIEW:
                intent = new Intent(this, DismissOverlayViewActivity.class);
                break;
            case CONFIRMATIONACTIVITY:
                intent = new Intent(this, ConfirmationTestActivity.class);
                break;
            case WEARVIEWSTUB:
                intent = new Intent(this, WearViewStubActivity.class);
                break;
            case BOXINSETLAYOUT:
                intent = new Intent(this, BoxInsetLayoutActivity.class);
                break;
            case INSETACTIVITY:
                intent = new Intent(this, MyInsetActivity.class);
                break;
        }

        startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {}
}
