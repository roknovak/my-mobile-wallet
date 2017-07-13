package com.rok.mymobilewallet.splash;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class SplashModule {

    @Provides
    @Singleton
    SplashContract.Presenter providesSplashPresenter() {
        return new SplashPresenter();
    }
}
