package com.example.hosseini.weatherappfinal;

/**
 * Created by hosseini on 7/22/2016.
 */
public class DailyRowItem {

    private String day;
    private String Wcharacter;
    private String minDegree;
    private String maxDegree;

    public DailyRowItem(String day, String Wcharacter, String minDegree, String maxDegree){
        this.setDay(day);
        this.setWcharacter(Wcharacter);
        this.setMaxDegree(maxDegree);
        this.setMinDegree(minDegree);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWcharacter() {
        return Wcharacter;
    }

    public void setWcharacter(String wcharacter) {
        Wcharacter = wcharacter;
    }

    public String getMinDegree() {
        return minDegree;
    }

    public void setMinDegree(String minDegree) {
        this.minDegree = minDegree;
    }

    public String getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(String maxDegree) {
        this.maxDegree = maxDegree;
    }

    @Override
    public String toString() {
        return day;
    }

}
