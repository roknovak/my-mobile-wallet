package com.rok.mymobilewallet.utils;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rok on 18. 07. 2017.
 */

public class DateUtil {

    private static final String DATE_FORMAT = "dd.MM.yyyy";

    public static String toString(@NonNull Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return dateFormat.format(date);
    }
}
