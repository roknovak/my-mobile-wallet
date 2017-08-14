package com.rok.mymobilewallet.validation;

import android.support.annotation.StringRes;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class ValidationResult {

    private String error;
    private boolean valid;

    public void setError(String error) {
        this.error = error;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public String getError() {
        return error;
    }
}
