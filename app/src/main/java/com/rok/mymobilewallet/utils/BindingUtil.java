package com.rok.mymobilewallet.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.StringRes;
import android.widget.TextView;

import com.rok.mymobilewallet.R;

/**
 * Created by Rok on 20. 08. 2017.
 */

public class BindingUtil {

    @BindingAdapter("amount")
    public static void setCurrency(final TextView textView, final float amount) {
        textView.setText(CurrencyUtil.format(amount));
    }

    @BindingAdapter("android:text")
    public static void setText(final TextView textView, @StringRes final int stringId) {
        if(stringId != 0) {
            textView.setText(stringId);
        } else {
            textView.setText("");
        }
    }
}
