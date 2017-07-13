package com.rok.mymobilewallet.common;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {

    protected V view;

    public BasePresenter() {
    }

    @Override
    public void onTakeView(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
