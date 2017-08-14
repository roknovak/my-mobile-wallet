package com.rok.mymobilewallet.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.common.BaseActivity;
import com.rok.mymobilewallet.databinding.ActivitySplashBinding;
import com.rok.mymobilewallet.login.LoginActivity;
import com.rok.mymobilewallet.main.MainActivity;
import com.rok.mymobilewallet.utils.BundleUtil;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashContract.Presenter> implements SplashContract.View {

    @LayoutRes
    private final static int LAYOUT = R.layout.activity_splash;
    private final static String EXTRA_SHOW_ANIMATION = "extra_animation";

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.putExtra(EXTRA_SHOW_ANIMATION, false);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    public boolean shouldShowAnimation() {
        return BundleUtil.getExtras(getIntent().getExtras(), EXTRA_SHOW_ANIMATION, true);
    }

    @Override
    public void startMainActivity() {
        MainActivity.startActivity(SplashActivity.this);
        finish();
    }

    @Override
    public void startLoginActivity() {
        LoginActivity.startActivity(SplashActivity.this);
        finish();
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerSplashComponent.builder()
                .splashModule(new SplashModule())
                .build()
                .inject(this);
    }
}
