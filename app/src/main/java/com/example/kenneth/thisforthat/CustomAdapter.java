package com.example.kenneth.thisforthat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CustomAdapter<T> extends BaseAdapter{
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<T> mList;
    SparseBooleanArray mSparseBooleanArray;

    ContentValues values;
    String sCurrentline;

    List<String> onhandList = new ArrayList<String>();

    public CustomAdapter(Context context, ArrayList<T> list) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mSparseBooleanArray = new SparseBooleanArray();
        mList = new ArrayList<T>();
        this.mList = list;
    }

    public ArrayList<T> getCheckedItems() {
        ArrayList<T> mTempCheckedArry = new ArrayList<T>();
        List<String> onhand = new ArrayList<> ();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        final int getIndex = sp.getInt ("Index", 0);
        final String getName = sp.getString ("btnName", "");

        for(int i = 0; i < mList.size(); i++) {
            if(mSparseBooleanArray.get(i)) {
                mTempCheckedArry.add(mList.get(i));
            }
        }

        onhand.clear ();
        for(int i = 0; i < mTempCheckedArry.size(); i++) {
            onhand.add (String.valueOf (mTempCheckedArry.get(i)));
        }

        try {
            File file = new File("/sdcard/"+getName+".csv");
            BufferedReader br = new BufferedReader(new FileReader (file));
            while((sCurrentline = br.readLine()) != null ) {
                String[] col = sCurrentline.split (",");
                onhandList.add (col[1]);
            }

            System.out.println (mTempCheckedArry.size ());

            for (int i = 0; i < onhandList.size (); i++) {
                for (int j = 0; j < onhand.size (); j++) {
                    if (onhandList.get (i).equals (onhand.get (j))) {
                        CSVReader reader = new CSVReader (new FileReader("/sdcard/"+getName+".csv"), ',');
                        List<String[]> csvBody = reader.readAll();
                        int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                        csvBody.get(i)[getIndex] = String.valueOf (convert);
                        reader.close();

                        CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/"+getName+".csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                        writer.writeAll(csvBody);
                        writer.flush();
                        writer.close();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mTempCheckedArry;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_ni, null);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.textview);
        tvTitle.setText(mList.get(position).toString());
        CheckBox mCheckBox = (CheckBox) convertView.findViewById(R.id.checkbox);
        mCheckBox.setTag(position);
        mCheckBox.setChecked(mSparseBooleanArray.get(position));
        mCheckBox.setOnCheckedChangeListener(mCheckedChangeListener);

        return convertView;
    }

    OnCheckedChangeListener mCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mSparseBooleanArray.put((Integer) buttonView.getTag(), isChecked);
        }
    };
}
