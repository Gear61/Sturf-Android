package com.randomappsinc.sturf.Utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by alexanderchiou on 3/27/16.
 */
public class PermissionUtils {
    public static void requestPermission(Activity activity, String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }

    public static boolean isPermissionGranted(String permission) {
        return ContextCompat.checkSelfPermission(MyApplication.getAppContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }
}
