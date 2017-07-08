package com.rok.mymobilewallet.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyMobileWalletApplication application;

    public AppModule(MyMobileWalletApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyMobileWalletApplication providesApplication() {
        return application;
    }

    @Provides
    Context providesAppContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(MyMobileWalletApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}