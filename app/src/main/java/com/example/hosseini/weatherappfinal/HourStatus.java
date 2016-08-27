package com.example.hosseini.weatherappfinal;

/**
 * Created by hosseini on 7/22/2016.
 */
public class HourStatus {

    private String hour;
    private String tempC;
    private String tempF;
    private int WeatherIcon;




    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getUnicodeHour(){

        if (WeatherIcon == 1 || WeatherIcon == 2 || WeatherIcon == 3)
            return "\u2600";

        if (WeatherIcon == 4 || WeatherIcon == 5 || WeatherIcon == 6 || WeatherIcon == 7 || WeatherIcon == 8 || WeatherIcon == 11 || WeatherIcon == 20 || WeatherIcon == 21)
            return "\u26C5";

        if( ( (WeatherIcon>=12) && (WeatherIcon<=19) ) || WeatherIcon==25 || WeatherIcon==26 || WeatherIcon==29)
            return "\u26C8";

        if(WeatherIcon==22 || WeatherIcon==24)
            return "\u2744";

        else return "\uD83C\uDF19";

    }


}
