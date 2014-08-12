package com.justintomobile.developingforandroidwear.activity.wearableapps;

import android.support.wearable.activity.InsetActivity;

import com.justintomobile.developingforandroidwear.R;

public class MyInsetActivity extends InsetActivity {

    @Override
    public void onReadyForContent() {
        setContentView(R.layout.activity_myinset);
    }
}
