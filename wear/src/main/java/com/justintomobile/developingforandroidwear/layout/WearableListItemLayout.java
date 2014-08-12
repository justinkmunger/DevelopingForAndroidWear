package com.justintomobile.developingforandroidwear.layout;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.justintomobile.developingforandroidwear.R;

public class WearableListItemLayout extends LinearLayout
                                implements WearableListView.Item {

    private ImageView mCircle;
    private TextView mText;

    private final int mFadedCircleColor;
    private final int mChosenCircleColor;

    private float mScale;

    public WearableListItemLayout(Context context) {
        this(context, null);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mFadedCircleColor = getResources().getColor(R.color.wearablelistitem_graycircle);
        mChosenCircleColor = getResources().getColor(R.color.wearablelistitem_bluecircle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mCircle = (ImageView) findViewById(R.id.wearablelistrow_circle);
        mText = (TextView) findViewById(R.id.wearablelistrow_text);
    }

    @Override
    public float getProximityMinValue() {
        return 1f;
    }

    @Override
    public float getProximityMaxValue() {
        return 1.6f;
    }

    @Override
    public float getCurrentProximityValue() {
        return mScale;
    }

    @Override
    public void setScalingAnimatorValue(float scale) {
        mScale = scale;
        mCircle.setScaleX(scale);
        mCircle.setScaleY(scale);
    }

    @Override
    public void onScaleUpStart() {
        mText.setAlpha(1.0f);
        ((GradientDrawable) mCircle.getDrawable()).setColor(mChosenCircleColor);
    }

    @Override
    public void onScaleDownStart() {
        ((GradientDrawable) mCircle.getDrawable()).setColor(mFadedCircleColor);
        mText.setAlpha(0.4f);
    }
}
