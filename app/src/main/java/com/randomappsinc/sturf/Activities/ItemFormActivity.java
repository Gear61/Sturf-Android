package com.randomappsinc.sturf.Activities;

import android.os.Bundle;

import com.randomappsinc.sturf.R;

import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ItemFormActivity extends StandardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
