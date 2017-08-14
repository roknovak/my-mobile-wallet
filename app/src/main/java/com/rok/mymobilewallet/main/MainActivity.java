package com.rok.mymobilewallet.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.app.AppModule;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.common.RecyclerViewAdapter;
import com.rok.mymobilewallet.common.ToolbarActivity;
import com.rok.mymobilewallet.databinding.ActivityMainBinding;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.viewholder.ExpenseViewHolder;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends ToolbarActivity<ActivityMainBinding, MainContract.Presenter> implements MainContract.View, View.OnClickListener {

    @LayoutRes
    private final static int LAYOUT = R.layout.activity_main;

    @Inject
    RecyclerViewAdapter<Expense, ExpenseViewHolder> adapter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void setExpenses(List<Expense> expenses) {
        adapter.setItems(expenses);
    }

    @Override
    public void showEmptyPlaceholder() {
        binding.rvExpenses.setVisibility(View.GONE);
        binding.tvEmptyPlaceholder.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyPlaceholder() {
        binding.rvExpenses.setVisibility(View.VISIBLE);
        binding.tvEmptyPlaceholder.setVisibility(View.GONE);
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerMainComponent.builder()
                .appModule(new AppModule(MyMobileWalletApplication.getInstance()))
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view);
    }

    private void setupActivity() {
        binding.setListener(this);
        binding.rvExpenses.setLayoutManager(new LinearLayoutManager(this));
        binding.rvExpenses.setAdapter(adapter);
    }
}
