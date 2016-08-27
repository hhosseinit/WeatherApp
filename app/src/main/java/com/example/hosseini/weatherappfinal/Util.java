package com.example.hosseini.weatherappfinal;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import com.squareup.okhttp.*;

/**
 * Created by hosseini on 7/22/2016.
 */
public class Util {

    Activity activity;

    public Util(Activity activity) {
        this.activity = activity;
    }


    public void error(final Exception e) {
        e.printStackTrace();
        Log.e("APP", e.getMessage(), e.getCause());
        if (activity == null)
            return;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Calendar localeDate(long epoch, String zone) {

        Log.i("timeZone",zone);
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone(zone));
        c.setTimeInMillis(epoch * 1000);
        return c;
    }

    public static Calendar localeDate(long epoch) {
        return localeDate(epoch, "Asia/Tehran");
        //return localeDate(epoch, "US");
    }

    public static String getHourFormatted(Calendar c) {

        String ampm = c.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
        int hour = c.get(Calendar.HOUR);
        if(hour==0)
            hour=12;

        return hour + " " + ampm;
    }

    private static final String days[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public static String getDayName(Calendar time) {
        int day = time.get(Calendar.DAY_OF_WEEK);
        return days[day % 7];
    }


    public ICallback fixCallback(final ICallback callback) {
        return new ICallback() {
            @Override
            public void callback(final Object o) throws Exception {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callback.callback(o);
                        } catch (Exception e) {
                            error(e);
                        }
                    }
                });
            }
        };
    }

    public static int c2f(double c) {
        return (int)(c * 1.8 + 32);
    }


    public void json_request(String url, final ICallback callback) {
        Log.i("WeatherAPI", "Sending request to " + url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                error(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Object o = null;
                try {
                    String response_str = response.body().string();
                    if (response_str.startsWith("["))
                        o = new JSONArray(response_str);
                    else
                        o = new JSONObject(response_str);
                        } catch (Exception e) {
                            Util.this.error(e);
                        }
                        try {
                            callback.callback(o);
                        } catch (Exception e) {
                            Util.this.error(e);
                        }
                    }
                });
            }



    public int getImage(int status) {

        if (status == 1 || status == 2 || status == 3) {
            Log.i("sunny",R.drawable.sunny+"");
            return R.drawable.sunny;

        }

        if (status == 4 || status == 5 || status == 6 || status == 7 || status == 8 || status == 11 || status == 20 || status == 21)
            return R.drawable.cloudy;

        if( ( (status>=12) && (status<=19) ) || status==25 || status==26 || status==29)
            return R.drawable.rainy;

        if(status==22 || status==24)
            return R.drawable.sunny;

        else return R.drawable.night;

    }


}
