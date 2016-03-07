package com.randomappsinc.sturf.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends StandardActivity {
    @Bind(R.id.search_input) EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.clear_search)
    public void clearSearch() {
        searchInput.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        UIUtils.loadMenuIcon(menu, R.id.post_item, IoniconsIcons.ion_android_add);
        UIUtils.loadMenuIcon(menu, R.id.view_profile, IoniconsIcons.ion_person);
        UIUtils.loadMenuIcon(menu, R.id.settings, IoniconsIcons.ion_android_settings);
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
