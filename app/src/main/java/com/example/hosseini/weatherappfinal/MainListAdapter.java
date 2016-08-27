package com.example.hosseini.weatherappfinal;

/**
 * Created by zahra on 7/18/2016 AD.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;



import java.util.List;
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyViewHolder> {


    private List<RowItem> cityList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtClock;
        TextView txtDegree;
        TextView txtCityName;

        public MyViewHolder(View view) {
            super(view);
            //   txtClock = (TextView) view.findViewById(R.id.clock_view);
            txtDegree = (TextView) view.findViewById(R.id.degree_view);
            txtCityName = (TextView) view.findViewById(R.id.city_name_view);
        }
    }



//    public MainListAdapter(Context context, int resourceId, List<RowItem> cList) {
//        super(context, resourceId, cList);
//        this.context = context;
//        this.cityList = cList;
//    }


    public MainListAdapter(List<RowItem> cList) {
        this.cityList = cList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RowItem rowItem = cityList.get(position);
        holder.txtClock.setText(rowItem.getClock());
        holder.txtDegree.setText(rowItem.getDegree());
        holder.txtCityName.setText(rowItem.getCity_name());

    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }
}
