package com.rok.mymobilewallet.storage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.rok.mymobilewallet.app.AppComponent;
import com.rok.mymobilewallet.app.MyMobileWalletApplication;
import com.rok.mymobilewallet.session.Session;

/**
 * Created by Rok on 2. 08. 2017.
 */

public class StorageUtil {

    @NonNull
    public static Storage createStorage(boolean persistent) {
        if (persistent) {
            AppComponent component = MyMobileWalletApplication.getInstance().getAppComponent();
            return new PersistentStorage(component.preferences(), component.gson());
        } else {
            return new NonPersistentStorage();
        }
    }

    @Nullable
    public static Storage getPersistentStorageIfExist() {
        Storage persistentStorage = createStorage(true);
        if(Session.isTokenValid(persistentStorage)) {
            return persistentStorage;
        } else {
            return null;
        }
    }
}
