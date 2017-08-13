package com.rok.mymobilewallet.helper;

import android.app.Application;
import android.support.annotation.NonNull;

import com.rok.mymobilewallet.BuildConfig;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;

import org.junit.runners.model.InitializationError;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;

/**
 * Created by Rok Novak, Drugi Vid d.o.o.
 */

public class CustomTestRunner extends RobolectricTestRunner {

    private final static int TEST_SDK_VERSION = 21;

    public CustomTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @NonNull
    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return CustomTestLifecycle.class;
    }

    @Override
    protected Config buildGlobalConfig() {
        return new Config.Builder()
                .setSdk(TEST_SDK_VERSION)
                .setConstants(BuildConfig.class)
                .setPackageName("com.rok.mymobilewallet")
                .setManifest("src/main/AndroidManifest.xml")
                .build();
    }

    private static class CustomTestLifecycle extends DefaultTestLifecycle {

        @Override
        public Application createApplication(java.lang.reflect.Method method, AndroidManifest appManifest, Config config) {
            return new MyMobileWalletApplication();
        }
    }
}
