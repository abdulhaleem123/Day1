package com.example.ansari.nycschools;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.ansari.nycschools.data.db.DbHelperImpl;
import com.example.ansari.nycschools.data.db.MyCursorLoader;
import com.example.ansari.nycschools.data.db.model.SatScoresContract.SatEntry;
import com.example.ansari.nycschools.data.db.model.SchoolSatScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener {
SimpleCursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listview);

        getLoaderManager().initLoader(1,null,this);

        cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, null,
                new String[] {SatEntry.SCHOOL_NAME,SatEntry.NO_SAT_TAKERS},
                new int[] { android.R.id.text1, android.R.id.text2 }, 0);
        listView.setAdapter(cursorAdapter);
        listView.setOnItemClickListener(this);

    }



    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        return new MyCursorLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
         cursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Cursor cursor =  (Cursor)adapterView.getItemAtPosition(position);
        int schoolNameIndex = cursor.getColumnIndexOrThrow(SatEntry.SCHOOL_NAME);
        String schoolName =  cursor.getString(schoolNameIndex);
        Toast.makeText(MainActivity.this,schoolName,Toast.LENGTH_SHORT).show();

    }
}
