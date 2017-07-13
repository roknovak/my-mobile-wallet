package com.rok.mymobilewallet.room;

import com.rok.mymobilewallet.entity.Expense;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by Rok on 13. 07. 2017.
 */

public class ExpenseDataSource {

    private final ExpenseDao expenseDao;

    public ExpenseDataSource(MyMobileWalletDatabase database) {
        expenseDao = database.expenseDao();
    }

    public Flowable<Expense> getExpense(int id) {
        return expenseDao.getExpenseById(id);
    }

    public Flowable<List<Expense>> getExpenses() {
        return expenseDao.getAllExpenses();
    }

    public Completable insert(final Expense expense) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                expenseDao.insert(expense);
            }
        });
    }
}
