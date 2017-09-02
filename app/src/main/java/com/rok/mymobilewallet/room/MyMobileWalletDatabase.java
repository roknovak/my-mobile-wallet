package com.rok.mymobilewallet.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.entity.Group;

/**
 * Created by Rok on 12. 07. 2017.
 */

@Database(entities = {Expense.class, Group.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class MyMobileWalletDatabase extends RoomDatabase {
    public abstract GroupDao groupDao();

    public abstract ExpenseDao expenseDao();
}
