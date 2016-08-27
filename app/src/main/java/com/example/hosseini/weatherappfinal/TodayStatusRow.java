package com.example.hosseini.weatherappfinal;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hosseini on 7/22/2016.
 */
public class TodayStatusRow extends LinearLayout {


    Context context;
    private LinearLayout statusLinear;

    public TodayStatusRow(Context context, String statusStr, String curDegree, String highDegree) {
        super(context);
        this.context = context;

        inflate(context, R.layout.each_linear_row, this);
        this.statusLinear = (LinearLayout) findViewById(R.id.row_linear);


        LinearLayout rowLayout=null;
       // TextView statusTV = new TextView(context);
        AutoResizeTextView statusTV = new AutoResizeTextView(context);

        LayoutParams param = new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT,1);


        rowLayout = new LinearLayout(context);
        rowLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams llParam = new LayoutParams
                (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL);

        rowLayout.setLayoutParams(llParam);
        statusLinear.addView(rowLayout, param);

        statusTV.setText("Today: "+statusStr+" today. It is currently "+curDegree+";\n The high will be "+highDegree+".");
    //    statusTV.setTextSize(20);
        statusTV.setTextColor(getResources().getColor(R.color.dataColor));
        statusTV.setGravity(Gravity.CENTER_HORIZONTAL);
        rowLayout.addView(statusTV);

    }
}

