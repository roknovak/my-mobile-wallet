package com.rok.mymobilewallet.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Rok on 12. 07. 2017.
 */

@Entity(tableName = Expense.TABLE_NAME)
public class Expense {
    public static final String TABLE_NAME = "expenses";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_DATE = "date";
    public static final String COLUMN_NAME_GROUP = "group";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_AMOUNT = "amount";
    public static final String COLUMN_NAME_DESCRIPTION = "description";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_NAME_ID)
    private int id;

    @ColumnInfo(name = COLUMN_NAME_TITLE)
    private String title;

    @ColumnInfo(name = COLUMN_NAME_DESCRIPTION)
    private String description;

    @ColumnInfo(name = COLUMN_NAME_AMOUNT)
    private float amount;

    @ColumnInfo(name = COLUMN_NAME_DATE)
    private Date date;

    @ColumnInfo(name = COLUMN_NAME_GROUP)
    private int groupId;

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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
