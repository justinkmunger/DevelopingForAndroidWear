package com.justintomobile.developingforandroidwear.activity.wearableapps;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;

import com.justintomobile.developingforandroidwear.R;

public class WearViewStubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearviewstub);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watchviewstub_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
            }
        });
    }
}
