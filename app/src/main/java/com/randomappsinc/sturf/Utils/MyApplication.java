package com.randomappsinc.sturf.Utils;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.randomappsinc.sturf.Models.UserInfo;
import com.randomappsinc.sturf.Persistence.PreferencesManager;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public final class MyApplication extends Application {
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new IoniconsModule());
        instance = getApplicationContext();

        UserInfo userInfo = new UserInfo();
        userInfo.setName("Alex Chiou");
        userInfo.setEmail("chessnone@yahoo.com");
        userInfo.setProfilePictureUrl("http://i.imgur.com/nYIEqa2.png");
        userInfo.setSchool("UCLA");

        PreferencesManager.get().setUserInfo(userInfo);
    }

    public static Context getAppContext() {
        return instance;
    }
}
