package com.example.hosseini.weatherappfinal;

import org.json.JSONObject;

/**
 * Created by zahra on 7/19/2016 AD.
 */
public class SearchResult {


    public String cityName="?";
    public int locationKey=0;

    public SearchResult (JSONObject r) throws Exception{

        this.cityName=r.getString("LocalizedName");
        this.locationKey=r.getInt("Key");

    }

}
