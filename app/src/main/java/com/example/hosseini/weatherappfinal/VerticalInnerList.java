package com.example.hosseini.weatherappfinal;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hosseini on 7/22/2016.
 */
public class VerticalInnerList extends LinearLayout {


    Context context;
    List<DailyRowItem> dailyRowItems;
    ListView listItems;

    public VerticalInnerList(Context context, ArrayList<DayStatus> dayStatusArrayList, Boolean type) {
        super(context);
        this.context = context;

        inflate(context, R.layout.vertical_inner_list, this);
        this.listItems = (ListView) findViewById(R.id.items);
        listItems.getHeight();
        // Log.i("height otem",  listItems.getHeight()+"");
        dailyRowItems = new ArrayList<DailyRowItem>();
        for (int i = 0; i < dayStatusArrayList.size(); i++) {
            DailyRowItem item;
            if (type)
                item = new DailyRowItem(dayStatusArrayList.get(i).getDay(), dayStatusArrayList.get(i).getUnicodeDay(), dayStatusArrayList.get(i).getMinTempC(), dayStatusArrayList.get(i).getMaxTempC());
            else
                item = new DailyRowItem(dayStatusArrayList.get(i).getDay(), dayStatusArrayList.get(i).getUnicodeDay(), dayStatusArrayList.get(i).getMinTempF(), dayStatusArrayList.get(i).getMaxTempF());
            dailyRowItems.add(item);
        }


        DailyArrayAdapter dailyAdapter = new DailyArrayAdapter(context, R.layout.daily_row_item, dailyRowItems);
        listItems.setAdapter(dailyAdapter);

    }


}
