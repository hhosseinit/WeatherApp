package com.example.hosseini.weatherappfinal;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hosseini on 7/22/2016.
 */
public class DetailsWeather extends LinearLayout {


    Context context;
    private LinearLayout endLinear;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20;

    public DetailsWeather(Context context, String stv14, String stv15,
                          String stv16, String stv17, String stv18, String stv19, String stv20) {
        super(context);
        this.context = context;

        inflate(context, R.layout.details_weahther_layout, this);
        this.endLinear = (LinearLayout) findViewById(R.id.llend);

//        this.tv1 = (TextView) findViewById(R.id.tv1);
//        this.tv2 = (TextView) findViewById(R.id.tv2);
//        this.tv3 = (TextView) findViewById(R.id.tv3);
        this.tv4 = (TextView) findViewById(R.id.tv4);
        this.tv5 = (TextView) findViewById(R.id.tv5);
        this.tv6 = (TextView) findViewById(R.id.tv6);
        this.tv7 = (TextView) findViewById(R.id.tv7);
        this.tv8 = (TextView) findViewById(R.id.tv8);
        this.tv9 = (TextView) findViewById(R.id.tv9);
        this.tv10 = (TextView) findViewById(R.id.tv10);

//        this.tv11 = (TextView) findViewById(R.id.tv11);
//        this.tv12 = (TextView) findViewById(R.id.tv12);
//        this.tv13 = (TextView) findViewById(R.id.tv13);
        this.tv14 = (TextView) findViewById(R.id.tv14);
        this.tv15 = (TextView) findViewById(R.id.tv15);
        this.tv16 = (TextView) findViewById(R.id.tv16);
        this.tv17 = (TextView) findViewById(R.id.tv17);
        this.tv18 = (TextView) findViewById(R.id.tv18);
        this.tv19 = (TextView) findViewById(R.id.tv19);
        this.tv20 = (TextView) findViewById(R.id.tv20);


//        tv11.setText(stv11);
//        tv12.setText(stv12);
//        tv13.setText(stv13);
        tv14.setText(stv14);
        tv14.setTextSize(15);
        tv15.setText(stv15);
        tv15.setTextSize(15);
        tv16.setText(stv16);
        tv16.setTextSize(15);
        tv17.setText(stv17);
        tv17.setTextSize(15);
        tv18.setText(stv18);
        tv18.setTextSize(15);
        tv19.setText(stv19);
        tv19.setTextSize(15);
        tv20.setText(stv20);
        tv20.setTextSize(15);

    }
}
