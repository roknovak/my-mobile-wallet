package com.rok.mymobilewallet.expensedetails;

import android.text.TextUtils;
import android.view.MenuItem;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.common.BasePresenter;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.room.ExpenseDataSource;
import com.rok.mymobilewallet.utils.ResultCode;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class ExpenseDetailsPresenter extends BasePresenter<ExpenseDetailsContract.View> implements ExpenseDetailsContract.Presenter<ExpenseDetailsContract.View> {

    @Inject
    ExpenseDataSource dataSource;

    public ExpenseDetailsPresenter() {
        MyMobileWalletApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void onTakeView(ExpenseDetailsContract.View view) {
        super.onTakeView(view);
        getExpense(view.getExpenseId());
    }

    private void getExpense(int id) {
        dataSource.getExpense(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Expense>() {
                    @Override
                    public void accept(Expense expense) throws Exception {
                        view.setExpense(expense);
                    }
                });
    }
}
