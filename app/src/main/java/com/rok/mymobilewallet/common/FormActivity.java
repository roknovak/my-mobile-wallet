package com.rok.mymobilewallet.common;

import android.databinding.ViewDataBinding;

import com.rok.mymobilewallet.validation.ValidationResult;
import com.rok.mymobilewallet.view.ValidateEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rok on 13. 08. 2017.
 */

public abstract class FormActivity<V extends ViewDataBinding, P extends BaseContract.Presenter> extends BaseActivity<V, P> {

    private List<ValidateEditText> requiredValidationViews = new ArrayList<>();

    protected void addRequiredValidationView(ValidateEditText requiredValidationView) {
        requiredValidationViews.add(requiredValidationView);
    }

    public boolean validateViews() {
        boolean valid = true;
        for (ValidateEditText requiredValidationView : requiredValidationViews) {
            final ValidationResult result = requiredValidationView.validate();
            if (!result.isValid()) {
                requiredValidationView.setError(result.getError());
                valid = false;
            }
        }
        return valid;
    }
}
