package com.rok.mymobilewallet.main;

import com.rok.mymobilewallet.common.BasePresenter;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.room.ExpenseDataSource;
import com.rok.mymobilewallet.utils.CollectionUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {

    private ExpenseDataSource dataSource;

    public MainPresenter(ExpenseDataSource dataSource) {
        super();
        this.dataSource = dataSource;
/*
        Expense expense = new Expense();
        expense.setTitle("title 1");
        expense.setAmount(25.44f);
        expense.setDate(new Date());
        dataSource.insert(expense)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e("sa", "Saved");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("sa", "Unable to save", throwable);
                    }
                });*/
    }

    @Override
    public void onTakeView(MainContract.View view) {
        super.onTakeView(view);
        refreshExpenses();
    }

    private void refreshExpenses() {
        dataSource.getExpenses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Expense>>() {
                    @Override
                    public void accept(List<Expense> expenses) throws Exception {
                        if (CollectionUtils.isNullOrEmpty(expenses)) {
                            view.showEmptyPlaceholder();
                        } else {
                            view.hideEmptyPlaceholder();
                            view.setExpenses(expenses);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showEmptyPlaceholder();
                    }
                });
    }
}
