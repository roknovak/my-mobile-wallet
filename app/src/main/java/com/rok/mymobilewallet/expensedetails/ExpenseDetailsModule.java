package com.rok.mymobilewallet.expensedetails;

import android.support.annotation.NonNull;

import com.rok.mymobilewallet.room.ExpenseDataSource;

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
    ExpenseDetailsContract.Presenter providesDetailsExpensePresenter(@NonNull ExpenseDataSource dataSource) {
        return new ExpenseDetailsPresenter(dataSource);
    }
}
