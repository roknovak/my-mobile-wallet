package com.rok.mymobilewallet.expensedetails;

import com.rok.mymobilewallet.common.BaseContract;
import com.rok.mymobilewallet.entity.Expense;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface ExpenseDetailsContract {

    interface View extends BaseContract.View {

        int getExpenseId();

        void setExpense(Expense expense);
    }

    interface Presenter<V extends BaseContract.View> extends BaseContract.Presenter<V> {

    }
}
