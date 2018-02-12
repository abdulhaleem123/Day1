package com.example.ansari.nycschools.data.db;

import com.example.ansari.nycschools.data.db.model.SchoolSatScore;

/**
 * Created by joel on 2/13/2018.
 */

public interface IDbHelper {

    public void insertSchoolSatScore(SchoolSatScore schoolSatScore);
    public SchoolSatScore getSchoolSatScore(String dbn);
    public void populateDb(String jsonString);
}
