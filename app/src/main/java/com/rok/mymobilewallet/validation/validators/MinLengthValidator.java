package com.rok.mymobilewallet.validation.validators;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class MinLengthValidator extends Validator {

    private final int minLength;

    public MinLengthValidator(@StringRes int errorId, @NonNull int minLength) {
        super(errorId);
        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String text) {
        final int length = text.length();
        return length >= minLength;
    }
}
