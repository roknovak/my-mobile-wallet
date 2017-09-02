package com.rok.mymobilewallet.addexpense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.app.AppModule;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.common.DetailsActivity;
import com.rok.mymobilewallet.databinding.ActivityNewExpenseBinding;
import com.rok.mymobilewallet.dialogs.DatePickerFragment;
import com.rok.mymobilewallet.utils.DateUtil;
import com.rok.mymobilewallet.utils.SnackBarUtil;

import java.util.Date;

/**
 * Created by Rok on 14. 07. 2017.
 */

public class AddExpenseActivity extends DetailsActivity<ActivityNewExpenseBinding, AddExpenseContract.Presenter> implements AddExpenseContract.View, View.OnClickListener {

    @MenuRes
    private final static int MENU = R.menu.menu_add_expense;
    @LayoutRes
    private final static int LAYOUT = R.layout.activity_new_expense;

    public static void startActivity(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, AddExpenseActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.tvDate.setOnClickListener(this);
    }

    @Override
    public void setDateText(Date date) {
        binding.tvDate.setText(DateUtil.toString(date));
    }

    @Override
    public void finishWithResult(int result) {
        setResult(result);
        finish();
    }

    @Override
    public void showSnackbar(@StringRes int string) {
        SnackBarUtil.showSnackBar(binding.getRoot(), string);
    }

    @Override
    public float getExpenseAmount() {
        String amount = binding.etAmount.getText().toString();
        return (TextUtils.isEmpty(amount)) ? 0.0f : Float.parseFloat(amount);
    }

    @Override
    public String getExpenseTitle() {
        return binding.etTitle.getText().toString();
    }

    @Override
    public String getExpenseDescription() {
        return binding.etDescription.getText().toString();
    }

    @Override
    public void setErrorToTitleInput(int error) {
        binding.tilTitle.setError(getString(error));
    }

    @Override
    public void setErrorToAmountInput(int error) {
        binding.tilAmount.setError(getString(error));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(MENU, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerAddExpenseComponent.builder()
                .appModule(new AppModule(MyMobileWalletApplication.getInstance()))
                .addExpenseModule(new AddExpenseModule())
                .build()
                .inject(this);
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view);
    }

    @Override
    public void openDatePickerDialog() {
        DatePickerFragment fragment = DatePickerFragment.newInstance(null);
        fragment.setOnDateChangeListener(new DatePickerFragment.OnDateChangeListener() {
            @Override
            public void onDateChanged(Date date) {
                presenter.onDateChanged(date);
            }
        });
        fragment.show(getFragmentManager(), DatePickerFragment.TAG);
    }
}
