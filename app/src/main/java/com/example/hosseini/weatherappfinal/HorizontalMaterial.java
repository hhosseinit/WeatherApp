package com.example.hosseini.weatherappfinal;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hosseini on 7/22/2016.
 */
public class HorizontalMaterial extends LinearLayout {
    Context context;
    private LinearLayout hLinear;

    public HorizontalMaterial(Context context, ArrayList<HourStatus> hourStatusArrayList, Boolean type) {
        super(context);
        this.context = context;

        inflate(context, R.layout.horizontal_material_layout, this);
        this.hLinear = (LinearLayout) findViewById(R.id.hrz);


        int count=hourStatusArrayList.size();

        LinearLayout rowLayout=null;
        TextView[] tvTime = new TextView[count];
        TextView[] tvChar = new TextView[count];
        TextView[] tvDegree = new TextView[count];

        LayoutParams param = new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT,1);
        param.setMargins(20, 0, 20, 0);
        for (int i = 0; i<count; i++)
        {

            HourStatus s= hourStatusArrayList.get(i);

            rowLayout = new LinearLayout(context);
            rowLayout.setOrientation(LinearLayout.VERTICAL);
            rowLayout.setWeightSum(count);
            LayoutParams llParam = new LayoutParams
                    (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL);

            rowLayout.setLayoutParams(llParam);
            hLinear.addView(rowLayout, param);

            tvTime[i]= new TextView(context);
            tvTime[i].setText(s.getHour());
            tvTime[i].setTextColor(getResources().getColor(R.color.dataColor));
            tvTime[i].setGravity(Gravity.CENTER_HORIZONTAL);
            rowLayout.addView(tvTime[i]);

            tvChar[i] = new TextView(context);
            tvChar[i].setText(s.getUnicodeHour());
            tvChar[i].setGravity(Gravity.CENTER_HORIZONTAL);
            tvChar[i].setPadding(0, 20, 0, 0);
            rowLayout.addView(tvChar[i]);

            tvDegree[i] = new TextView(context);

            if(type)
            {tvDegree[i].setText(s.getTempC()+"\u00B0");}
            else tvDegree[i].setText(s.getTempF()+"\u00B0");
            tvDegree[i].setGravity(Gravity.CENTER_HORIZONTAL);
            tvDegree[i].setTextColor(getResources().getColor(R.color.dataColor));
            tvDegree[i].setPadding(0,20,0,0);
            rowLayout.addView(tvDegree[i]);

        }

    }
}
