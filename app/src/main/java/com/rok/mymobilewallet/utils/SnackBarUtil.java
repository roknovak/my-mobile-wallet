package com.rok.mymobilewallet.utils;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Rok on 14. 08. 2017.
 */

public class SnackBarUtil {

    public static void showSnackBar(@NonNull View view, @StringRes int string) {
        Snackbar.make(view.findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG).show();
    }

    public static void showSnackBar(@NonNull View view, @NonNull String string) {
        Snackbar.make(view.findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG).show();
    }
}
