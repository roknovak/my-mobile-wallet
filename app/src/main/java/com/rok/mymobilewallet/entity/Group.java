package com.rok.mymobilewallet.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Rok on 12. 07. 2017.
 */

@Entity(tableName = Group.TABLE_NAME)
public class Group {
    public static final String TABLE_NAME = "groups";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_DESCRIPTION = "description";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_NAME_ID)
    private int id;

    @ColumnInfo(name = COLUMN_NAME_TITLE)
    private String title;

    @ColumnInfo(name = COLUMN_NAME_DESCRIPTION)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
