package com.example.kenneth.thisforthat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter{

    SQLiteDatabase dh = DatabaseHelper.getInstance().getDb();
    private LayoutInflater mInflater;
    final private Context mContext;
    Cursor cursor;
    ContentValues contentValues = new ContentValues();
    int buttonValue;
    public static CheckBox cb;
    public static ViewHolder holder;

    public CustomCursorAdapter(Context context, Cursor c, int buttonValue) {
        super(context, c);
        // TODO Auto-generated constructor stub
        mInflater = LayoutInflater.from(context);
        mContext = context;
        cursor = c;
        this.buttonValue = buttonValue;

    }

    @Override
    public void bindView(final View view, final Context context, final Cursor cursor) {
        // TODO Auto-generated method stub
        holder =(ViewHolder)view.getTag();

        holder.setTextView((TextView)view.findViewById(R.id.textview));
        holder.setTextView1((TextView)view.findViewById(R.id.textview1));
        holder.setCheckBox((CheckBox)view.findViewById(R.id.checkbox));
        cb = holder.getCheckBox();

        holder.getTextView().setText( cursor.getString(cursor.getColumnIndex("name")));
        holder.getTextView1().setText( cursor.getString(cursor.getColumnIndex("amount")));

        cb.setTag(new Integer(cursor.getPosition()));
        CompoundButton.OnCheckedChangeListener checkedChange = new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub

                Integer currentPosition = (Integer)buttonView.getTag();
                String currentPositionString = Double.toString(currentPosition);
                // Intents are used to communicate between components such as activities.

                if(cursor.moveToPosition(currentPosition))
                {
                    String rowID = cursor.getString(cursor.getColumnIndex("_id"));
                    if(isChecked){
                        contentValues.put("selected", "1");
                        if (1 == buttonValue ) {
                            dh.update(DatabaseHelper.TABLE_BF, contentValues, "_id=?", new String[]{rowID});
                        }else if (2 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_BM, contentValues, "_id=?", new String[]{rowID});
                        }else if (3 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_BC, contentValues, "_id=?", new String[]{rowID});
                        }else if (4 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_CC, contentValues, "_id=?", new String[]{rowID});
                        }else if (5 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_CM, contentValues, "_id=?", new String[]{rowID});
                        }else if (6 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_MC, contentValues, "_id=?", new String[]{rowID});
                        }else if (7 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_RC, contentValues, "_id=?", new String[]{rowID});
                        }else if (8 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_SC, contentValues, "_id=?", new String[]{rowID});
                        }else if (9 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_UM, contentValues, "_id=?", new String[]{rowID});
                        }else if (10 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_VC, contentValues, "_id=?", new String[]{rowID});
                        }
                    }else if(!isChecked){
                        contentValues.put("selected", "0");
                        if (1 == buttonValue ) {
                            dh.update(DatabaseHelper.TABLE_BF, contentValues, "_id=?", new String[]{rowID});
                        }else if (2 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_BM, contentValues, "_id=?", new String[]{rowID});
                        }else if (3 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_BC, contentValues, "_id=?", new String[]{rowID});
                        }else if (4 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_CC, contentValues, "_id=?", new String[]{rowID});
                        }else if (5 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_CM, contentValues, "_id=?", new String[]{rowID});
                        }else if (6 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_MC, contentValues, "_id=?", new String[]{rowID});
                        }else if (7 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_RC, contentValues, "_id=?", new String[]{rowID});
                        }else if (8 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_SC, contentValues, "_id=?", new String[]{rowID});
                        }else if (9 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_UM, contentValues, "_id=?", new String[]{rowID});
                        }else if (10 == buttonValue){
                            dh.update(DatabaseHelper.TABLE_VC, contentValues, "_id=?", new String[]{rowID});
                        }
                    }
                }
            }
        };
        cb.setOnCheckedChangeListener(checkedChange);

        if(cursor.getString(cursor.getColumnIndex("selected")).compareTo("1")==0) {
            cb.setChecked(true);
        }
        else{
            cb.setChecked(false);
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        View convertView = mInflater.inflate(R.layout.custom, parent,false);
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);

        return convertView;
    }

}