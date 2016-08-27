package com.example.hosseini.weatherappfinal;

/**
 * Created by zahra on 7/13/2016 AD.
 */
public class DayStatus {

    private String day;
    private int icon;
    private String minTempC;
    private String maxTempC;
    private String minTempF;
    private String maxTempF;

    public String getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(String minTempC) {
        this.minTempC = minTempC;
    }

    public String getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(String maxTempC) {
        this.maxTempC = maxTempC;
    }

    public String getMinTempF() {
        return minTempF;
    }

    public void setMinTempF(String minTempF) {
        this.minTempF = minTempF;
    }

    public String getMaxTempF() {
        return maxTempF;
    }

    public void setMaxTempF(String maxTempF) {
        this.maxTempF = maxTempF;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getUnicodeDay(){

        if (icon == 1 || icon == 2 || icon == 3)
            return "\u2600";

        if (icon == 4 || icon == 5 || icon == 6 || icon == 7 || icon == 8 || icon == 11 || icon == 20 || icon == 21)
            return "\u26C5";

        if( ( (icon>=12) && (icon<=19) ) || icon==25 || icon==26 || icon==29)
            return "\u26C8";

        if(icon==22 || icon==24)
            return "\u2744";


        else return "\u2600";

    }


}
