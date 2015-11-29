package com.lf.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by krish on 29/11/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TBL_CONTACT = "contact";
    public static final String CONTACT_ID = "contact_id";
    public static final String CONTACT_NAME = "contact_name";
    public static final String CONTACT_ADDRESS = "address";
    public static final String GNEDER = "contact_gender";


    public static final String CREATE_CONTACT_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TBL_CONTACT
            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CONTACT_ID + " String UNIQUE, "
            + CONTACT_NAME + " TEXT, "
            + CONTACT_ADDRESS + " TEXT, "
            + GNEDER + " TEXT )";


    public DatabaseHelper(Context context) {
        super(context, "db_contact", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
