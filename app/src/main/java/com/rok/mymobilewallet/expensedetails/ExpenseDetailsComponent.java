package com.rok.mymobilewallet.expensedetails;

import com.rok.mymobilewallet.app.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rok on 8. 07. 2017.
 */
@Singleton
@Component(modules = {AppModule.class, ExpenseDetailsModule.class})
public interface ExpenseDetailsComponent {
    void inject(ExpenseDetailsActivity activity);
}
