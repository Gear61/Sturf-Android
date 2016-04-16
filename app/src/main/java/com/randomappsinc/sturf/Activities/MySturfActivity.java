package com.randomappsinc.sturf.Activities;

import android.os.Bundle;

import com.randomappsinc.sturf.R;

import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 4/15/16.
 */
public class MySturfActivity extends StandardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_sturf);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
