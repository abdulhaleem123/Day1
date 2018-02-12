package com.example.ansari.nycschools.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ansari.nycschools.data.db.model.SatScoresContract.SatEntry;

import com.example.ansari.nycschools.data.db.model.SatScoresContract;

/**
 * Created by joel on 2/13/2018.
 */



public class SatReaderDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SatEntry.TABLE_NAME + " (" +
                    SatEntry._ID + " INTEGER PRIMARY KEY," +
                    SatEntry.DBN + " TEXT," +
                    SatEntry.NO_SAT_TAKERS + " TEXT," +
                    SatEntry.SAT_CRITICAL_READING_AVG_SCORE + " TEXT," +
                    SatEntry.SAT_MATH_AVG_SCORE + " TEXT," +
                    SatEntry.SAT_WRITING_AVG_SCORE + " TEXT," +
                    SatEntry.SCHOOL_NAME + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SatEntry.TABLE_NAME;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SatReader.db";

    public SatReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
