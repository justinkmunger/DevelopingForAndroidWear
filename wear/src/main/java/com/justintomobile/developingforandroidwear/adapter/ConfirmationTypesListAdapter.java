package com.justintomobile.developingforandroidwear.adapter;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.enums.ConfirmationType;
import com.justintomobile.developingforandroidwear.enums.NotificationType;

public class ConfirmationTypesListAdapter extends WearableListView.Adapter {
    private static final int SUCCESS_ANIMATION_ROW = 0;
    private static final int OPEN_ON_ANIMATION_ROW = 1;
    private static final int FAILURE_ANIMATION_ROW = 2;

    private final Context mContext;
    private final LayoutInflater mInflater;

    public ConfirmationTypesListAdapter(Context context) {
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
            case SUCCESS_ANIMATION_ROW:
                textView.setText("Success Animation");
                viewHolder.itemView.setTag(ConfirmationType.SUCCESS_ANIMATION);
                break;
            case OPEN_ON_ANIMATION_ROW:
                textView.setText("Open On Animation");
                viewHolder.itemView.setTag(ConfirmationType.OPEN_ON_ANIMATION);
                break;
            case FAILURE_ANIMATION_ROW:
                textView.setText("Failure Animation");
                viewHolder.itemView.setTag(ConfirmationType.FAILURE_ANIMATION);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
