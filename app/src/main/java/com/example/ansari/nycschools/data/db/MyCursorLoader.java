package com.example.ansari.nycschools.data.db;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

import com.example.ansari.nycschools.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Ansari on 2/13/2018.
 */

public class MyCursorLoader extends CursorLoader {
    Context mContext;
    public MyCursorLoader(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public Cursor loadInBackground() {
//        super.loadInBackground();

        DbHelperImpl dbHelper = new DbHelperImpl(mContext);
        dbHelper.openDb();
        dbHelper.populateDb(getJsonStringAssets());
       return dbHelper.getAll();
    }





    private String getJsonStringAssets(){
        StringBuilder buf=new StringBuilder();

        try {
            InputStream json=  mContext.getAssets().open("nycjson.json");
            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str=in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();

    }
}
