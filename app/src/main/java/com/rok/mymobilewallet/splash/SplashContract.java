package com.rok.mymobilewallet.splash;

import com.rok.mymobilewallet.common.BaseContract;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface SplashContract {

    interface View extends BaseContract.View {
        void startMainActivity();
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
