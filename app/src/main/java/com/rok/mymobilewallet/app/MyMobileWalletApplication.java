package com.rok.mymobilewallet.app;

import android.app.Application;

import com.rok.mymobilewallet.sessionmanagement.Session;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class MyMobileWalletApplication extends Application {

    private static MyMobileWalletApplication INSTANCE;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Session.checkForActiveSession();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MyMobileWalletApplication getInstance() {
        return INSTANCE;
    }
}