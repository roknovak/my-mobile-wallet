package com.rok.mymobilewallet.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.rok.mymobilewallet.validation.ValidationResult;
import com.rok.mymobilewallet.validation.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rok on 3. 08. 2017.
 */

public abstract class ValidateEditText extends TextInputLayout {

    private TextInputEditText editText;
    private List<Validator> validators = new ArrayList<>();

    public ValidateEditText(Context context) {
        this(context, null);
    }

    public ValidateEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ValidateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void addValidator(@NonNull Validator validator) {
        validators.add(validator);
    }

    public abstract int getInputType();

    public ValidationResult validate() {
        setError(null);
        setErrorEnabled(false);

        final String text = editText.getText().toString();
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

    public String getText() {
        return editText.getText().toString();
    }

    private void init() {
        editText = new TextInputEditText(getContext());
        editText.setInputType(getInputType());
        addView(editText);
    }
}
