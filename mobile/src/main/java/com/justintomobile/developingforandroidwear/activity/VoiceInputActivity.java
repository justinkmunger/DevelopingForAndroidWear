package com.justintomobile.developingforandroidwear.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.fragment.VoiceInputFragment;

/**
 * Created by justinmunger on 7/6/14.
 */
public class VoiceInputActivity extends Activity {
    public static final String EXTRA_VOICE_REPLY = "extra_voice_reply";
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";

    private VoiceInputFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiceinput);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null &&
                    extras.containsKey(EXTRA_NOTIFICATION_ID)) {
                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(this);

                notificationManager.cancel(extras.getInt(EXTRA_NOTIFICATION_ID));
            }
            mFragment = VoiceInputFragment.newInstance(getVoiceInputText());

            getFragmentManager().beginTransaction()
                    .add(R.id.container, mFragment)
                    .commit();
        } else {
            mFragment =
                    (VoiceInputFragment) getFragmentManager().findFragmentById(R.id.container);
        }
    }

    private String getVoiceInputText() {
        Bundle remoteInput =
                RemoteInput.getResultsFromIntent(getIntent());

        if (remoteInput != null) {
            return remoteInput.getCharSequence(EXTRA_VOICE_REPLY).toString();
        } else {
            return null;
        }
    }
}
