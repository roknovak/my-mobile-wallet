package com.rok.mymobilewallet.expensedetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.app.AppModule;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.common.DetailsActivity;
import com.rok.mymobilewallet.databinding.ActivityExpenseDetailsBinding;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.utils.BundleUtil;

/**
 * Created by Rok on 14. 07. 2017.
 */

public class ExpenseDetailsActivity extends DetailsActivity<ActivityExpenseDetailsBinding, ExpenseDetailsContract.Presenter> implements ExpenseDetailsContract.View {

    @LayoutRes
    private final static int LAYOUT = R.layout.activity_expense_details;
    private static final String KEY_EXTRA_EXPENSE_ID = "KEY_EXTRA_EXPENSE_ID";

    public static void startActivity(Context context, int expenseId) {
        Intent intent = new Intent(context, ExpenseDetailsActivity.class);
        intent.putExtra(KEY_EXTRA_EXPENSE_ID, expenseId);
        context.startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    public int getExpenseId() {
        return BundleUtil.getExtras(getIntent().getExtras(), KEY_EXTRA_EXPENSE_ID);
    }

    @Override
    public void setExpense(Expense expense) {
        binding.setExpense(expense);
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerExpenseDetailsComponent.builder()
                .appModule(new AppModule(MyMobileWalletApplication.getInstance()))
                .expenseDetailsModule(new ExpenseDetailsModule())
                .build()
                .inject(this);
    }
}
