package com.sheygam.masa_2017_13_12;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gregorysheygam on 13/12/2017.
 */

public class MyAdapter extends BaseAdapter {

    private ArrayList<String> names = new ArrayList<>();
    public MyAdapter(){
        names.add("Vasya");
        names.add("Petya");
        names.add("Vova");
        names.add("Tanya");
        names.add("Sofa");
        names.add("Dima");
        names.add("Kolya");
        names.add("Masha");
    }
    public void addName(String name){
        names.add(0,name);
        notifyDataSetChanged();
    }

    public void remove(int position){
        names.remove(position);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.my_row,parent,false);
        }
        String name = names.get(position);
        TextView titleTxt = convertView.findViewById(R.id.title_txt);
        titleTxt.setText(name);
        if(position%2 == 0){
            convertView.setBackground(parent.getContext().getResources().getDrawable(R.drawable.row_background));
        }else{
            convertView.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }
}
