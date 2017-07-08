package com.rok.mymobilewallet.common;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.rok.mymobilewallet.R;

/**
 * Created by Rok on 8. 07. 2017.
 */

public abstract class ToolbarActivity<V extends ViewDataBinding, P extends BaseContract.Presenter> extends BaseActivity<V, P> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
    }

    private void setupToolbar() {
        Toolbar toolbar = binding.getRoot().findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
