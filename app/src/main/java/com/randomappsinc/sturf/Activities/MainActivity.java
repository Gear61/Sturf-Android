package com.randomappsinc.sturf.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.ButterKnife;

public class MainActivity extends StandardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        UIUtils.loadMenuIcon(menu, R.id.post_item, FontAwesomeIcons.fa_plus);
        UIUtils.loadMenuIcon(menu, R.id.view_profile, FontAwesomeIcons.fa_user);
        UIUtils.loadMenuIcon(menu, R.id.settings, FontAwesomeIcons.fa_gear);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.post_item:
                Intent openItemForm = new Intent(this, ItemFormActivity.class);
                openItemForm.putExtra(ItemFormActivity.FORM_MODE_KEY, ItemFormActivity.ADD);
                startActivity(openItemForm);
                return true;
            case R.id.view_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            case R.id.settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
