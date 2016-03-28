package com.randomappsinc.sturf.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ProfileActivity extends StandardActivity {
    @Bind(R.id.profile_image) ImageView profilePic;
    @Bind(R.id.user_name) TextView userName;
    @Bind(R.id.school) TextView school;
    @Bind(R.id.post_item) FloatingActionButton postItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(this)
                .load("http://i.imgur.com/nYIEqa2.png")
                .into(profilePic);

        userName.setText("Alex Chiou");
        school.setText("UCLA");

        postItem.setImageDrawable(new IconDrawable(this, IoniconsIcons.ion_android_add).colorRes(R.color.white));
    }

    @OnClick(R.id.post_item)
    public void postItem() {
        Intent postItemIntent = new Intent(this, ItemFormActivity.class);
        postItemIntent.putExtra(ItemFormActivity.FORM_MODE_KEY, ItemFormActivity.ADD);
        startActivity(postItemIntent);
    }
}
