package com.example.ansari.nycschools.data.db.model;

/**
 * Created by Joel on 2/13/2018.
 */

public class SchoolSatScore {
   private String dbn;
   private String noSatTakers;
   private String criticalReadingAvgScore;
   private String mathAvgScore;
   private  String writingAvgScore;
   private String schoolName;

    public SchoolSatScore() {
    }

    public SchoolSatScore(String dbn, String noSatTakers, String criticalReadingAvgScore, String mathAvgScore, String writingAvgScore, String schoolName) {
        this.dbn = dbn;
        this.noSatTakers = noSatTakers;
        this.criticalReadingAvgScore = criticalReadingAvgScore;
        this.mathAvgScore = mathAvgScore;
        this.writingAvgScore = writingAvgScore;
        this.schoolName = schoolName;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getNoSatTakers() {
        return noSatTakers;
    }

    public void setNoSatTakers(String noSatTakers) {
        this.noSatTakers = noSatTakers;
    }

    public String getCriticalReadingAvgScore() {
        return criticalReadingAvgScore;
    }

    public void setCriticalReadingAvgScore(String criticalReadingAvgScore) {
        this.criticalReadingAvgScore = criticalReadingAvgScore;
    }

    public String getMathAvgScore() {
        return mathAvgScore;
    }

    public void setMathAvgScore(String mathAvgScore) {
        this.mathAvgScore = mathAvgScore;
    }

    public String getWritingAvgScore() {
        return writingAvgScore;
    }

    public void setWritingAvgScore(String writingAvgScore) {
        this.writingAvgScore = writingAvgScore;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    /*public SchoolSatScore(String dbn, int noSatTakers, int criticalReadingAvgScore, int mathAvgScore, int writingAvgScore, String schoolName) {
        this.dbn = dbn;
        this.noSatTakers = noSatTakers;
        this.criticalReadingAvgScore = criticalReadingAvgScore;
        this.mathAvgScore = mathAvgScore;
        this.writingAvgScore = writingAvgScore;
        this.schoolName = schoolName;
    }

    public SchoolSatScore(String dbn, String noSatTakers, String criticalReadingAvgScore, String mathAvgScore, String writingAvgScore, String schoolName) {
        this.dbn = dbn;
        this.noSatTakers = Integer.parseInt(noSatTakers);
        this.criticalReadingAvgScore =  Integer.parseInt(criticalReadingAvgScore);
        this.mathAvgScore = Integer.parseInt(mathAvgScore);
        this.writingAvgScore = Integer.parseInt(writingAvgScore);
        this.schoolName = schoolName;
    }
*/

}
