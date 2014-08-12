package com.justintomobile.developingforandroidwear.adapter;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.enums.WearableAppsType;

public class WearableAppsListAdapter extends WearableListView.Adapter {

    private static final int GRIDVIEWPAGER_ROW = 0;
    private static final int FRAGMENTGRIDVIEWPAGER_ROW = 1;
    private static final int DISMISSOVERLAYVIEW_ROW = 2;
    private static final int CONFIRMATIONACTIVITY_ROW = 3;
    private static final int WEARVIEWSTUB_ROW = 4;
    private static final int BOXINSETLAYOUT_ROW = 5;
    private static final int INSETACTIVITY_ROW = 6;

    private final Context mContext;
    private final LayoutInflater mInflater;

    public WearableAppsListAdapter(Context context) {
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
            case GRIDVIEWPAGER_ROW:
                textView.setText("GridViewPager");
                viewHolder.itemView.setTag(WearableAppsType.GRIDVIEWPAGER);
                break;
            case FRAGMENTGRIDVIEWPAGER_ROW:
                textView.setText("FragmentGridViewPager");
                viewHolder.itemView.setTag(WearableAppsType.FRAGMENTGRIDVIEWPAGER);
                break;
            case DISMISSOVERLAYVIEW_ROW:
                textView.setText("DismissOverlayView");
                viewHolder.itemView.setTag(WearableAppsType.DISMISSOVERLAYVIEW);
                break;
            case CONFIRMATIONACTIVITY_ROW:
                textView.setText("ConfirmationActivity");
                viewHolder.itemView.setTag(WearableAppsType.CONFIRMATIONACTIVITY);
                break;
            case WEARVIEWSTUB_ROW:
                textView.setText("WearViewStub");
                viewHolder.itemView.setTag(WearableAppsType.WEARVIEWSTUB);
                break;
            case BOXINSETLAYOUT_ROW:
                textView.setText("BoxInsetLayout");
                viewHolder.itemView.setTag(WearableAppsType.BOXINSETLAYOUT);
                break;
            case INSETACTIVITY_ROW:
                textView.setText("InsetActivity");
                viewHolder.itemView.setTag(WearableAppsType.INSETACTIVITY);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
