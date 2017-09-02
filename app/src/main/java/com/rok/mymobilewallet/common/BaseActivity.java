package com.rok.mymobilewallet.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rok on 8. 07. 2017.
 */

public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();

    protected V binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayout());
        setupDaggerComponent();
    }

    @LayoutRes
    protected abstract int getLayout();

    protected abstract void setupDaggerComponent();
}
