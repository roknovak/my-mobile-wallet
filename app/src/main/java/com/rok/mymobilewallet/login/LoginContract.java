package com.rok.mymobilewallet.login;

import android.support.annotation.StringRes;
import android.view.View;

import com.rok.mymobilewallet.common.BaseContract;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface LoginContract {

    interface View extends BaseContract.View {
        void startMainActivity();

        void showError(@StringRes int error);

        void clearError();

        String getUsername();

        String getPassword();

        boolean isKeepLoggedIn();

        boolean validateViews();
    }

    interface Presenter<V extends BaseContract.View> extends BaseContract.Presenter<V> {

        void onClick(android.view.View view);
    }
}
