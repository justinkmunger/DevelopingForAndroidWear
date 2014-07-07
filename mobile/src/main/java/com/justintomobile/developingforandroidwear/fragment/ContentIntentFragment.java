package com.justintomobile.developingforandroidwear.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justintomobile.developingforandroidwear.R;

/**
 * Created by justinmunger on 6/28/14.
 */
public class ContentIntentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contentintent, container, false);
    }
}
