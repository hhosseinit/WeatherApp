package com.example.hosseini.weatherappfinal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
/**
 * Created by hosseini on 7/18/2016.
 */
public class SearchActivityClass extends Activity {

    SharedPreferences appSharedPrefs ;

    Util util;
    public WeatherAPI api;
    public ArrayList<SearchResult> searchResultArrayList = new ArrayList<>();
    public static String resultTimezone="?";
    EditText editText;
    Button button;
    String selectedCityName;
    ArrayList<SearchResult> finalresults = new ArrayList<SearchResult>();

    ArrayList<City> myCities;
    ArrayAdapter adapter;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
      //  setContentView(R.layout.activity_main);

        util=new Util(this);
        api=new WeatherAPI(util);

        myCities=MainActivity.myCities;


        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.citylist);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editText.getText().length() > 0) {

                    api.getSearchResult(editText.getText()+"",new ICallback<ArrayList<SearchResult>>() {
                        public void callback(ArrayList<SearchResult> result) throws Exception {
                            for (SearchResult s:result){
                                finalresults.add(s);

                                cityListResult();
                            }
                        }
                    });

                }
            }
        });

    }

    public void cityListResult(){

        adapter = new ArrayAdapter<RowItem>(this, R.layout.search_city_view_row, getDataSetSearch());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                api.getTimeZone(finalresults.get(position).locationKey, new ICallback<TimeZone>() {
                    public void callback(TimeZone result) throws Exception {

                        Toast.makeText(SearchActivityClass.this, "waiting...", Toast.LENGTH_LONG).show();

                        resultTimezone=result.timeZone;
                        storeCities(finalresults.get(position).cityName,finalresults.get(position).locationKey,resultTimezone);
                        Log.i("list click", " goal " + finalresults.get(position).cityName + " key: "+finalresults.get(position).locationKey);
                        refresh();

                    }
                });
//                storeCities(finalresults.get(position).cityName,finalresults.get(position).locationKey);
//                Log.i("list click", " goal " + finalresults.get(position).cityName + " key: "+finalresults.get(position).locationKey);
//                //      finish();
//                refresh();
            }

        });

    }


    public void refresh(){
        onRestart();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Intent i = new Intent(SearchActivityClass.this, MainActivity.class);
        startActivity(i);
        finish();
    }


    private void storeCities(String cityName,int key,String timezone) {

        this.myCities.add(new City(key,cityName,timezone));

        for (int i=0;i<this.myCities.size();i++)
            Log.i("my Cities","timezone: "+this.myCities.get(i).timeZone);

        appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this.myCities);
        prefsEditor.putString("MyArray", json);
        prefsEditor.commit();


    }


    private ArrayList<RowItem> getDataSetSearch() {
        ArrayList results = new ArrayList<RowItem>();
        for (int index = 0; index <finalresults.size(); index++) {
            RowItem obj = new RowItem(R.color.black, " ", " ", finalresults.get(index).cityName);
            Log.i("i", index + "");
            results.add(index, obj);
        }
        return results;
    }


}