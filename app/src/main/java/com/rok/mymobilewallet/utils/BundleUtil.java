package com.rok.mymobilewallet.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Rok on 18. 07. 2017.
 */

public class BundleUtil {

    public static <T> T getExtras(@Nullable Bundle bundle, @NonNull String key) {
        return getExtras(bundle, key, null);
    }

    public static <T> T getExtras(@Nullable Bundle bundle, @NonNull String key, @Nullable T defaultValue) {
        if (bundle != null && bundle.containsKey(key)) {
            return (T) bundle.get(key);
        }
        return defaultValue;
    }
}
