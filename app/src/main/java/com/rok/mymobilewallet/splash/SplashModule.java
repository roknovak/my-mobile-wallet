package com.rok.mymobilewallet.splash;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class SplashModule {

    private SplashContract.View view;

    public SplashModule(SplashContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    SplashContract.View providesSplashView() {
        return view;
    }

    @Provides
    @Singleton
    SplashContract.Presenter providesSplashPresenter(SplashContract.View view) {
        return new SplashPresenter(view);
    }
}
