package com.example.hosseini.weatherappfinal;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RowAdapter extends ArrayAdapter<CustomLinearLayout> {


//    public RowAdapter(Context context, ArrayList<CustomLinearLayout> informations) {
//        super(context, 0, informations);
//    }

    Context context;

    public RowAdapter(Context context, int resourceId, List<CustomLinearLayout> items) {
        super(context, resourceId, items);
        this.context = context;
    }


    private static class ViewHolder {
        LinearLayout rowInfo;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        CustomLinearLayout customLinearLayout = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);




        if (convertView == null) {

            convertView = inflater.inflate(R.layout.each_linear_row, null);
            viewHolder = new ViewHolder();
            viewHolder.rowInfo = (LinearLayout) convertView.findViewById(R.id.row_linear);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.rowInfo.removeAllViews();
        viewHolder.rowInfo.addView(customLinearLayout.rowInformation);
        viewHolder.rowInfo.getLayoutParams().height = (int) customLinearLayout.heightLinear;


        return convertView;
    }
}
