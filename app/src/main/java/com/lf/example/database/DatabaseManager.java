package com.lf.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by krish on 29/11/15.
 */
public class DatabaseManager {
    private static DatabaseManager INSTANCE;
    SQLiteDatabase db;


    public DatabaseManager(Context mContext) {
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(mContext);
        this.db = mDatabaseHelper.getWritableDatabase();
    }


    public static DatabaseManager newInstance(Context mContext) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(mContext);
        }

        return INSTANCE;
    }






}
