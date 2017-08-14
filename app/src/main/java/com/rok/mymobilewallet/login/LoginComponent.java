package com.rok.mymobilewallet.login;

import com.rok.mymobilewallet.app.AppModule;
import com.rok.mymobilewallet.splash.SplashActivity;
import com.rok.mymobilewallet.splash.SplashModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rok on 8. 07. 2017.
 */
@Singleton
@Component(modules = {AppModule.class, LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
