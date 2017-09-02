package com.rok.mymobilewallet.addexpense;

import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.common.BasePresenter;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.utils.ResultCode;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import com.rok.mymobilewallet.room.ExpenseDataSource;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class AddExpensePresenter extends BasePresenter<AddExpenseContract.View> implements AddExpenseContract.Presenter<AddExpenseContract.View> {

    private Date selectedDate;
    private ExpenseDataSource dataSource;

    public AddExpensePresenter(ExpenseDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            addNewExpense();
            return true;
        }
        return false;
    }

    @Override
    public void onDateChanged(Date date) {
        selectedDate = date;
        view.setDateText(date);
    }

    @Override
    public void onTakeView(AddExpenseContract.View view) {
        super.onTakeView(view);
        onDateChanged(Calendar.getInstance().getTime());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_date) {
            view.openDatePickerDialog();
        }
    }

    private void addNewExpense() {
        String title = view.getExpenseTitle();
        if (TextUtils.isEmpty(title)) {
            view.setErrorToTitleInput(R.string.error_insert_title);
            return;
        }

        float amount = view.getExpenseAmount();
        if (amount <= 0.0f) {
            view.setErrorToAmountInput(R.string.error_insert_amount);
            return;
        }

        String description = view.getExpenseDescription();

        Expense expense = new Expense();
        expense.setTitle(title);
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setDate(selectedDate);
        dataSource.insert(expense)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.showSnackbar(R.string.new_expense_successfully_added);
                        view.finishWithResult(ResultCode.REFRESH_EXPENSES);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showSnackbar(R.string.new_expense_unsuccessfully_added);
                    }
                });
    }
}
