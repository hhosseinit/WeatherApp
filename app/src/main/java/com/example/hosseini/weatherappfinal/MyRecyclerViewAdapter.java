package com.example.hosseini.weatherappfinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<RowItem> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        //ImageView imageView;
        RelativeLayout ll;
        TextView txtClock;
        TextView txtDegree;
       // TextFitTextView txtDegree;
       // TextView txtCityName;
        AutoResizeTextView txtCityName;

        public DataObjectHolder(View itemView) {
            super(itemView);
            ll = (RelativeLayout) itemView.findViewById(R.id.llrow);
              txtClock = (TextView) itemView.findViewById(R.id.clock_view);
            txtDegree = (TextView) itemView.findViewById(R.id.degree_view);

            //txtCityName = (TextView) itemView.findViewById(R.id.city_name_view);
            txtCityName = (AutoResizeTextView) itemView.findViewById(R.id.city_name_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);

        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<RowItem> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);


        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.ll.getLayoutParams().height = 200;
        holder.ll.setBackgroundResource(mDataset.get(position).getImageBackground());
        holder.txtClock.setText(mDataset.get(position).getClock());
        holder.txtClock.setTextSize(20);
        holder.txtDegree.setText(mDataset.get(position).getDegree());
        holder.txtCityName.setText(mDataset.get(position).getCity_name());
        holder.txtCityName.setTextSize(25);

    }

    public void addItem(RowItem dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}