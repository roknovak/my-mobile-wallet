package com.rok.mymobilewallet.sessionmanagement;

import com.rok.mymobilewallet.helper.CustomTestRunner;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

/**
 * Created by Rok on 2. 08. 2017.
 */
@RunWith(CustomTestRunner.class)
public class NonPersistentStorageTest {

    private static final String KEY_STRING_1 = "key_string_1";
    private static final String KEY_STRING_2 = "key_string_2";
    private static final String VALUE_STRING_1 = "value_string_1";
    private static final String VALUE_STRING_2 = "value_string_2";

    private NonPersistentStorage storage;

    @Before
    public void setup() {
        storage = new NonPersistentStorage();
    }

    @Test
    public void shouldConstructorCreateHashMap() {
        Assert.assertNotNull(storage.getMap());
    }

    @Test
    public void shouldReturnValueWhenGetDataIsCalled() {
        //ARRANGE
        storage.getMap().put(KEY_STRING_1, VALUE_STRING_1);

        //ACT
        String actual = storage.get(KEY_STRING_1, String.class);

        //ASSERT
        Assert.assertEquals(VALUE_STRING_1, actual);
    }

    @Test
    public void shouldSaveObjectWhenStoreDataIsCalled() {
        //ACT
        storage.save(KEY_STRING_1, VALUE_STRING_1);
        storage.save(KEY_STRING_2, VALUE_STRING_2);

        //ASSERT
        Assert.assertEquals(VALUE_STRING_1, storage.get(KEY_STRING_1, String.class));
        Assert.assertEquals(VALUE_STRING_2, storage.get(KEY_STRING_2, String.class));
    }

    @Test
    public void shouldRemoveAllValuesFromSharedPreferencesWhenClearIsCalled() {
        //ARRANGE
        Map<String, Object> map = storage.getMap();
        map.put(KEY_STRING_1, VALUE_STRING_1);
        map.put(KEY_STRING_2, VALUE_STRING_2);

        //ACT
        storage.clear();

        //ASSERT
        Assert.assertNull(storage.get(KEY_STRING_1, String.class));
        Assert.assertNull(storage.get(KEY_STRING_2, String.class));
    }
}