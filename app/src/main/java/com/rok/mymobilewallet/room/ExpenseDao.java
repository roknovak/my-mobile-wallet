package com.rok.mymobilewallet.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.rok.mymobilewallet.entity.Expense;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Rok on 12. 07. 2017.
 */

@Dao
public interface ExpenseDao {

    @Query("SELECT * FROM " + Expense.TABLE_NAME + " WHERE " + Expense.COLUMN_NAME_ID + " = :id LIMIT 1")
    Flowable<Expense> getExpenseById(int id);

    @Query("SELECT * FROM " + Expense.TABLE_NAME)
    Flowable<List<Expense>> getAllExpenses();

    @Query("SELECT * FROM " + Expense.TABLE_NAME + " WHERE " + Expense.COLUMN_NAME_DATE + " BETWEEN :dateFrom AND :dateTo")
    Flowable<List<Expense>> getExpensesBetweenDates(Date dateFrom, Date dateTo);

    @Query("SELECT * FROM " + Expense.TABLE_NAME + " WHERE " + Expense.COLUMN_NAME_DATE + " >= :date")
    Flowable<List<Expense>> getExpensesAfterDate(Date date);

    @Query("SELECT * FROM " + Expense.TABLE_NAME + " WHERE " + Expense.COLUMN_NAME_DATE + " <= :date")
    Flowable<List<Expense>> getExpensesBeforeDate(Date date);

    @Insert
    void insert(Expense expense);

    @Update
    void update(Expense expense);

    @Delete
    void delete(Expense expense);
}
