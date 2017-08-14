package com.rok.mymobilewallet.validation.validators;

import android.support.annotation.StringRes;

import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.validation.ValidationResult;

/**
 * Created by Rok on 3. 08. 2017.
 */

public abstract class Validator {

    @StringRes
    private final int errorId;

    Validator(@StringRes int errorId) {
        this.errorId = errorId;
    }

    abstract boolean isValid(String text);

    public ValidationResult validate(String text) {
        if (isValid(text)) {
            return getSuccess();
        } else {
            return getError();
        }
    }

    private ValidationResult getSuccess() {
        ValidationResult result = new ValidationResult();
        result.setValid(true);
        return result;
    }

    private ValidationResult getError() {
        ValidationResult result = new ValidationResult();
        result.setError(getString(errorId));
        result.setValid(false);
        return result;
    }

    private String getString(@StringRes int string) {
        return MyMobileWalletApplication.getInstance().getString(string);
    }
}
