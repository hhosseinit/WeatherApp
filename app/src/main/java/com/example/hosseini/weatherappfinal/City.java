package com.example.hosseini.weatherappfinal;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;


public class City {

    public String timeZone;

    public int locationKey = 0;
    public String cityName = "loading";

    public boolean currentLoaded = false;

    private ArrayList<HourStatus> hourStatusArrayList = new ArrayList<>();
    private ArrayList<DayStatus> dayStatusArrayList = new ArrayList<>();

    private String currentStatus = "?";
    private String currentHour = "?";

    private String currentDay = "?";
    private String currentTempC = "?";
    private String currentTempF = "loading";

    private String currentDayMinTempC = "?";
    private String currentDayMaxTempC = "?";
    private String currentDayMinTempF = "?";
    private String currentDayMaxTempF = "?";


    private String humidity = "?";
    private String wind = "?";
    private String feelC = "?";
    private String feelF = "?";
    private String pressure = "?";
    private String precipitation = "?";
    private String visibility = "?";
    private String uv = "?";

    //
    private String sunrise = "?";
    private String sunset = "?";
    private String rain = "?";

    private int icon = 0;

    // true if C

    public boolean type;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setCurrent(Current result) {

        // Update City Fields according to result
        this.setCurrentTempC(result.tempC + " C");
        this.setCurrentTempF(result.tempF + " F");
        //this.setCurrentHour(result.time.get(Calendar.HOUR) + ":" + result.time.get(Calendar.MINUTE));

        this.setCurrentHour(Util.localeDate(result.time, this.timeZone).get(Calendar.HOUR) + ":" + Util.localeDate(result.time, this.timeZone).get(Calendar.MINUTE));
        this.currentDay = Util.getDayName(Util.localeDate(result.time, this.timeZone));

        // Detail
        this.setCurrentStatus(result.currentStatus);
        this.setFeelC(result.feelC + "");
        this.setFeelF(result.feelF + "");
        this.setHumidity(result.humidity);
        this.setWind(result.wind);
        this.setUv(result.uv);
        this.setVisibility(result.visibility);
        this.setPressure(result.pressure);
        this.setPrecipitation(result.precipitation);
        this.setCurrentDayMinTempC(result.currentDayMinTempC);
        this.setCurrentDayMaxTempC(result.currentDayMaxTempC);
        this.setCurrentDayMinTempF(result.currentDayMinTempF);
        this.setCurrentDayMaxTempF(result.currentDayMaxTempF);
        this.setIcon(result.weatherIcon);

        this.currentLoaded = true;

    }

    public void setHours(ArrayList<Hourly> hours) {

        this.hourStatusArrayList.clear();
        for (int i = 0; i < hours.size(); i++) {

            HourStatus h = new HourStatus();

            h.setHour(Util.getHourFormatted(Util.localeDate(hours.get(i).hour, this.timeZone)) + "");
          //  int thour = Util.localeDate(hours.get(i).hour, this.timeZone).get(Calendar.HOUR);

            h.setTempC(hours.get(i).tempC);
            h.setTempF(hours.get(i).tempF);
            h.setWeatherIcon(hours.get(i).WeatherIcon);
            this.hourStatusArrayList.add(h);
        }

    }

    public void setDays(ArrayList<Daily> days) {

        this.dayStatusArrayList.clear();
        for (int i = 0; i < days.size(); i++) {
            DayStatus d = new DayStatus();
            d.setDay(days.get(i).day);
            d.setIcon(days.get(i).icon);
            d.setMinTempC(days.get(i).minTempC);
            d.setMaxTempC(days.get(i).maxTempC);
            d.setMinTempF(days.get(i).minTempF);
            d.setMaxTempF(days.get(i).maxTempF);
            this.dayStatusArrayList.add(d);
        }

    }


    public int getLocationKey() {
        return locationKey;
    }

    public String getCityName() {
        return cityName;
    }

    public City(int locationKey, String cityName, String timeZone) {
        this.locationKey = locationKey;
        this.cityName = cityName;
        this.timeZone = timeZone;
    }

    public void setCurrentDayMinTempC(String currentDayMinTempC) {
        this.currentDayMinTempC = currentDayMinTempC;
    }

    public void setCurrentDayMaxTempC(String currentDayMaxTempC) {
        this.currentDayMaxTempC = currentDayMaxTempC;
    }

    public void setCurrentDayMinTempF(String currentDayMinTempF) {
        this.currentDayMinTempF = currentDayMinTempF;
    }

    public void setCurrentDayMaxTempF(String currentDayMaxTempF) {
        this.currentDayMaxTempF = currentDayMaxTempF;
    }

    public String getCurrentDayMinTempC() {
        return currentDayMinTempC;
    }

    public String getCurrentDayMaxTempC() {
        return currentDayMaxTempC;
    }

    public String getCurrentDayMinTempF() {
        return currentDayMinTempF;
    }

    public String getCurrentDayMaxTempF() {
        return currentDayMaxTempF;
    }

    public void setFeelC(String feelC) {
        this.feelC = feelC;
    }

    public void setFeelF(String feelF) {
        this.feelF = feelF;
    }

    public String getFeelC() {
        return feelC;
    }

    public String getFeelF() {
        return feelF;
    }

//    public City(String currentTemp) {
//        this.currentTemp = currentTemp;
//    }

    public ArrayList<HourStatus> getHourStatusArrayList() {
        return hourStatusArrayList;
    }

    public void setHourStatusArrayList(ArrayList<HourStatus> hourStatusArrayList) {
        this.hourStatusArrayList = hourStatusArrayList;
    }

    public ArrayList<DayStatus> getDayStatusArrayList() {
        return dayStatusArrayList;
    }

    public void setDayStatusArrayList(ArrayList<DayStatus> dayStatusArrayList) {
        this.dayStatusArrayList = dayStatusArrayList;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentHour() {
        return currentHour;
    }

    public void setCurrentHour(String currentHour) {
        this.currentHour = currentHour;
    }

    public String getCurrentTempC() {
        return currentTempC;
    }

    public void setCurrentTempC(String currentTempC) {
        this.currentTempC = currentTempC;
    }

    public String getCurrentTempF() {
        return currentTempF;
    }

    public void setCurrentTempF(String currentTempF) {
        this.currentTempF = currentTempF;
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public int getImageBack() {

        if (icon == 1 || icon == 2 || icon == 3)
            return R.drawable.sunny;

        if (icon == 4 || icon == 5 || icon == 6 || icon == 7 || icon == 8 || icon == 11 || icon == 20 || icon == 21)
            return R.drawable.cloudy;

        if (((icon >= 12) && (icon <= 19)) || icon == 25 || icon == 26 || icon == 29)
            return R.drawable.rainy;

        if (icon == 22 || icon == 24)
            return R.drawable.sunny;

        else return R.drawable.dark;

    }


}
