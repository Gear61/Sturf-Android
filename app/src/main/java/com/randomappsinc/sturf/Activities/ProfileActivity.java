package com.randomappsinc.sturf.Activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.randomappsinc.sturf.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ProfileActivity extends StandardActivity {
    @Bind(R.id.profile_image) ImageView profilePic;
    @Bind(R.id.user_name) TextView userName;
    @Bind(R.id.school) TextView school;

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
    }
}
