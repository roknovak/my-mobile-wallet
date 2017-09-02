package com.rok.mymobilewallet.storage;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.gson.Gson;

/**
 * Created by Rok on 2. 08. 2017.
 */

public class PersistentStorage implements Storage {

    @NonNull private final Gson gson;
    @NonNull private final SharedPreferences preferences;

    public PersistentStorage(@NonNull SharedPreferences preferences, @NonNull Gson gson) {
        this.gson = gson;
        this.preferences = preferences;
    }

    @Override
    public void save(String name, Object object) {
        getEditor()
                .putString(name, gson.toJson(object))
                .commit();
    }

    @Override
    public <T> T get(String name, Class<T> clazz) {
        String json = preferences.getString(name, "");
        return gson.fromJson(json, clazz);
    }

    @Override
    public void remove(String name) {
        getEditor().remove(name).commit();
    }

    @Override
    public void clear() {
        getEditor().clear().commit();
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public SharedPreferences.Editor getEditor() {
        return preferences.edit();
    }
}
