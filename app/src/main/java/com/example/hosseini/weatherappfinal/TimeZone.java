package com.example.hosseini.weatherappfinal;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by zahra on 7/22/2016 AD.
 */
public class TimeZone {

    public String timeZone;

    public TimeZone(JSONObject r) throws Exception{

        this.timeZone=r.getJSONObject("TimeZone").getString("Name");


    }
}
