package com.rok.mymobilewallet.sessionmanagement;

import android.content.Context;
import android.support.annotation.NonNull;

import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.splash.SplashActivity;

/**
 * Created by Rok on 13. 08. 2017.
 */

public class Session {

    private static final String KEY_ACCESS_TOKEN = "access_token";

    private static Storage storage;

    public static void checkForActiveSession() {
        storage = StorageUtil.getPersistentStorageIfExist();
    }

    public static void login(@NonNull String accessToken, boolean keepLoggedIn) {
        storage = StorageUtil.createStorage(keepLoggedIn);
        saveAccessToken(storage, accessToken);
    }

    public static void logout() {
        if (storage != null) {
            storage.clear();
            storage = null;
        }
        final Context context = MyMobileWalletApplication.getInstance().getApplicationContext();
        SplashActivity.startActivity(context);
    }

    public static boolean isTokenValid() {
        return isTokenValid(storage);
    }

    public static boolean isTokenValid(Storage storage) {
        return storage != null && getAccessToken(storage) != null;
    }

    private static String getAccessToken(@NonNull Storage storage) {
        return storage.get(KEY_ACCESS_TOKEN, String.class);
    }

    private static void saveAccessToken(@NonNull Storage storage, @NonNull String accessToken) {
        storage.save(KEY_ACCESS_TOKEN, accessToken);
    }
}
