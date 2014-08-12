package com.justintomobile.developingforandroidwear.adapter;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.justintomobile.developingforandroidwear.enums.NotificationType;
import com.justintomobile.developingforandroidwear.R;

public class NotificationsListAdapter extends WearableListView.Adapter {

    private static final int BASIC_NOTIFICATION_ROW = 0;
    private static final int CONTENT_ACTION_NOTIFICATION_ROW = 1;
    private static final int DISPLAY_INTENT_NOTIFICATION_ROW = 2;
    private static final int CUSTOM_SIZE_NOTIFICATION_ROW = 3;

    private final Context mContext;
    private final LayoutInflater mInflater;

    public NotificationsListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new WearableListView.ViewHolder(
                mInflater.inflate(R.layout.layout_wearablelist_row, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int position) {
        TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.wearablelistrow_text);
        switch (position) {
            case BASIC_NOTIFICATION_ROW:
                textView.setText("Basic");
                viewHolder.itemView.setTag(NotificationType.BASIC);
                break;
            case CONTENT_ACTION_NOTIFICATION_ROW:
                textView.setText("Content action");
                viewHolder.itemView.setTag(NotificationType.CONTENT_ACTION);
                break;
            case DISPLAY_INTENT_NOTIFICATION_ROW:
                textView.setText("Display intent");
                viewHolder.itemView.setTag(NotificationType.DISPLAY_INTENT);
                break;
            case CUSTOM_SIZE_NOTIFICATION_ROW:
                textView.setText("Custom size");
                viewHolder.itemView.setTag(NotificationType.CUSTOM_SIZE);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
