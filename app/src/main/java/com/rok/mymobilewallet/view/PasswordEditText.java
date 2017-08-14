package com.rok.mymobilewallet.view;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.validation.validators.MaxLengthValidator;
import com.rok.mymobilewallet.validation.validators.MinLengthValidator;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class PasswordEditText extends ValidateEditText {

    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 24;

    public PasswordEditText(Context context) {
        super(context);
        init();
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public int getInputType() {
        return InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;
    }

    private void init() {
        setPasswordVisibilityToggleEnabled(true);
        setHint(getResources().getString(R.string.hint_password));

        addValidator(new MaxLengthValidator(R.string.error_password_too_long, MAX_LENGTH));
        addValidator(new MinLengthValidator(R.string.error_password_too_short, MIN_LENGTH));
    }
}
