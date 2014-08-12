package com.justintomobile.developingforandroidwear.adapter;

import android.content.Context;
import android.support.wearable.view.GridPagerAdapter;
import android.support.wearable.view.ImageReference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.justintomobile.developingforandroidwear.R;

public class GridViewPagerAdapter extends GridPagerAdapter {

    private static final int[] BACKGROUND_IMAGES = new int[] {
            R.drawable.desert,
            R.drawable.ocean,
            R.drawable.beach,
            R.drawable.field,
            R.drawable.mountain
    };

    private Context mContext;

    public GridViewPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        return ImageReference.forDrawable(BACKGROUND_IMAGES[row]);
    }

    @Override
    protected Object instantiateItem(ViewGroup viewGroup, int row, int column) {
        View gridViewPage = View.inflate(mContext, R.layout.layout_gridviewpagerrow, null);

        TextView text =
                (TextView)gridViewPage.findViewById(R.id.gridviewpagerrow_text);

        text.setText("Row " + row + ", Column " + column);

        viewGroup.addView(gridViewPage);

        return gridViewPage;
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
    protected void destroyItem(ViewGroup viewGroup, int row, int column, Object view) {
        viewGroup.removeView((View)view);
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view.equals(o);
    }
}
