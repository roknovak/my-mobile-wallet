package com.rok.mymobilewallet.splash;

import android.os.Bundle;

import com.rok.mymobilewallet.common.BaseContract;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface SplashContract {

    interface View extends BaseContract.View {
        void startLoginActivity();

        void startMainActivity();

        boolean shouldShowAnimation();
    }

    interface Presenter<V extends BaseContract.View> extends BaseContract.Presenter<V> {

    }
}
