package com.example.hosseini.weatherappfinal;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hosseini on 7/22/2016.
 */
public class FadeLinear extends LinearLayout {
    Context context;
    LinearLayout firstl;
    TextView tvDegree;
    TextView tvDay;
    TextView tvToday;
    TextView tvMinDegree;
    TextView tvMaxDegree;

    public FadeLinear(Context context, String degreeStr, String dayStr, String todayStr, String mindStr, String maxdStr) {
        super(context);
        this.context = context;

        inflate(context, R.layout.fade_layout, this);
        this.firstl = (LinearLayout) findViewById(R.id.llfirst);
        this.tvDegree = (TextView) findViewById(R.id.degree);
        this.tvDay = (TextView) findViewById(R.id.day);
        this.tvToday = (TextView) findViewById(R.id.today);
        this.tvMaxDegree = (TextView) findViewById(R.id.maxDegree);
        this.tvMinDegree = (TextView) findViewById(R.id.minDegree);

        Log.i("max", maxdStr);

        tvDegree.setText(degreeStr);
        tvDegree.setTextSize(15);
        tvDay.setText(dayStr);
        tvDay.setTextSize(15);
        tvToday.setText(todayStr);
        tvToday.setTextSize(15);
        tvMinDegree.setText(mindStr);
        tvMinDegree.setTextSize(15);
        tvMaxDegree.setText(maxdStr);
        tvMaxDegree.setTextSize(15);

    }
}
