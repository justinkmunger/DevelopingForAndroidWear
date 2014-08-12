package com.justintomobile.developingforandroidwear.activity.wearableapps;

import android.content.Intent;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.InsetActivity;
import android.support.wearable.view.WearableListView;

import com.justintomobile.developingforandroidwear.R;
import com.justintomobile.developingforandroidwear.adapter.ConfirmationTypesListAdapter;
import com.justintomobile.developingforandroidwear.enums.ConfirmationType;

public class ConfirmationTestActivity extends InsetActivity
                                      implements WearableListView.ClickListener{

    private WearableListView mWearableListView;

    @Override
    public void onReadyForContent() {
        setContentView(R.layout.activity_confirmationtest);
        mWearableListView = (WearableListView)findViewById(R.id.list);
        mWearableListView.setAdapter(new ConfirmationTypesListAdapter(this));
        mWearableListView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        ConfirmationType confirmationType =
                (ConfirmationType) viewHolder.itemView.getTag();

        Intent confirmationActivityIntent =
                new Intent(this, ConfirmationActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);

        switch (confirmationType) {
            case SUCCESS_ANIMATION:
                confirmationActivityIntent
                        .putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION)
                        .putExtra(ConfirmationActivity.EXTRA_MESSAGE, "Success");
                break;
            case OPEN_ON_ANIMATION:
                confirmationActivityIntent
                        .putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.OPEN_ON_PHONE_ANIMATION)
                        .putExtra(ConfirmationActivity.EXTRA_MESSAGE, "Open on Phone");
                break;
            case FAILURE_ANIMATION:
                confirmationActivityIntent
                        .putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.FAILURE_ANIMATION)
                        .putExtra(ConfirmationActivity.EXTRA_MESSAGE, "Failure");
                break;
        }

        startActivity(confirmationActivityIntent);
    }

    @Override
    public void onTopEmptyRegionClick() {}

}
