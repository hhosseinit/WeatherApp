package com.example.hosseini.weatherappfinal;

import org.json.JSONObject;

import java.util.Calendar;

/**
 * Created by zahra on 7/18/2016 AD.
 */
public class Hourly {

    public long hour;
    public String tempC;
    public String tempF;
    public int WeatherIcon;

    public Hourly(JSONObject r) throws Exception {

//        Calendar time = Util.localeDate(r.getLong("EpochDateTime"));
//        this.hour = Util.getHourFormatted(time);

        this.hour=r.getLong("EpochDateTime");

        this.WeatherIcon = r.getInt("WeatherIcon");
        this.tempC = (int) r.getJSONObject("Temperature").getDouble("Value") + "";
        this.tempF = Util.c2f(r.getJSONObject("Temperature").getDouble("Value")) + "";


    }
}
