package com.rok.mymobilewallet;

import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rok.mymobilewallet.common.BaseActivity;
import com.rok.mymobilewallet.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    private static final long DELAY = 1000;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.startActivity(SplashActivity.this);
            }
        }, DELAY);
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.activity_splash;
    }
}
