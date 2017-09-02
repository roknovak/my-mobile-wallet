package com.rok.mymobilewallet.splash;

import android.os.Handler;

import com.rok.mymobilewallet.common.BasePresenter;
import com.rok.mymobilewallet.sessionmanagement.Session;


/**
 * Created by Rok on 8. 07. 2017.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter<SplashContract.View> {

    private final static long DELAY = 1000;

    private Handler handler;
    private Runnable runnable;

    @Override
    public void onTakeView(SplashContract.View view) {
        super.onTakeView(view);

        final boolean showAnimation = view.shouldShowAnimation();
        if (showAnimation) {
            startHandler();
        } else {
            startNextActivity();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        stopHandler();
    }

    private void startHandler() {
        if (handler == null) {
            handler = new Handler();
        }
        if (runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    startNextActivity();
                }
            };
        }
        handler.postDelayed(runnable, DELAY);
    }

    private void startNextActivity() {
        if (Session.isTokenValid()) {
            view.startMainActivity();
        } else {
            view.startLoginActivity();
        }
    }

    private void stopHandler() {
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
