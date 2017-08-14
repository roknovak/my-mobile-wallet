package com.rok.mymobilewallet.validation.validators;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class MaxLengthValidator extends Validator {

    private final int maxLength;

    public MaxLengthValidator(@StringRes int errorId, @NonNull int maxLength) {
        super(errorId);
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValid(String text) {
        final int length = text.length();
        return length <= maxLength;
    }
}
