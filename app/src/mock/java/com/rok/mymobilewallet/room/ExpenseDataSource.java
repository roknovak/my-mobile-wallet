package com.rok.mymobilewallet.room;

import com.rok.mymobilewallet.entity.Expense;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by Rok on 13. 07. 2017.
 */

public class ExpenseDataSource {

    private List<Expense> TEST_DATABASE;

    public ExpenseDataSource(MyMobileWalletDatabase database) {
        TEST_DATABASE = new ArrayList<>();

        Expense expense = new Expense();
        expense.setId(1000);
        expense.setTitle("Mock Title 1");
        expense.setDescription("Mock Description 1");
        expense.setAmount(12.41f);
        expense.setDate(Calendar.getInstance().getTime());
        TEST_DATABASE.add(expense);

        expense = new Expense();
        expense.setId(1001);
        expense.setTitle("Mock Title 2");
        expense.setDescription("Mock Description 2");
        expense.setAmount(211.4f);
        expense.setDate(Calendar.getInstance().getTime());
        TEST_DATABASE.add(expense);

        expense = new Expense();
        expense.setId(1002);
        expense.setTitle("Mock Title 3");
        expense.setDescription("Mock Description 3");
        expense.setAmount(2.11f);
        expense.setDate(Calendar.getInstance().getTime());
        TEST_DATABASE.add(expense);
    }

    public Flowable<Expense> getExpense(final int id) {
        return Flowable.fromIterable(TEST_DATABASE)
                .filter(new Predicate<Expense>() {
                    @Override
                    public boolean test(Expense expense) throws Exception {
                        return id == expense.getId();
                    }
                });
    }

    public Flowable<List<Expense>> getExpenses() {
        return Flowable.just(TEST_DATABASE);
    }

    public Completable insert(final Expense expense) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                TEST_DATABASE.add(expense);
            }
        });
    }
}
