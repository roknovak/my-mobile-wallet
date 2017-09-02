package com.rok.mymobilewallet.main;

import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.common.BasePresenter;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.room.ExpenseDataSource;
import com.rok.mymobilewallet.sessionmanagement.Session;
import com.rok.mymobilewallet.utils.RequestCode;
import com.rok.mymobilewallet.utils.ResultCode;

import java.util.ArrayList;
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
    }

    @Override
    public void onTakeView(MainContract.View view) {
        super.onTakeView(view);
        refreshExpenses();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_new:
                view.openAddNewExpenseActivity();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode) {
        if (requestCode == RequestCode.ADD_EXPENSE && resultCode == ResultCode.REFRESH_EXPENSES) {
            refreshExpenses();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            Session.logout();
            return true;
        }
        return false;
    }

    private void refreshExpenses() {
        dataSource.getExpenses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Expense>>() {
                    @Override
                    public void accept(List<Expense> expenses) throws Exception {
                        setExpenses(expenses);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setExpenses(new ArrayList<Expense>());
                    }
                });
    }

    private void setExpenses(@NonNull List<Expense> expenses) {
        if (expenses.isEmpty()) {
            view.showEmptyStateLayout();
            return;
        }

        float sum = 0f;
        for (Expense expense : expenses) {
            sum += expense.getAmount();
        }
        view.setSum(sum);
        view.setExpenses(expenses);
    }
}
