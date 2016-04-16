package com.randomappsinc.sturf.Persistence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.randomappsinc.sturf.Models.UserInfo;
import com.randomappsinc.sturf.Utils.MyApplication;

/**
 * Created by alexanderchiou on 4/1/16.
 */
public class PreferencesManager {
    public static final String HAS_SEEN_ITEM_PAGE = "hasSeenItemPage";

    // User info
    public static final String USER_NAME_KEY = "userName";
    public static final String EMAIL_KEY = "email";
    public static final String SCHOOL_KEY = "school";
    public static final String PROFILE_PICTURE_URL_KEY = "profilePictureUrl";

    private static PreferencesManager instance;
    private SharedPreferences prefs;

    public static PreferencesManager get() {
        if (instance == null) {
            instance = new PreferencesManager();
        }
        return instance;
    }

    private PreferencesManager() {
        prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getAppContext());
    }

    public boolean shouldShowItemDemo() {
        boolean hasSeenItemPage = prefs.getBoolean(HAS_SEEN_ITEM_PAGE, false);
        prefs.edit().putBoolean(HAS_SEEN_ITEM_PAGE, true).apply();
        return !hasSeenItemPage;
    }

    public UserInfo getCurrentUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(prefs.getString(USER_NAME_KEY, ""));
        userInfo.setEmail(prefs.getString(EMAIL_KEY, ""));
        userInfo.setSchool(prefs.getString(SCHOOL_KEY, ""));
        userInfo.setProfilePictureUrl(prefs.getString(PROFILE_PICTURE_URL_KEY, null));
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        prefs.edit().putString(USER_NAME_KEY, userInfo.getName()).apply();
        prefs.edit().putString(EMAIL_KEY, userInfo.getName()).apply();
        prefs.edit().putString(SCHOOL_KEY, userInfo.getName()).apply();
        prefs.edit().putString(PROFILE_PICTURE_URL_KEY, userInfo.getProfilePictureUrl());
    }
}
