package com.randomappsinc.sturf.Activities;

import android.os.Bundle;

import com.randomappsinc.sturf.R;

import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 4/15/16.
 */
public class SearchActivity extends StandardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
