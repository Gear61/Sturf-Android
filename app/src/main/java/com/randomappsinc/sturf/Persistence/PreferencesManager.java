package com.randomappsinc.sturf.Persistence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.randomappsinc.sturf.Utils.MyApplication;

/**
 * Created by alexanderchiou on 4/1/16.
 */
public class PreferencesManager {
    public static final String HAS_SEEN_ITEM_PAGE = "hasSeenItemPage";
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
}
