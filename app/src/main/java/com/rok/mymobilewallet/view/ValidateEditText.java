package com.rok.mymobilewallet.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.rok.mymobilewallet.validation.ValidationResult;
import com.rok.mymobilewallet.validation.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class ValidateEditText extends android.support.v7.widget.AppCompatEditText {

    private List<Validator> validators = new ArrayList<>();

    public ValidateEditText(Context context) {
        super(context);
    }

    public ValidateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ValidateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addValidator(@NonNull Validator validator) {
        validators.add(validator);
    }

    public ValidationResult validate() {
        final String text = getText().toString();
        for (Validator validator : validators) {
            final ValidationResult result = validator.validate(text);
            if(!result.isValid()) {
                return result;
            }
        }

        final ValidationResult result = new ValidationResult();
        result.setValid(true);
        return result;
    }
}
