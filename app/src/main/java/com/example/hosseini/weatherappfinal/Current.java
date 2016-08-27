package com.example.hosseini.weatherappfinal;

import org.json.JSONObject;

import java.util.Calendar;


public class Current {


    public int tempC = 0;
    public int tempF = 0;
    public String currentStatus = "";
    public int weatherIcon = 0;
    public long time;

    // Detail
    public double feelC = 0;
    public double feelF = 0;
    public String humidity = "";
    public String wind = "";
    public String uv = "";
    public String visibility = "";
    public String pressure = "";
    public String precipitation = "";
    public String currentDayMinTempC = "";
    public String currentDayMaxTempC = "";
    public String currentDayMinTempF = "";
    public String currentDayMaxTempF = "";


    public Current(JSONObject r) throws Exception {


        // Temp
        this.tempC = (int) r.getJSONObject("Temperature").getJSONObject("Metric").getDouble("Value");
        this.tempF = (int) r.getJSONObject("Temperature").getJSONObject("Imperial").getDouble("Value");
        this.currentStatus = r.getString("WeatherText");
        this.weatherIcon = r.getInt("WeatherIcon");

        // Time
        // this.time = Util.localeDate(r.getLong("EpochTime"));
        this.time=r.getLong("EpochTime");

        // Detail

        this.feelC = r.getJSONObject("RealFeelTemperature").getJSONObject("Metric").getDouble("Value");
        this.feelF = r.getJSONObject("RealFeelTemperature").getJSONObject("Imperial").getDouble("Value");
        this.humidity = r.getString("RelativeHumidity") + " %";
        this.wind = r.getJSONObject("Wind").getJSONObject("Direction").getString("English") + "  " +
                r.getJSONObject("Wind").getJSONObject("Speed").getJSONObject("Metric").getDouble("Value") + " km/h";
        this.uv = r.getString("UVIndex");
        this.visibility = r.getJSONObject("Visibility").getJSONObject("Metric").getDouble("Value") + " km";
        this.pressure = r.getJSONObject("Pressure").getJSONObject("Metric").getDouble("Value") + " mb";
        this.precipitation = r.getJSONObject("PrecipitationSummary").getJSONObject("Precipitation").getJSONObject("Metric").getDouble("Value") / 10 + " cm";
        this.currentDayMinTempC = (int) r.getJSONObject("TemperatureSummary").getJSONObject("Past24HourRange").getJSONObject("Minimum").getJSONObject("Metric").getDouble("Value") + "";
        this.currentDayMaxTempC = (int) r.getJSONObject("TemperatureSummary").getJSONObject("Past24HourRange").getJSONObject("Maximum").getJSONObject("Metric").getDouble("Value") + "";
        this.currentDayMinTempF = (int) r.getJSONObject("TemperatureSummary").getJSONObject("Past24HourRange").getJSONObject("Minimum").getJSONObject("Imperial").getDouble("Value") + "";
        this.currentDayMaxTempF = (int) r.getJSONObject("TemperatureSummary").getJSONObject("Past24HourRange").getJSONObject("Maximum").getJSONObject("Imperial").getDouble("Value") + "";

    }

}


