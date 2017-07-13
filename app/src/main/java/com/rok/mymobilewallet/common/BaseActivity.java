package com.rok.mymobilewallet.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by Rok on 8. 07. 2017.
 */

public abstract class BaseActivity<V extends ViewDataBinding, P extends BaseContract.Presenter> extends AppCompatActivity implements BaseContract.View {
    protected final String TAG = getClass().getSimpleName();

    @Inject
    protected P presenter;
    protected V binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayout());
        setupDaggerComponent();
        presenter.onTakeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @LayoutRes
    protected abstract int getLayout();

    protected abstract void setupDaggerComponent();
}
