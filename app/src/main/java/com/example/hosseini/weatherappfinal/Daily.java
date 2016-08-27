package com.example.hosseini.weatherappfinal;


import org.json.JSONObject;

import java.util.Calendar;

public class Daily {

    public String day;
    public int icon;
    public String minTempC;
    public String maxTempC;
    public String minTempF;
    public String maxTempF;

    public Daily(JSONObject r) throws Exception {

        Calendar time = Util.localeDate(r.getLong("EpochDate"));
        this.day = Util.getDayName(time);

        this.icon = r.getJSONObject("Day").getInt("Icon");

        this.minTempC = (int) r.getJSONObject("Temperature").getJSONObject("Minimum").getDouble("Value") + "";
        this.maxTempC = (int) r.getJSONObject("Temperature").getJSONObject("Maximum").getDouble("Value") + "";

        this.minTempF = Util.c2f(r.getJSONObject("Temperature").getJSONObject("Minimum").getDouble("Value")) + "";
        this.maxTempF = Util.c2f(r.getJSONObject("Temperature").getJSONObject("Minimum").getDouble("Value")) + "";


    }
}
