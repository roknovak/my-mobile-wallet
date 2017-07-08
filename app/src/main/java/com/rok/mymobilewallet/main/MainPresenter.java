package com.rok.mymobilewallet.main;

import com.rok.mymobilewallet.common.BasePresenter;

/**
 * Created by Rok on 8. 07. 2017.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        super(view);
    }
}
