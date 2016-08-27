package com.example.hosseini.weatherappfinal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherAPI {


    Util util;

    public WeatherAPI(Util util) {
        this.util = util;
    }

    // Get City row info
    public void getConditions(int location,final ICallback<Current> callback) {
        util.json_request(makeUrl("currentconditions/v1/" + location + ".json", "details=true"), new ICallback() {
            public void callback(Object o) throws Exception {
                try {
                    JSONArray res = (JSONArray) o;
                    JSONObject r = res.getJSONObject(0);

                    Current c = new Current(r);

                    util.fixCallback(callback).callback(c);
                } catch (Exception e) {
                    util.error(e);
                }
            }
        });
    }

    public void getHourStatus(int location,final ICallback<ArrayList<Hourly>> callback) {
        util.json_request(makeUrl("forecasts/v1/hourly/12hour/" + location + ".json", "details=true&metric=true"), new ICallback() {
            public void callback(Object o) throws Exception {
                try {

                    JSONArray res = (JSONArray) o;
                    ArrayList<Hourly> hourlies=new ArrayList();

                    for (int i = 0; i < res.length(); i++) {
                        JSONObject r = res.getJSONObject(i);
                        Hourly h = new Hourly(r);
                        hourlies.add(h);
                    }
                    util.fixCallback(callback).callback(hourlies);

                } catch (Exception e) {
                    util.error(e);
                }
            }
        });

    }

    public void getDayStatus(int location,final ICallback<ArrayList<Daily>> callback) {
        util.json_request(makeUrl("/forecasts/v1/daily/5day/" + location + ".json", "details=true&metric=true"), new ICallback() {
            public void callback(Object o) throws Exception {
                try {

                    JSONObject res = (JSONObject) o;
                    JSONArray forcasts=res.getJSONArray("DailyForecasts");

                    ArrayList<Daily> dailies=new ArrayList();

                    for (int i = 0; i < forcasts.length(); i++) {
                        JSONObject r = forcasts.getJSONObject(i);
                        Daily d = new Daily(r);
                        dailies.add(d);
                    }
                    util.fixCallback(callback).callback(dailies);

                } catch (Exception e) {
                    util.error(e);
                }
            }
        });

    }

    public void getSearchResult(final String q, final ICallback<ArrayList<SearchResult>> callback){

        util.json_request(makeUrl("locations/v1/cities/autocomplete","q="+q+"&details=true&metric=true"), new ICallback() {

            public void callback(Object o) throws Exception {
                try {


                    JSONArray res = (JSONArray) o;
                    ArrayList<SearchResult> searchResults=new ArrayList();

                    Log.i("in api",res+"");

                    for (int i = 0; i < res.length(); i++) {
                        JSONObject r = res.getJSONObject(i);
                        SearchResult sr = new SearchResult(r);
                        searchResults.add(sr);

                    }
                    util.fixCallback(callback).callback(searchResults);

                } catch (Exception e) {
                    util.error(e);
                    Log.i("error",q);
                }
            }
        });

    }

    public String makeUrl(String path, String params) {
        String endpoint = "http://dataservice.accuweather.com/";
        // String key = "FfYjQKdCgUirtM05AOuqmA7B2HOnTuRV";
        String key="0BPbrMUigduyuIx3whZYpBGEnMkXp2mR";
        return endpoint + path + "?apikey=" + key + "&language=en&" + params;
    }

    public void getTimeZone(int location,final ICallback<TimeZone> callback) {
        util.json_request(makeUrl("locations/v1/" + location + ".json", ""), new ICallback() {
            public void callback(Object o) throws Exception {
                try {
                    // JSONArray res = (JSONArray) o;
                    // JSONObject r = res.getJSONObject(0);

                    JSONObject r=(JSONObject) o;
                    TimeZone c = new TimeZone(r);

                    util.fixCallback(callback).callback(c);
                } catch (Exception e) {
                    util.error(e);
                }
            }
        });
    }

}
