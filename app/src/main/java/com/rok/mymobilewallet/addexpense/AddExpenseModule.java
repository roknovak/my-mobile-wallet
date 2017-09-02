package com.rok.mymobilewallet.addexpense;

import android.support.annotation.NonNull;

import com.rok.mymobilewallet.room.ExpenseDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class AddExpenseModule {

    @Provides
    @Singleton
    AddExpenseContract.Presenter providesAddExpensePresenter(@NonNull ExpenseDataSource dataSource) {
        return new AddExpensePresenter(dataSource);
    }
}
