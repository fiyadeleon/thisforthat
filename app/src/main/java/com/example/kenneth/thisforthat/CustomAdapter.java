package com.example.kenneth.thisforthat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private LayoutInflater mInflater;
    List<IngredientsHolder> ingredientsList;

    public CustomAdapter(Context context, List<IngredientsHolder> list)
    {
        super(context,0,list);
        ingredientsList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_ni,parent,false);
            // inflate custom layout called row
            holder = new ViewHolder();
            holder.tv =(TextView ) convertView.findViewById(R.id.textview);

            // initialize textview
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        IngredientsHolder in = (IngredientsHolder)ingredientsList.get(position);
        holder.tv.setText(in.subName);
        // set the name to the text;

        return convertView;

    }

    static class ViewHolder {
        TextView tv;
    }
}