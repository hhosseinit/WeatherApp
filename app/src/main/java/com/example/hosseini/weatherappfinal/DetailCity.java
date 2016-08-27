package com.example.hosseini.weatherappfinal;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.example.hosseini.weatherappfinal.CustomLinearLayout;
import com.example.hosseini.weatherappfinal.R;
import com.example.hosseini.weatherappfinal.MainActivity;
import com.example.hosseini.weatherappfinal.MainListAdapter;
import com.example.hosseini.weatherappfinal.RowAdapter;
import com.example.hosseini.weatherappfinal.Util;
import com.example.hosseini.weatherappfinal.City;

/**
 * Created by hosseini on 7/22/2016.
 */
public class DetailCity extends Activity implements OnItemClickListener {


    ListView listViewItems;

    private String currentStatus;
    private String currentHour;
    private String currentTemp;
    private String currentDay;

    private String currentDayMinTempC;
    private String currentDayMaxTempC;
    private String currentDayMinTempF;
    private String currentDayMaxTempF;


    private String humidity;
    private String wind;
    private String feelC;
    private String feelF;
    private String pressure;
    private String precipitation;
    private String visibility;
    private String uv;

    private String sunrise;
    private String sunset;
    private String rain;
    private String[] pars;

    private RelativeLayout rl;
    private City city;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_detail);

        listViewItems = (ListView) findViewById(R.id.lvItems);
        ArrayList<CustomLinearLayout> arrayOfRows = new ArrayList<CustomLinearLayout>();

        this.city = MainActivity.currentCity;

        rl = (RelativeLayout) findViewById(R.id.rel);
        TextView cityName = (TextView) findViewById(R.id.cityname);
        TextView status = (TextView) findViewById(R.id.status);

        cityName.setText(city.getCityName());
        status.setText(city.getCurrentStatus());
        rl.setBackground(getResources().getDrawable(city.getImageBack()));


        int heightt = Resources.getSystem().getDisplayMetrics().heightPixels;
//0

        FadeLinear fadeLinear;
        if (city.type) {
            fadeLinear = new FadeLinear(this, city.getCurrentTempC() + " \u00b0", city.getCurrentDay(), "Today", city.getCurrentDayMinTempC() + " \u00b0", city.getCurrentDayMaxTempC() + " \u00b0");
        } else
            fadeLinear = new FadeLinear(this, city.getCurrentTempF() + " \u00b0", city.getCurrentDay(), "Today", city.getCurrentDayMinTempF() + " \u00b0", city.getCurrentDayMaxTempF() + " \u00b0");

        /////


        CustomLinearLayout customLinearLayout0 = new CustomLinearLayout(fadeLinear, (Resources.getSystem().getDisplayMetrics().heightPixels) / 7);
        arrayOfRows.add(customLinearLayout0);
//1//
        HorizontalMaterial horizontalMaterial = new HorizontalMaterial(this, city.getHourStatusArrayList(),city.type);
        CustomLinearLayout customLinearLayout1 = new CustomLinearLayout(horizontalMaterial, Resources.getSystem().getDisplayMetrics().heightPixels / 7);
        arrayOfRows.add(customLinearLayout1);
//2

        VerticalInnerList verticalInnerList = new VerticalInnerList(this, city.getDayStatusArrayList(),city.type);
        CustomLinearLayout customLinearLayout2 = new CustomLinearLayout(verticalInnerList, (Resources.getSystem().getDisplayMetrics().heightPixels) / 2);
        arrayOfRows.add(customLinearLayout2);

//3
        TodayStatusRow todayStatusRow;
        if (city.type) {
            todayStatusRow = new TodayStatusRow(this, city.getCurrentStatus(), city.getCurrentTempC() + " \u00b0", city.getCurrentDayMaxTempC() + " \u00b0");
        } else
            todayStatusRow = new TodayStatusRow(this, city.getCurrentStatus(), city.getCurrentTempF() + " \u00b0", city.getCurrentDayMaxTempF() + " \u00b0");

        ///

        CustomLinearLayout customLinearLayout4 = new CustomLinearLayout(todayStatusRow, Resources.getSystem().getDisplayMetrics().heightPixels / 6);
        arrayOfRows.add(customLinearLayout4);
//4
        DetailsWeather detailsWeather = new DetailsWeather(this, city.getHumidity(), city.getWind(), city.getFeelC(), city.getPrecipitation(), city.getPressure(), city.getVisibility(), city.getUv());
        CustomLinearLayout customLinearLayout3 = new CustomLinearLayout(detailsWeather, Resources.getSystem().getDisplayMetrics().heightPixels / 2);
        arrayOfRows.add(customLinearLayout3);

        RowAdapter adapter = new RowAdapter(this, R.layout.list_item, arrayOfRows);
        listViewItems.setAdapter(adapter);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(), "Item " + (position + 1) + ": ",// + dailyRowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
