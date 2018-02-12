package com.example.ansari.nycschools.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ansari.nycschools.data.db.model.SatScoresContract.SatEntry;
import com.example.ansari.nycschools.data.db.model.SchoolSatScore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joel on 2/13/2018.
 */

public class DbHelperImpl implements IDbHelper {
    SatReaderDbHelper dbHelper;
    SQLiteDatabase database;

    public DbHelperImpl(Context mContext) {
        dbHelper = new SatReaderDbHelper(mContext);
    }

    public void openDb() {
        database = dbHelper.getWritableDatabase();
    }

    private void closeDb() {
        dbHelper.close();
    }

    @Override
    public void insertSchoolSatScore(SchoolSatScore schoolSatScore) {
        ContentValues values = new ContentValues();

        values.put(SatEntry.DBN, schoolSatScore.getDbn());
        values.put(SatEntry.NO_SAT_TAKERS, schoolSatScore.getNoSatTakers());
        values.put(SatEntry.SAT_CRITICAL_READING_AVG_SCORE, schoolSatScore.getCriticalReadingAvgScore());
        values.put(SatEntry.SAT_MATH_AVG_SCORE, schoolSatScore.getMathAvgScore());
        values.put(SatEntry.SAT_WRITING_AVG_SCORE, schoolSatScore.getWritingAvgScore());
        values.put(SatEntry.SCHOOL_NAME, schoolSatScore.getSchoolName());

        database.insert(SatEntry.TABLE_NAME, null, values);

    }

    @Override
    public SchoolSatScore getSchoolSatScore(String dbn) {
        String selection = SatEntry.DBN + " = ?";
        String[] selectionArgs = {dbn};
        Cursor cursor = database.query(
                SatEntry.TABLE_NAME,                     // The table to query
                null,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        cursor.moveToLast();

        int dbnIndex = cursor.getColumnIndexOrThrow(SatEntry.DBN);
        int satTakersIndex = cursor.getColumnIndexOrThrow(SatEntry.NO_SAT_TAKERS);
        int readingAvgIndex = cursor.getColumnIndexOrThrow(SatEntry.SAT_CRITICAL_READING_AVG_SCORE);
        int mathAvgIndex = cursor.getColumnIndexOrThrow(SatEntry.SAT_MATH_AVG_SCORE);
        int writingAvgIndex = cursor.getColumnIndexOrThrow(SatEntry.SAT_WRITING_AVG_SCORE);
        int schoolNameIndex = cursor.getColumnIndexOrThrow(SatEntry.SCHOOL_NAME);

        SchoolSatScore schoolSatScore = new SchoolSatScore(
                cursor.getString(dbnIndex),
                cursor.getString(satTakersIndex),
                cursor.getString(readingAvgIndex),
                cursor.getString(mathAvgIndex),
                cursor.getString(writingAvgIndex),
                cursor.getString(schoolNameIndex)
        );
        return schoolSatScore;
    }


    @Override
    public void populateDb(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                SchoolSatScore schoolSatScore = new SchoolSatScore(
                        jsonObject.getString(SatEntry.DBN),
                        jsonObject.getString(SatEntry.NO_SAT_TAKERS),
                        jsonObject.getString(SatEntry.SAT_CRITICAL_READING_AVG_SCORE),
                        jsonObject.getString(SatEntry.SAT_MATH_AVG_SCORE),
                        jsonObject.getString(SatEntry.SAT_WRITING_AVG_SCORE),
                        jsonObject.getString(SatEntry.SCHOOL_NAME)
                );
                insertSchoolSatScore(schoolSatScore);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Cursor getAll() {

        return database.query(
                SatEntry.TABLE_NAME,                     // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
    }
}
