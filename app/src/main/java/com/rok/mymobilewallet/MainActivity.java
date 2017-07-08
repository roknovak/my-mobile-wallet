package com.rok.mymobilewallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.Toolbar;

import com.rok.mymobilewallet.common.BaseActivity;
import com.rok.mymobilewallet.common.ToolbarActivity;
import com.rok.mymobilewallet.databinding.ActivityMainBinding;

public class MainActivity extends ToolbarActivity<ActivityMainBinding> {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
