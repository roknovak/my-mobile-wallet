package com.rok.mymobilewallet.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rok.mymobilewallet.common.RecyclerViewAdapter;
import com.rok.mymobilewallet.databinding.ListItemExpenseBinding;
import com.rok.mymobilewallet.entity.Expense;
import com.rok.mymobilewallet.room.ExpenseDataSource;
import com.rok.mymobilewallet.viewholder.ExpenseViewHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rok on 8. 07. 2017.
 */

@Module
public class MainModule {

    @Provides
    @Singleton
    MainContract.Presenter providesMainPresenter(ExpenseDataSource dataSource) {
        return new MainPresenter(dataSource);
    }

    @Provides
    @Singleton
    RecyclerViewAdapter<Expense, ExpenseViewHolder> providesRecyclerViewAdapter() {
        return new RecyclerViewAdapter<Expense, ExpenseViewHolder>() {
            @Override
            public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ListItemExpenseBinding binding = ListItemExpenseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new ExpenseViewHolder(binding);
            }
        };
    }
}
