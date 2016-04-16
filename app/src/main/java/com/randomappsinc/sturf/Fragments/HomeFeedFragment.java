package com.randomappsinc.sturf.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randomappsinc.sturf.R;

import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 4/15/16.
 */
public class HomeFeedFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_feed, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
