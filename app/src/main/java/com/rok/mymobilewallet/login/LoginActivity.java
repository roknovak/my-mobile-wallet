package com.rok.mymobilewallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.common.FormActivity;
import com.rok.mymobilewallet.databinding.ActivityLoginBinding;
import com.rok.mymobilewallet.main.MainActivity;

public class LoginActivity extends FormActivity<ActivityLoginBinding, LoginContract.Presenter> implements LoginContract.View, View.OnClickListener {

    @LayoutRes
    private final static int LAYOUT = R.layout.activity_login;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addRequiredValidationView(binding.etUsername);
        addRequiredValidationView(binding.etPassword);
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view);
    }

    @Override
    public void startMainActivity() {
        MainActivity.startActivity(LoginActivity.this);
    }

    @Override
    public void showError(@StringRes int error) {
        binding.etPassword.setError(getString(error));
        binding.etPassword.setErrorEnabled(true);
    }

    @Override
    public void clearError() {
        binding.etPassword.setError(null);
        binding.etPassword.setErrorEnabled(false);
    }

    @Override
    public boolean isKeepLoggedIn() {
        return binding.cbKeepLoggedIn.isChecked();
    }

    @Override
    public String getUsername() {
        return binding.etUsername.getText();
    }

    @Override
    public String getPassword() {
        return binding.etPassword.getText();
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule())
                .build()
                .inject(this);
    }
}
