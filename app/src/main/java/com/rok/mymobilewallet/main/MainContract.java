package com.rok.mymobilewallet.main;

import android.view.MenuItem;
import android.view.View;

import com.rok.mymobilewallet.common.BaseContract;
import com.rok.mymobilewallet.entity.Expense;

import java.util.List;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface MainContract {

    interface View extends BaseContract.View {

        void setExpenses(List<Expense> expenses);

        void showEmptyPlaceholder();

        void hideEmptyPlaceholder();
    }

    interface Presenter<V extends BaseContract.View> extends BaseContract.Presenter<V> {

        void onClick(android.view.View view);

        boolean onOptionsItemSelected(MenuItem item);
    }
}
