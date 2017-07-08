package com.rok.mymobilewallet.main;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    MainContract.View providesMainView() {
        return view;
    }

    @Provides
    @Singleton
    MainContract.Presenter providesMainPresenter(MainContract.View view) {
        return new MainPresenter(view);
    }
}
