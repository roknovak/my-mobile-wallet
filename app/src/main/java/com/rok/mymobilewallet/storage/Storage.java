package com.rok.mymobilewallet.storage;

/**
 * Created by Rok on 2. 08. 2017.
 */

public interface Storage {

    void clear();

    void remove(String name);

    void save(String name, Object object);

    <T> T get(String name, Class<T> clazz);
}
