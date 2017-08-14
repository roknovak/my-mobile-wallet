package com.rok.mymobilewallet.validation.validators;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class RegexValidator extends Validator {

    private final String pattern;

    public RegexValidator(@StringRes int errorId, @NonNull String pattern) {
        super(errorId);
        this.pattern = pattern;
    }

    @Override
    public boolean isValid(String text) {
        return text.matches(pattern);
    }
}
