package com.rok.mymobilewallet.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.rok.mymobilewallet.entity.Group;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Rok on 12. 07. 2017.
 */

@Dao
public interface GroupDao {

    @Query("SELECT * FROM " + Group.TABLE_NAME + " WHERE " + Group.COLUMN_NAME_ID + " = :id LIMIT 1")
    Flowable<Group> getGroupById(int id);

    @Query("SELECT * FROM " + Group.TABLE_NAME)
    Flowable<List<Group>> getAllGroups();

    @Insert
    void insert(Group group);

    @Update
    void update(Group group);

    @Delete
    void delete(Group group);
}
