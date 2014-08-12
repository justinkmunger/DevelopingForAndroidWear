package com.justintomobile.developingforandroidwear.activity.wearableapps;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;

import com.justintomobile.developingforandroidwear.R;

public class BoxInsetLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxinsetlayout);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
            }
        });
    }
}
