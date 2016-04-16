package com.randomappsinc.sturf.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.Models.UserInfo;
import com.randomappsinc.sturf.Persistence.PreferencesManager;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ProfileActivity extends StandardActivity {
    @Bind(R.id.profile_picture) ImageView profilePic;
    @Bind(R.id.name) EditText userName;
    @Bind(R.id.school) EditText school;
    @Bind(R.id.email) EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        UserInfo currentUser = PreferencesManager.get().getCurrentUser();
        Picasso.with(this).load(currentUser.getProfilePictureUrl()).into(profilePic);
        userName.setText(currentUser.getName());
        school.setText(currentUser.getSchool());
        email.setText(currentUser.getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_profile_menu, menu);
        UIUtils.loadMenuIcon(menu, R.id.save_profile, IoniconsIcons.ion_checkmark);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save_profile) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
