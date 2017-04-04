package com.polito.cesarldm.assignment_02;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CesarLdM on 3/4/17.
 */

public class ExpensesListAdapter extends ArrayAdapter<Expenses> {
    Context context;
    ArrayList<Expenses> exp;


    public ExpensesListAdapter(Context context,ArrayList<Expenses> exp) {
       super(context,R.layout.custom_list_item,exp);
        this.context = context;
        this.exp = exp;
    }


    @Override
    public int getCount() {
        return exp.size();

    }

   


    @Override
    public long getItemId(int position) {
        return exp.indexOf(exp.get(position));
    }

    public class ViewHolder {

        TextView textview;
        TextView textview2;
        EditText edittext1;
        EditText edittext2;

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
       ExpensesListAdapter.ViewHolder holder=new ExpensesListAdapter.ViewHolder();
        //initialite views
        holder.textview= (TextView) convertView.findViewById(R.id.tvname);
        holder.textview2=(TextView) convertView.findViewById(R.id.tvbudget);
        holder.edittext1=(EditText)convertView.findViewById(R.id.etname);
        holder.edittext2=(EditText)convertView.findViewById(R.id.etcost);
        //asign them data

        holder.textview.setText(exp.get(position).getName());
        double a =exp.get(position).getCost();
        holder.textview2.setText(String.valueOf(a)+"€");
        holder.textview2.setTextColor(ContextCompat.getColor(context, R.color.MoneyGood));




        return convertView;
    }
}
