package com.rok.mymobilewallet.storage;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rok on 2. 08. 2017.
 */

public class NonPersistentStorage implements Storage {

    @NonNull private final Map<String, Object> map;

    public NonPersistentStorage() {
        this.map = new HashMap<>();
    }

    @Override
    public void save(String name, Object object) {
        map.put(name, object);
    }

    @Override
    public <T> T get(String name, Class<T> clazz) {
        Object object = map.get(name);
        return clazz.cast(object);
    }

    @Override
    public void clear() {
       map.clear();
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @NonNull
    Map<String, Object> getMap() {
        return map;
    }
}
