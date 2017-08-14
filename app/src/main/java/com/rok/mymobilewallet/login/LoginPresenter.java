package com.rok.mymobilewallet.login;

import android.support.annotation.NonNull;
import android.view.View;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.common.BasePresenter;
import com.rok.mymobilewallet.sessionmanagement.Session;

import java.util.UUID;


/**
 * Created by Rok on 8. 07. 2017.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {

    public LoginPresenter() {
        super();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                if(view.validateViews()) {
                    startLogin();
                }
                break;
        }
    }

    private void startLogin() {
        final String username = view.getUsername();
        final String password = view.getPassword();
        final boolean keepLoggedIn = view.isKeepLoggedIn();

        if ("TESTER".equals(username) && "PASSWORD".equals(password)) {
            performLogin(UUID.randomUUID().toString(), keepLoggedIn);
        } else {
            view.showError(R.string.error_username_or_password_invalid);
        }
    }

    private void performLogin(@NonNull String accessToken, boolean keepLoggedIn) {
        Session.login(accessToken, keepLoggedIn);

        view.clearError();
        view.startMainActivity();
    }
}
