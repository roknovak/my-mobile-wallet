package com.rok.mymobilewallet.login;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class LoginModule {

    @Provides
    @Singleton
    LoginContract.Presenter providesLoginPresenter() {
        return new LoginPresenter();
    }
}
