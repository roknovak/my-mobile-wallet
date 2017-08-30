package com.rok.mymobilewallet.viewholder;

import com.rok.mymobilewallet.common.RecyclerViewAdapter;
import com.rok.mymobilewallet.databinding.ListItemExpenseBinding;
import com.rok.mymobilewallet.entity.Expense;

/**
 * Created by Rok on 12. 07. 2017.
 */

public class ExpenseViewHolder extends BaseViewHolder<ListItemExpenseBinding, Expense> {

    public ExpenseViewHolder(ListItemExpenseBinding binding) {
        super(binding);
    }

    @Override
    public void bind(Expense expense, RecyclerViewAdapter.ItemClickListener<Expense> listener) {
        binding.setExpense(expense);
        binding.setListener(listener);
        binding.executePendingBindings();
    }
}
