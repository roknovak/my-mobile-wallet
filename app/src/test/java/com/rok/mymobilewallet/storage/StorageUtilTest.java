package com.rok.mymobilewallet.storage;

import com.rok.mymobilewallet.helper.CustomTestRunner;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Rok on 2. 08. 2017.
 */
@RunWith(CustomTestRunner.class)
public class StorageUtilTest {

    @Test
    public void shouldReturnPersistentStorage() {
        Storage session = StorageUtil.createStorage(true);
        Assert.assertEquals(session.getClass(), PersistentStorage.class);
    }

    @Test
    public void shouldReturnNonPersistentStorage() {
        Storage session = StorageUtil.createStorage(false);
        Assert.assertEquals(session.getClass(), NonPersistentStorage.class);
    }
}