package com.justintomobile.developingforandroidwear.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;

import com.justintomobile.developingforandroidwear.activity.notifications.DisplayIntentActivity;
import com.justintomobile.developingforandroidwear.adapter.NotificationsListAdapter;
import com.justintomobile.developingforandroidwear.enums.NotificationType;
import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.activity.notifications.FullScreenContentActivity;
import com.justintomobile.developingforandroidwear.activity.notifications.LargeContentActivity;
import com.justintomobile.developingforandroidwear.activity.notifications.MediumContentActivity;
import com.justintomobile.developingforandroidwear.activity.notifications.SmallContentActivity;
import com.justintomobile.developingforandroidwear.activity.notifications.XSmallContentActivity;

public class NotificationsActivity extends Activity
                                   implements WearableListView.ClickListener {

    private WearableListView mWearableListView;

    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        mNotificationManager =
                (NotificationManager)getSystemService(Activity.NOTIFICATION_SERVICE);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mWearableListView = (WearableListView) stub.findViewById(R.id.list);
                mWearableListView.setAdapter(new NotificationsListAdapter(NotificationsActivity.this));
                mWearableListView.setClickListener(NotificationsActivity.this);
            }
        });
    }

    @Override
    public void onTopEmptyRegionClick() {}

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        NotificationType notificationType =
                (NotificationType)viewHolder.itemView.getTag();

        Notification.Builder notificationBuilder = null;

        switch (notificationType) {
            case BASIC:
                notificationBuilder = generateBasicNotification();
                break;
            case CONTENT_ACTION:
                notificationBuilder = generateContentActionNotification();
                break;
            case DISPLAY_INTENT:
                notificationBuilder = generateDisplayIntentNotification();
                break;
            case CUSTOM_SIZE:
                notificationBuilder = generateCustomSizeNotification();
                break;
        }

        if (notificationBuilder != null) {
            mNotificationManager.notify(0, notificationBuilder.build());
            finish();
        }
    }

    private Notification.Builder generateBasicNotification() {
        return new Notification.Builder(this)
                .setContentTitle("Notification Title")
                .setContentText("Notification Text")
                .setSmallIcon(R.drawable.ic_launcher);
    }

    private Notification.Builder generateContentActionNotification() {
        Intent intent = new Intent(this, NotificationsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        return new Notification.Builder(this)
                .setContentTitle("Notification Title")
                .setContentText("Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                                .addAction(
                                        new Notification.Action(
                                                R.drawable.ic_launcher,
                                                "Return",
                                                pendingIntent))
                                .setContentAction(0)
                );
    }

    private Notification.Builder generateDisplayIntentNotification() {
        Intent intent = new Intent(this, DisplayIntentActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        return new Notification.Builder(this)
                .setContentTitle("Notification Title")
                .setContentText("Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                                .setDisplayIntent(pendingIntent)
                );
    }

    private Notification.Builder generateCustomSizeNotification() {

        Intent smallIntent = new Intent(this, SmallContentActivity.class);
        PendingIntent smallPendingIntent = PendingIntent.getActivity(this, 0, smallIntent, 0);

        Notification smallNotification = new Notification.Builder(this)
                .setContentTitle("Small Notification Title")
                .setContentText("Small Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                        .setDisplayIntent(smallPendingIntent)
                        .setCustomSizePreset(Notification.WearableExtender.SIZE_SMALL))
                .build();


        Intent mediumIntent = new Intent(this, MediumContentActivity.class);
        PendingIntent mediumPendingIntent = PendingIntent.getActivity(this, 0, mediumIntent, 0);

        Notification mediumNotification = new Notification.Builder(this)
                .setContentTitle("Medium Notification Title")
                .setContentText("Medium Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                        .setDisplayIntent(mediumPendingIntent)
                        .setCustomSizePreset(Notification.WearableExtender.SIZE_MEDIUM))
                .build();


        Intent largeIntent = new Intent(this, LargeContentActivity.class);
        PendingIntent largePendingIntent = PendingIntent.getActivity(this, 0, largeIntent, 0);

        Notification largeNotification = new Notification.Builder(this)
                .setContentTitle("Large Notification Title")
                .setContentText("Large Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                        .setDisplayIntent(largePendingIntent)
                        .setCustomSizePreset(Notification.WearableExtender.SIZE_LARGE))
                .build();


        Intent fullScreenIntent = new Intent(this, FullScreenContentActivity.class);
        PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(this, 0, fullScreenIntent, 0);

        Notification fullScreenNotification = new Notification.Builder(this)
                .setContentTitle("Full-Screen Notification Title")
                .setContentText("Full-Screen Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                        .setDisplayIntent(fullScreenPendingIntent)
                        .setCustomSizePreset(Notification.WearableExtender.SIZE_FULL_SCREEN))
                .build();

        Intent extraSmallScreenIntent = new Intent(this, XSmallContentActivity.class);
        PendingIntent extraSmallScreenPendingIntent = PendingIntent.getActivity(this, 0, extraSmallScreenIntent, 0);

        return new Notification.Builder(this)
                .setContentTitle("Extra-Small Notification Title")
                .setContentText("Extra-Small Notification Text")
                .setSmallIcon(R.drawable.ic_launcher)
                .extend(new Notification.WearableExtender()
                                .setDisplayIntent(extraSmallScreenPendingIntent)
                                .setCustomSizePreset(Notification.WearableExtender.SIZE_XSMALL)
                                .addPage(smallNotification)
                                .addPage(mediumNotification)
                                .addPage(largeNotification)
                                .addPage(fullScreenNotification)
                );
    }
}
