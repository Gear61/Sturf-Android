package com.randomappsinc.sturf.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 4/15/16.
 */
public class SearchActivity extends StandardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        UIUtils.loadMenuIcon(menu, R.id.do_search, IoniconsIcons.ion_checkmark);
        UIUtils.loadMenuIcon(menu, R.id.reset_filters, IoniconsIcons.ion_android_close);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.do_search:
                return true;
            case R.id.reset_filters:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
