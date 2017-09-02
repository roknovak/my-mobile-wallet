package com.rok.mymobilewallet.addexpense;

import com.rok.mymobilewallet.app.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rok on 8. 07. 2017.
 */
@Singleton
@Component(modules = {AppModule.class, AddExpenseModule.class})
public interface AddExpenseComponent {
    void inject(AddExpenseActivity activity);
}
