package com.rok.mymobilewallet.app;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.rok.mymobilewallet.room.ExpenseDataSource;
import com.rok.mymobilewallet.room.GroupDataSource;
import com.rok.mymobilewallet.room.MyMobileWalletDatabase;

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
    Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(MyMobileWalletApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    MyMobileWalletDatabase providesDatabase(MyMobileWalletApplication application) {
        return Room.databaseBuilder(application, MyMobileWalletDatabase.class, "database-my-mobile-wallet").build();
    }

    @Provides
    @Singleton
    ExpenseDataSource providesExpenseDataSource(MyMobileWalletDatabase database) {
        return new ExpenseDataSource(database);
    }

    @Provides
    @Singleton
    GroupDataSource providesGroupDataSource(MyMobileWalletDatabase database) {
        return new GroupDataSource(database);
    }
}