package com.rok.mymobilewallet.common;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * Created by Rok on 2. 09. 2017.
 */

public abstract class MvpActivity<V extends ViewDataBinding, P extends BaseContract.Presenter> extends BaseActivity<V> implements BaseContract.View {

    @Inject
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onTakeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
