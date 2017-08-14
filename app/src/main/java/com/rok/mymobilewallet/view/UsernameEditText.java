package com.rok.mymobilewallet.view;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.validation.validators.MaxLengthValidator;
import com.rok.mymobilewallet.validation.validators.MinLengthValidator;
import com.rok.mymobilewallet.validation.validators.RegexValidator;

/**
 * Created by Rok on 3. 08. 2017.
 */

public class UsernameEditText extends ValidateEditText {

    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 20;
    private static final String REGEX_PATTERN = "[A-Za-z0-9]+";

    public UsernameEditText(Context context) {
        super(context);
        init();
    }

    public UsernameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UsernameEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public int getInputType() {
        return InputType.TYPE_TEXT_VARIATION_NORMAL;
    }

    private void init() {
        setHint(getResources().getString(R.string.hint_username));

        addValidator(new MaxLengthValidator(R.string.error_username_too_long, MAX_LENGTH));
        addValidator(new MinLengthValidator(R.string.error_username_too_short, MIN_LENGTH));
        addValidator(new RegexValidator(R.string.error_username_unsupported_chars, REGEX_PATTERN));
    }
}
