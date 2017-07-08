package com.rok.mymobilewallet.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;

import com.rok.mymobilewallet.R;
import com.rok.mymobilewallet.common.ToolbarActivity;
import com.rok.mymobilewallet.databinding.ActivityMainBinding;

public class MainActivity extends ToolbarActivity<ActivityMainBinding, MainContract.Presenter> implements MainContract.View {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupDaggerComponent() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }
}
