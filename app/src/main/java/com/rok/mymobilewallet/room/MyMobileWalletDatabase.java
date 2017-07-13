package com.rok.mymobilewallet.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.rok.mymobilewallet.entity.Expense;

/**
 * Created by Rok on 12. 07. 2017.
 */

@Database(entities = {Expense.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class MyMobileWalletDatabase extends RoomDatabase {
    public abstract ExpenseDao expenseDao();
}
