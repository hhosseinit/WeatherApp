package com.example.hosseini.weatherappfinal;

import java.util.List;
// import com.theopentutorials.android.R;
// import com.theopentutorials.android.beans.RowItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

    Context context;

    public CustomListViewAdapter(Context context, int resourceId, List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {
        //ImageView imageView;
        TextView txtClock;
        TextView txtDegree;
        TextView txtCityName;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //  LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            //  holder.txtClock = (TextView) convertView.findViewById(R.id.clock_view);
            holder.txtDegree = (TextView) convertView.findViewById(R.id.degree_view);
            holder.txtCityName = (TextView) convertView.findViewById(R.id.city_name_view);
            //  holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtClock.setText(rowItem.getClock());
        holder.txtDegree.setText(rowItem.getDegree());
        holder.txtCityName.setText(rowItem.getCity_name());

        return convertView;
    }
}