package com.example.hosseini.weatherappfinal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class DailyArrayAdapter extends ArrayAdapter<DailyRowItem> {

    Context context;

    public DailyArrayAdapter(Context context, int resourceId, List<DailyRowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {
        LinearLayout ll;
        TextView txtDay;
        TextView txtChar;
        TextView txtMinD;
        TextView txtMaxD;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        DailyRowItem dailyRowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //  LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.daily_row_item, null);
            holder = new ViewHolder();
            holder.ll = (LinearLayout) convertView.findViewById(R.id.ll);
            holder.txtDay = (TextView) convertView.findViewById(R.id.day);
            holder.txtChar = (TextView) convertView.findViewById(R.id.w_charachter);
            holder.txtMinD = (TextView) convertView.findViewById(R.id.min_degree);
            holder.txtMaxD = (TextView) convertView.findViewById(R.id.max_degree);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        //  holder.ll.getLayoutParams().height = Resources.getSystem().getDisplayMetrics().heightPixels / 10;
//        holder.ll.setWeightSum(10);
//        holder.ll.getLayoutParams().height = 140;
        holder.txtDay.setText(dailyRowItem.getDay());
        holder.txtChar.setText(dailyRowItem.getWcharacter());
        holder.txtMinD.setText(dailyRowItem.getMinDegree());
        holder.txtMaxD.setText(dailyRowItem.getMaxDegree());

//        int heightt = Resources.getSystem().getDisplayMetrics().heightPixels;
//        Log.i("heiii",""+heightt/11);
//        holder.ll.getLayoutParams().height =  heightt/11;


        return convertView;
    }


}
