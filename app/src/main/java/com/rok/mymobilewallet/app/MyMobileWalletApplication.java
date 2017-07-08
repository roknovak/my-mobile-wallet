package com.rok.mymobilewallet.app;

import android.app.Application;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class MyMobileWalletApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
