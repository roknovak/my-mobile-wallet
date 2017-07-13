package com.rok.mymobilewallet.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Rok on 12. 07. 2017.
 */

public abstract class BaseViewHolder<B extends ViewDataBinding, T> extends RecyclerView.ViewHolder {

    protected B binding;

    public BaseViewHolder(B binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public abstract void bind(T t);
}
