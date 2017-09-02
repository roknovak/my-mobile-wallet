package com.rok.mymobilewallet.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Rok on 20. 08. 2017.
 */

public class CurrencyUtil {

    private static final String CURRENCY_EURO = "EUR";

    public static String format(float amount) {
        Currency currency = Currency.getInstance(CURRENCY_EURO);

        DecimalFormat currencyFormatter = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        currencyFormatter.setMinimumFractionDigits(2);
        currencyFormatter.setMaximumFractionDigits(2);
        currencyFormatter.setCurrency(currency);

        return currencyFormatter.format(amount);
    }
}
