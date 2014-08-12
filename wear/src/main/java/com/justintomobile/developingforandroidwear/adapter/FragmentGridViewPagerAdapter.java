package com.justintomobile.developingforandroidwear.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;

import com.justintomobile.developingforandroidwear.R;

public class FragmentGridViewPagerAdapter extends FragmentGridPagerAdapter {

    private static final int[] BACKGROUND_IMAGES = new int[] {
            R.drawable.desert,
            R.drawable.ocean,
            R.drawable.beach,
            R.drawable.field,
            R.drawable.mountain
    };

    public FragmentGridViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getFragment(int row, int column) {
        return CardFragment.create("Row " + row, "Column " + column, R.drawable.ic_launcher);
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount(int row) {
        return 7;
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        return ImageReference.forDrawable(BACKGROUND_IMAGES[row]);
    }
}
