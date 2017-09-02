package com.rok.mymobilewallet.addexpense;

import android.support.annotation.StringRes;
import android.view.MenuItem;
import android.view.View;

import com.rok.mymobilewallet.common.BaseContract;

import java.util.Date;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface AddExpenseContract {

    interface View extends BaseContract.View {

        void finishWithResult(int result);

        void showSnackbar(@StringRes int string);

        String getExpenseTitle();

        String getExpenseDescription();

        float getExpenseAmount();

        void setErrorToTitleInput(@StringRes int error);

        void setErrorToAmountInput(@StringRes int error);

        void setDateText(Date date);

        void openDatePickerDialog();
    }

    interface Presenter<V extends BaseContract.View> extends BaseContract.Presenter<V> {

        boolean onOptionsItemSelected(MenuItem item);

        void onDateChanged(Date date);

        void onClick(android.view.View view);
    }
}
