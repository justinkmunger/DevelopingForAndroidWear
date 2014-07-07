package com.justintomobile.developingforandroidwear.activity;

import android.app.Activity;
import android.os.Bundle;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.fragment.ContentIntentFragment;

/**
 * Created by justinmunger on 6/28/14.
 */
public class ContentIntentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentintent);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ContentIntentFragment())
                    .commit();
        }
    }
}
