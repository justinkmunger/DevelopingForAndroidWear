package com.justintomobile.developingforandroidwear.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.justintomobile.developingforandroidwear.R;

/**
 * Created by justinmunger on 7/6/14.
 */
public class VoiceInputFragment extends Fragment {
    private static final String ARGS_VOICE_INPUT_TEXT = "voice_input_text";

    private TextView mVoiceInputTextView;

    private VoiceInputFragment() {
    }

    public static VoiceInputFragment newInstance(String voiceInputText) {

        VoiceInputFragment fragment = new VoiceInputFragment();

        Bundle args = new Bundle();
        args.putString(ARGS_VOICE_INPUT_TEXT, voiceInputText);

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_voiceinput, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mVoiceInputTextView =
                (TextView) view.findViewById(R.id.voiceinput_text);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String voiceInputText =
                getArguments().getString(ARGS_VOICE_INPUT_TEXT);

        if (!TextUtils.isEmpty(voiceInputText)) {
            mVoiceInputTextView.setText(voiceInputText);
        } else {
            mVoiceInputTextView.setText("No voice input received.");
        }
    }
}