package com.rok.mymobilewallet.common;

/**
 * Created by Rok on 8. 07. 2017.
 */

public interface BaseContract {

    interface View {

    }

    interface Presenter<T extends BaseContract.View> {
        void onTakeView(T view);

        void onDetach();
    }
}
