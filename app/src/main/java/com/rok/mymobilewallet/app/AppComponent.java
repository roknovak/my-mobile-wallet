package com.rok.mymobilewallet.app;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rok.mymobilewallet.expensedetails.ExpenseDetailsPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rok on 8. 07. 2017.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Gson gson();

    SharedPreferences preferences();

    void inject(ExpenseDetailsPresenter expenseDetailsPresenter);
}
