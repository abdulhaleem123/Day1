package com.example.ansari.nycschools.data.db.model;

import android.provider.BaseColumns;

public final class SatScoresContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SatScoresContract() {}

    /* Inner class that defines the table contents */
    public static class SatEntry implements BaseColumns {
        public static final String DBN = "dbn";
        public static final String TABLE_NAME = "schoolentry";

        public static final String NO_SAT_TAKERS = "num_of_sat_test_takers";
        public static final String SAT_CRITICAL_READING_AVG_SCORE = "sat_critical_reading_avg_score";
        public static final String SAT_MATH_AVG_SCORE = "sat_math_avg_score";
		public static final String SAT_WRITING_AVG_SCORE = "sat_writing_avg_score";
		public static final String SCHOOL_NAME = "school_name";


    }
}
