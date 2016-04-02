package com.randomappsinc.sturf.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.randomappsinc.sturf.Adapters.SettingsAdapter;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class SettingsActivity extends StandardActivity {
    public static final String SUPPORT_EMAIL = "chessnone@gmail.com";

    @Bind(R.id.parent) View parent;
    @Bind(R.id.settings_options) ListView settingsOptions;
    @BindString(R.string.feedback_subject) String feedbackSubject;
    @BindString(R.string.send_email) String sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        settingsOptions.setAdapter(new SettingsAdapter(this));
    }

    @OnItemClick(R.id.settings_options)
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                String uriText = "mailto:" + SUPPORT_EMAIL + "?subject=" + Uri.encode(feedbackSubject);
                Uri mailUri = Uri.parse(uriText);
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, mailUri);
                startActivity(Intent.createChooser(sendIntent, sendEmail));
                break;
            case 1:
                Uri uri =  Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                Intent rateIntent = new Intent(Intent.ACTION_VIEW, uri);
                if (!(getPackageManager().queryIntentActivities(rateIntent, 0).size() > 0)) {
                    UIUtils.showSnackbar(parent, getString(R.string.play_store_error));
                    return;
                }
                startActivity(rateIntent);
        }
    }
}
