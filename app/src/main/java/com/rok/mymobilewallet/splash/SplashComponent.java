package com.rok.mymobilewallet.splash;

import com.rok.mymobilewallet.app.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rok on 8. 07. 2017.
 */
@Singleton
@Component(modules = {AppModule.class, SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
