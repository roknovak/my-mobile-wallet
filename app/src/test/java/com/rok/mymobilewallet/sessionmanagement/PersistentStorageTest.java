package com.rok.mymobilewallet.sessionmanagement;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.rok.mymobilewallet.helper.CustomTestRunner;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by Rok on 2. 08. 2017.
 */
@RunWith(CustomTestRunner.class)
public class PersistentStorageTest {

    private static final String KEY_OBJECT = "key_object";
    private static final String KEY_STRING_1 = "key_string_1";
    private static final String KEY_STRING_2 = "key_string_2";
    private static final String VALUE_STRING_1 = "value_string_1";
    private static final String VALUE_STRING_2 = "value_string_2";

    private PersistentStorage storage;

    @Before
    public void setup() {
        final Gson gson = new Gson();
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
        storage = new PersistentStorage(preferences, gson);
    }

    @Test
    public void shouldReturnEditorFromSharedPreferences() {
        SharedPreferences.Editor editor = storage.getEditor();
        Assert.assertNotNull(editor);
    }

    @Test
    public void shouldReturnValueWhenGetDataIsCalled() {
        //ARRANGE
        storage.getEditor()
                .putString(KEY_STRING_1, VALUE_STRING_1)
                .commit();

        //ACT
        String actual = storage.get(KEY_STRING_1, String.class);

        //ASSERT
        Assert.assertEquals(VALUE_STRING_1, actual);
    }

    @Test
    public void shouldStoreStringsWhenSaveDataIsCalled() {
        //ACT
        storage.save(KEY_STRING_1, VALUE_STRING_1);
        storage.save(KEY_STRING_2, VALUE_STRING_2);

        //ASSERT
        Assert.assertEquals(VALUE_STRING_1, storage.get(KEY_STRING_1, String.class));
        Assert.assertEquals(VALUE_STRING_2, storage.get(KEY_STRING_2, String.class));
    }

    @Test
    public void shouldSaveObjectWhenSaveDataIsCalled() {
        //ASSERT
        TestModel testModel = new TestModel();
        testModel.title = VALUE_STRING_1;
        testModel.description = VALUE_STRING_2;

        //ACT
        storage.save(KEY_OBJECT, testModel);

        //ASSERT
        Assert.assertEquals(testModel, storage.get(KEY_OBJECT, TestModel.class));
    }

    @Test
    public void shouldRemoveAllValuesFromSharedPreferencesWhenClearIsCalled() {
        //ARRANGE
        SharedPreferences.Editor editor = storage.getEditor();
        editor.putString(KEY_STRING_1, VALUE_STRING_1).commit();
        editor.putString(KEY_STRING_2, VALUE_STRING_2).commit();

        //ACT
        storage.clear();

        //ASSERT
        Assert.assertNull(storage.get(KEY_STRING_1, String.class));
        Assert.assertNull(storage.get(KEY_STRING_2, String.class));
    }

    public static class TestModel {
        private String title;
        private String description;

        @Override
        public boolean equals(Object obj) {
            if(getClass() != obj.getClass()) {
                return false;
            }
            TestModel other = (TestModel) obj;
            return title.equals(other.title)
                    && description.equals(other.description);
        }
    }
}