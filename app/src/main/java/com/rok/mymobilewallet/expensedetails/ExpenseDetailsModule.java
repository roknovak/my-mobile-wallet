package com.rok.mymobilewallet.expensedetails;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class ExpenseDetailsModule {

    @Provides
    @Singleton
    ExpenseDetailsContract.Presenter providesDetailsExpensePresenter() {
        return new ExpenseDetailsPresenter();
    }
}
