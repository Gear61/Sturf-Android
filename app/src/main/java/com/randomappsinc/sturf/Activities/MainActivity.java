package com.randomappsinc.sturf.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.Fragments.HomeFeedFragment;
import com.randomappsinc.sturf.Fragments.NavigationDrawerFragment;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    @Bind(R.id.add_item) FloatingActionButton addItem;
    @Bind(R.id.drawer_layout) DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addItem.setImageDrawable(new IconDrawable(this, IoniconsIcons.ion_android_add)
                .colorRes(R.color.white)
                .actionBarSize());

        NavigationDrawerFragment mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, drawer);

        FragmentManager fragmentManager = getFragmentManager();
        HomeFeedFragment homeFeedFragment = new HomeFeedFragment();
        fragmentManager.beginTransaction().replace(R.id.container, homeFeedFragment).commit();
    }

    @OnClick(R.id.add_item)
    public void postItem() {
        drawer.closeDrawers();
        Intent intent = new Intent(this, ItemFormActivity.class);
        intent.putExtra(ItemFormActivity.FORM_MODE_KEY, ItemFormActivity.ADD);
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, ProfileActivity.class);
                break;
            case 1:
                intent = new Intent(this, MySturfActivity.class);
                break;
            case 2:
                intent = new Intent(this, SettingsActivity.class);
        }
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        UIUtils.loadMenuIcon(menu, R.id.search, IoniconsIcons.ion_android_search);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
            drawer.closeDrawers();
            startActivity(new Intent(this, SearchActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
