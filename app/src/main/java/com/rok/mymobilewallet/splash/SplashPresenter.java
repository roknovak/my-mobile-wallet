package com.rok.mymobilewallet.splash;

import android.os.Handler;

import com.rok.mymobilewallet.common.BasePresenter;


/**
 * Created by Rok on 8. 07. 2017.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {
    private static final long DELAY = 1000;

    private Handler handler;
    private Runnable runnable;

    public SplashPresenter(SplashContract.View view) {
        super(view);
        startHandler();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        stopHandler();
    }

    private void startHandler() {
        if(handler == null) {
            handler = new Handler();
        }
        if(runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    view.startMainActivity();
                }
            };
        }
        handler.postDelayed(runnable, DELAY);
    }

    private void stopHandler() {
        if(handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
