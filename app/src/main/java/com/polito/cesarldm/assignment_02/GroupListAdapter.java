package com.polito.cesarldm.assignment_02;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CesarLdM on 3/4/17.
 */

public class GroupListAdapter extends ArrayAdapter<Group> {
    Context context;
    ArrayList<Group> groups;
    int[] images;

    public GroupListAdapter(Context context, ArrayList<Group> groups) {
        super(context, R.layout.custom_list_item, groups);
        this.context = context;
        this.groups = groups;
    }

    public GroupListAdapter(Context context, ArrayList<Group> groups, int[] images) {
        super(context, R.layout.custom_list_item, groups);
        this.context = context;
        this.groups = groups;
        this.images = images;
    }

    @Override
    public int getCount() {
        return groups.size();

    }



    @Override
    public long getItemId(int position) {
        return groups.indexOf(groups.get(position));
    }

    public class ViewHolder {

        TextView textview;
        TextView textview2;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int p =position;
        if (convertView==null){
            // TODO Auto-generated method stub
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_list_item, null);
        }
        //Otherwise
        ViewHolder holder=new ViewHolder();
        //initialite views
        holder.textview= (TextView) convertView.findViewById(R.id.tvname);
        holder.textview2=(TextView) convertView.findViewById(R.id.tvbudget);
        holder.imageView=(ImageView) convertView.findViewById(R.id.iv1);
        //asign them data
        holder.textview.setText(groups.get(position).getName());
        Double a =groups.get(position).getBudget();
        holder.textview2.setText(a.toString()+"€");
        holder.textview2.setTextColor(ContextCompat.getColor(context, R.color.MoneyGood));
        holder.imageView.setImageResource(images[position]);



        return convertView;
    }
}
