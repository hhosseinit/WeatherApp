package com.example.hosseini.weatherappfinal;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends Activity implements MyRecyclerViewAdapter.MyClickListener {

    // Util instance
    Util util;

    // API Instance
    public WeatherAPI api;

    // Array list of all cities with data
    public static ArrayList<City> myCities = new ArrayList();

    // Current Selected City in main activity
    public static City currentCity = null;

    // Recycler view
    private RecyclerView mRecyclerView;

    // List view DataSet
    private ArrayList<RowItem> dataSet = new ArrayList<>();

    // List Adapter
    private RecyclerView.Adapter mAdapter;

    // Shared Preferences
    SharedPreferences appSharedPrefs;

    // type
    private boolean mainType=true;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Init UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initUI();
        setClickHandlers();

        // Init API
        util = new Util(this);
        api = new WeatherAPI(util);

        // Store Cities
        storeCities();

        if (myCities.size() > 0)
            loadCities();

        // Update city current status
        updateCurrents();

    }

    private void initUI() {
        // Init Recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);

        // Data Adapter
        mAdapter = new MyRecyclerViewAdapter(dataSet);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setClickHandlers() {
             LinearLayout add_layer = (LinearLayout) findViewById(R.id.addCircleView);
//        add_layer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SearchActivityClass.class));
//            }
//        });
        add_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivityClass.class));
                finish();
            }
        });

        LinearLayout centigrade_layer = (LinearLayout) findViewById(R.id.c);
        centigrade_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("centigrade",mainType+"");

                if (mainType == false) {
                    mainType = true;
                    Log.i("before centigrade",mainType+"");
//                    finish();
                    //             recreate();
                    refresh();
                    Log.i("after centigrade",mainType+"");
                    //refresh();
                }

            }
        });

        LinearLayout fahrenheit_layer = (LinearLayout) findViewById(R.id.f);
        fahrenheit_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("before farenheite",mainType+"");
                mainType = false;
                //finish();
                refresh();
                //recreate();
                Log.i("after farenheite",mainType+"");

                //refresh();
            }
        });
    }

    public void refresh(){
        onRestart();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        updateItems();
        //  recreate();
//        Intent i = new Intent(MainActivity.this, MainActivity.class);
//        startActivity(i);

        //       finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(this);
    }

    private void storeCities() {

        //    myCities.add(new City(210841, "Tehran"));
//        myCities.add(new City(349727, "NYC"));
//        myCities.add(new City(347625, "Los Angles"));

        appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(myCities);
        prefsEditor.putString("MyArray", json);
        prefsEditor.commit();


    }

    private void loadCities() {

        myCities.clear();


        Gson gson = new Gson();
        String json = appSharedPrefs.getString("MyArray", "");
        Type type = new TypeToken<ArrayList<City>>() {
        }.getType();
        myCities = gson.fromJson(json, type);

        updateItems();
    }

    private void updateCurrents() {

        for (final City city : myCities) {
            api.getConditions(city.locationKey, new ICallback<Current>() {
                public void callback(Current result) throws Exception {
                    city.setCurrent(result);
                    city.type = mainType;
                    updateItems();
                }
            });
        }
    }

    private void updateItems() {
        // Clear Old Items
        dataSet.clear();

        for (City city : this.myCities) {

            //util.getImage(city.getIcon())
            Log.i("icon......... ", "" + city.getIcon());
            RowItem item;
            if (mainType) {
                Log.i("util test image",util.getImage(city.getIcon())+"");
                item = new RowItem(util.getImage(city.getIcon()), city.getCurrentHour(), city.getCurrentTempC(), city.getCityName());
            } else
                item = new RowItem(util.getImage(city.getIcon()), city.getCurrentHour(), city.getCurrentTempF(), city.getCityName());

            dataSet.add(item);
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position, View v) {
        // Current city
        final City city = myCities.get(position);
        city.type=mainType;

        if (city == null || !city.currentLoaded) {
            return;
        }

        MainActivity.currentCity = city;

        Toast.makeText(MainActivity.this, "waiting...", Toast.LENGTH_LONG).show();
        // Async get hours
        api.getHourStatus(city.getLocationKey(), new ICallback<ArrayList<Hourly>>() {
            @Override
            public void callback(ArrayList<Hourly> result) throws Exception {

                // Update Hours
                city.setHours(result);

                // Update Days
                api.getDayStatus(city.getLocationKey(), new ICallback<ArrayList<Daily>>() {
                    @Override
                    public void callback(ArrayList<Daily> result) throws Exception {

                        // Set days
                        city.setDays(result);
                        Intent intent = new Intent(MainActivity.this, DetailCity.class);
                        startActivity(intent);

                    }
                });

            }
        });
    }
}