package com.justintomobile.developingforandroidwear.fragment;

import android.app.Fragment;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.activity.ContentIntentActivity;
import com.justintomobile.developingforandroidwear.activity.VoiceInputActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class NotificationFragment extends Fragment {

    public static final int ID_BARE_BONES_NOTIFICATION = 1;
    public static final int ID_BASIC_NOTIFICATION = 2;
    public static final int ID_NOTIFICATION_WITH_LARGE_ICON = 3;
    public static final int ID_NOTIFICATION_WITH_BIG_TEXT_STYLE = 4;
    public static final int ID_NOTIFICATION_WITH_CONTENT_INTENT = 5;
    public static final int ID_NOTIFICATION_WITH_ACTION_BUTTON = 6;
    public static final int ID_NOTIFICATION_WITH_ACTION_BUTTON_AND_CONTENT_INTENT = 7;
    public static final int ID_NOTIFICATION_WEARABLE_ONLY_ACTION_BUTTON = 8;
    public static final int ID_NOTIFICATION_WEARABLE_SETTING = 9;
    public static final int ID_NOTIFICATION_VOICE_REPLY_ACTION = 10;
    public static final int ID_NOTIFICATION_WITH_MULTIPLE_PAGES = 11;
    public static final int ID_STACKED_NOTIFICATIONS = 20;
    public static final int ID_STACKED_NOTIFICATIONS_WITH_SUMMARY = 30;

    private static final String STACKED_NOTIFICATION_GROUP = "stacked_notification_group";
    private static final String MEETUP_URL = "http://www.meetup.com/GDGChicago";

    private ListView mOptionsListView;

    private int mNotificationId;

    public NotificationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mOptionsListView =
                (ListView) getActivity().findViewById(R.id.notification_options);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(getActivity());

        mOptionsListView.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.notification_options)
        ));
        mOptionsListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mNotificationId = ID_BARE_BONES_NOTIFICATION;
                        notificationManager.notify(mNotificationId, buildBareBonesNotification());
                        break;
                    case 1:
                        mNotificationId = ID_BASIC_NOTIFICATION;
                        notificationManager.notify(mNotificationId, buildBasicNotification());
                        break;
                    case 2:
                        mNotificationId = ID_NOTIFICATION_WITH_LARGE_ICON;
                        notificationManager.notify(mNotificationId, buildNotificationWithLargeIcon());
                        break;
                    case 3:
                        mNotificationId = ID_NOTIFICATION_WITH_BIG_TEXT_STYLE;
                        notificationManager.notify(mNotificationId, buildNotificationWithBigTextStyle());
                        break;
                    case 4:
                        mNotificationId = ID_NOTIFICATION_WITH_CONTENT_INTENT;
                        notificationManager.notify(mNotificationId, buildNotificationWithContentIntent());
                        break;
                    case 5:
                        mNotificationId = ID_NOTIFICATION_WITH_ACTION_BUTTON;
                        notificationManager.notify(mNotificationId, buildNotificationWithActionButton());
                        break;
                    case 6:
                        mNotificationId = ID_NOTIFICATION_WITH_ACTION_BUTTON_AND_CONTENT_INTENT;
                        notificationManager.notify(mNotificationId, buildNotificationWithActionButtonAndContentIntent());
                        break;
                    case 7:
                        mNotificationId = ID_NOTIFICATION_WEARABLE_ONLY_ACTION_BUTTON;
                        notificationManager.notify(mNotificationId, buildNotificationWearableOnlyActionButton());
                        break;
                    case 8:
                        mNotificationId = ID_NOTIFICATION_WEARABLE_SETTING;
                        notificationManager.notify(mNotificationId, buildNotificationWearableSetting());
                        break;
                    case 9:
                        mNotificationId = ID_NOTIFICATION_VOICE_REPLY_ACTION;
                        notificationManager.notify(mNotificationId, buildNotificationVoiceReplyAction());
                        break;
                    case 10:
                        mNotificationId = ID_NOTIFICATION_WITH_MULTIPLE_PAGES;
                        notificationManager.notify(mNotificationId, buildNotificationWithMultiplePages());
                        break;
                    case 11:
                        mNotificationId = ID_STACKED_NOTIFICATIONS;
                        notificationManager.notify(mNotificationId, buildFirstStackedNotification());
                        notificationManager.notify(mNotificationId + 1, buildSecondStackedNotification());
                        notificationManager.notify(mNotificationId + 2, buildThirdStackedNotification());
                        break;
                    case 12:
                        mNotificationId = ID_STACKED_NOTIFICATIONS_WITH_SUMMARY;
                        notificationManager.notify(mNotificationId, buildFirstStackedNotification());
                        notificationManager.notify(mNotificationId + 1, buildSecondStackedNotification());
                        notificationManager.notify(mNotificationId + 2, buildThirdStackedNotification());
                        notificationManager.notify(mNotificationId + 3, buildStackSummaryNotification());
                    default:
                        break;
                }
            }
        });
    }

    private Notification buildBareBonesNotification() {
        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .build();

        return notification;
    }

    private Notification buildBasicNotification() {
        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .build();

        return notification;
    }

    private Notification buildNotificationWithLargeIcon() {
        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .build();

        return notification;
    }

    private Notification buildNotificationWithBigTextStyle() {

        NotificationCompat.BigTextStyle bigTextStyle =
                new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(getString(R.string.long_string));

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setStyle(bigTextStyle)
                        .build();

        return notification;
    }


    private Notification buildNotificationWithContentIntent() {
        Intent intent = new Intent(getActivity(), ContentIntentActivity.class);
        PendingIntent contentIntent =
                PendingIntent.getActivity(getActivity(),
                        0,
                        intent,
                        0);

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .setContentIntent(contentIntent)
                        .build();

        notification.flags = Notification.FLAG_AUTO_CANCEL;

        return notification;
    }

    private Notification buildNotificationWithActionButton() {
        Intent meetupIntent = new Intent(Intent.ACTION_VIEW);
        meetupIntent.setData(Uri.parse(MEETUP_URL));
        PendingIntent meetupPendingIntent =
                PendingIntent.getActivity(getActivity(), 0, meetupIntent, 0);

        NotificationCompat.Action action =
                new NotificationCompat.Action(
                        R.drawable.ic_goto_meetup,
                        getString(R.string.notification_action_button_title_meetup),
                        meetupPendingIntent);

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .addAction(action)
                        .build();

        return notification;
    }

    private Notification buildNotificationWithActionButtonAndContentIntent() {
        Intent meetupIntent = new Intent(Intent.ACTION_VIEW);
        meetupIntent.setData(Uri.parse(MEETUP_URL));
        PendingIntent meetupPendingIntent =
                PendingIntent.getActivity(getActivity(), 0, meetupIntent, 0);

        Intent intent = new Intent(getActivity(), ContentIntentActivity.class);
        PendingIntent contentIntent =
                PendingIntent.getActivity(getActivity(),
                        0,
                        intent,
                        0);

        NotificationCompat.Action action =
                new NotificationCompat.Action(
                        R.drawable.ic_goto_meetup,
                        getString(R.string.notification_action_button_title_meetup),
                        meetupPendingIntent);

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .setContentIntent(contentIntent)
                        .addAction(action)
                        .build();

        notification.flags = Notification.FLAG_AUTO_CANCEL;

        return notification;
    }

    private Notification buildNotificationWearableOnlyActionButton() {
        Intent meetupIntent = new Intent(Intent.ACTION_VIEW);
        meetupIntent.setData(Uri.parse(MEETUP_URL));
        PendingIntent meetupPendingIntent =
                PendingIntent.getActivity(getActivity(), 0, meetupIntent, 0);

        NotificationCompat.Action action =
                new NotificationCompat.Action(
                        R.drawable.ic_goto_meetup,
                        getString(R.string.notification_action_button_title_meetup),
                        meetupPendingIntent);

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender();
        wearableExtender.addAction(action);

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .extend(wearableExtender)
                        .build();

        return notification;
    }

    private Notification buildNotificationWearableSetting() {
        NotificationCompat.WearableExtender extender =
                new NotificationCompat.WearableExtender().setHintHideIcon(true);

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .extend(extender)
                        .build();

        return notification;
    }

    private Notification buildNotificationVoiceReplyAction() {
        Intent voiceInputIntent = new Intent(getActivity(), VoiceInputActivity.class);
        voiceInputIntent.putExtra(VoiceInputActivity.EXTRA_NOTIFICATION_ID, ID_NOTIFICATION_VOICE_REPLY_ACTION);
        PendingIntent voiceInputPendingIntent =
                PendingIntent.getActivity(
                        getActivity(),
                        0,
                        voiceInputIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

        String replyLabel = getString(R.string.voice_input);
        RemoteInput remoteInput = new RemoteInput.Builder(VoiceInputActivity.EXTRA_VOICE_REPLY)
                .setLabel(replyLabel)
                .build();

        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(
                        R.drawable.ic_voice_input,
                        getString(R.string.voice_input),
                        voiceInputPendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_content_text))
                        .extend(new NotificationCompat.WearableExtender().addAction(action))
                        .build();

        return notification;
    }

    private Notification buildNotificationWithMultiplePages() {
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_page))
                        .setContentText(getString(R.string.notification_text_first_page));

        Notification secondNotificationPage =
                new NotificationCompat.Builder(getActivity())
                        .setContentTitle(getString(R.string.notification_title_second_page))
                        .setContentText(getString(R.string.notification_text_second_page))
                        .build();

        NotificationCompat.BigTextStyle bigTextStyle =
                new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(getString(R.string.notification_text_third_page));

        Notification thirdNotificationPage =
                new NotificationCompat.Builder(getActivity())
                        .setContentTitle(getString(R.string.notification_title_third_page))
                        .setStyle(bigTextStyle)
                        .build();

        Notification threePageNotification =
                new NotificationCompat.WearableExtender()
                        .addPage(secondNotificationPage)
                        .addPage(thirdNotificationPage)
                        .extend(notificationBuilder)
                        .build();

        return threePageNotification;
    }

    private Notification buildFirstStackedNotification() {
        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_first_notification_in_stack))
                        .setContentText(getString(R.string.notification_text_first_notification_in_stack))
                        .setGroup(STACKED_NOTIFICATION_GROUP)
                        .build();

        return notification;
    }

    private Notification buildSecondStackedNotification() {
        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_second_notification_in_stack))
                        .setContentText(getString(R.string.notification_text_second_notification_in_stack))
                        .setGroup(STACKED_NOTIFICATION_GROUP)
                        .build();

        return notification;
    }

    private Notification buildThirdStackedNotification() {
        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setContentTitle(getString(R.string.notification_title_third_notification_in_stack))
                        .setContentText(getString(R.string.notification_text_third_notification_in_stack))
                        .setGroup(STACKED_NOTIFICATION_GROUP)
                        .build();

        return notification;
    }

    private Notification buildStackSummaryNotification() {

        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        StringBuilder builder = new StringBuilder();

        builder.append(getString(R.string.notification_title_first_notification_in_stack));
        builder.append("   ");
        builder.append(getString(R.string.notification_text_first_notification_in_stack));
        inboxStyle.addLine(builder.toString());

        builder.setLength(0);

        builder.append(getString(R.string.notification_title_second_notification_in_stack));
        builder.append("   ");
        builder.append(getString(R.string.notification_text_second_notification_in_stack));
        inboxStyle.addLine(builder.toString());

        builder.setLength(0);

        builder.append(getString(R.string.notification_title_third_notification_in_stack));
        builder.append("   ");
        builder.append(getString(R.string.notification_text_third_notification_in_stack));
        inboxStyle.addLine(builder.toString());

        inboxStyle.setBigContentTitle(getString(R.string.notification_title_stack_summary_three_notifications));
        inboxStyle.setSummaryText(getString(R.string.notification_text_summary_text));

        Notification notification =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_background))
                        .setStyle(inboxStyle)
                        .setGroup(STACKED_NOTIFICATION_GROUP)
                        .setGroupSummary(true)
                        .build();

        return notification;
    }
}
