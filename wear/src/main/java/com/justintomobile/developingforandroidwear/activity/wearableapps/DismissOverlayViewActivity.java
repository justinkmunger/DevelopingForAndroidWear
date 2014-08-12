package com.justintomobile.developingforandroidwear.activity.wearableapps;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DismissOverlayView;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.justintomobile.developingforandroidwear.R;

public class DismissOverlayViewActivity extends Activity {

    private DismissOverlayView mDismissOverlayView;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismissoverlayview);

        mDismissOverlayView =
                (DismissOverlayView)findViewById(R.id.dismissoverlayview_dismiss);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                mDismissOverlayView.show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
}
