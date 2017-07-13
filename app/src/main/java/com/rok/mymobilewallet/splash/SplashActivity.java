package com.rok.mymobilewallet.splash;

import android.support.annotation.LayoutRes;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.common.BaseActivity;
import com.rok.mymobilewallet.databinding.ActivitySplashBinding;
import com.rok.mymobilewallet.main.MainActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashContract.Presenter> implements SplashContract.View {

    @Override
    public void startMainActivity() {
        MainActivity.startActivity(SplashActivity.this);
        finish();
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerSplashComponent.builder()
                .splashModule(new SplashModule())
                .build()
                .inject(this);
    }
}
