package com.example.hosseini.weatherappfinal;

/**
 * Created by hosseini on 7/22/2016.
 */
public class RowItem {

    private int imageBackground;
    private String clock;
    private String degree;
    private String city_name;

    public RowItem(int imageBackground, String clock, String degree, String city_name) {
        this.setImageBackground(imageBackground);
        this.setClock(clock);
        this.setDegree(degree);
        this.setCity_name(city_name);
    }


    public int getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(int imageBackground) {
        this.imageBackground = imageBackground;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }


    @Override
    public String toString() {
        return city_name + "\n" + degree + "\n" +clock;
    }


}
