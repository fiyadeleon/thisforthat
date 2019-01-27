package com.example.kenneth.thisforthat;

import android.Manifest;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.kenneth.thisforthat.DatabaseHelper.*;
import static com.example.kenneth.thisforthat.SubBF.missingData;

public class Ingredients extends ListActivity{
    public DatabaseHelper mySQLiteAdapter;
    public Button mDialogyes, mDialogno;

    public static String myString;
    public static String contentRead;
    public static String TABLE_NAME;
    public static Dialog mDialog;

    int buttonValue;
    Cursor cursor;
    SQLiteDatabase dh;
    CustomCursorAdapter myCursorAdapter;
    ContentValues values;
    String data ="";
    String label,quantity;

    //String sql = "INSERT INTO "+ TABLE_USERING +" SELECT _id, name, amount, selected FROM "+ TABLE_BF +" WHERE selected = 0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidContext.setContext(this);
        dh = DatabaseHelper.getInstance().getDb();
        values = new ContentValues();
        createDialog();

        buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));
        mySQLiteAdapter = new DatabaseHelper ();

        if (1 == buttonValue ) {
            bfListView ();
        }else if (2 == buttonValue){
            bmListView ();
        }else if (3 == buttonValue){
            bcListView ();
        }else if (4 == buttonValue){
            ccListView ();
        }else if (5 == buttonValue){
            cmListView ();
        }else if (6 == buttonValue){
            mcListView ();
        }else if (7 == buttonValue){
            rcListView ();
        }else if (8 == buttonValue){
            scListView ();
        }else if (9 == buttonValue){
            umListView ();
        }else if (10 == buttonValue){
            vcListView ();
        }
    }

    public void bfListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_BF, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void bcListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_BC, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void bmListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_BM, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void ccListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_CC, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void cmListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_CM, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void mcListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_MC, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void rcListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_RC, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void scListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_SC, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void umListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_UM, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void vcListView() {
        setContentView(R.layout.activity_ingredients);
        int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));

        cursor = dh.query(TABLE_VC, new String[]{"_id","name","amount","selected"}, null, null, null, null, "name asc");

        startManagingCursor(cursor);
        myCursorAdapter= new CustomCursorAdapter(this,cursor,buttonValue);
        this.getListView().setAdapter(myCursorAdapter);
    }

    protected void createDialog() {
        mDialog = new Dialog (this);
        mDialog.requestWindowFeature (Window.FEATURE_NO_TITLE);
        mDialog.setContentView (R.layout.dialog_exit);

        mDialog.setCanceledOnTouchOutside (true);
        mDialog.setCancelable (true);
        mDialogyes = ( Button ) mDialog.findViewById (R.id.yes);
        mDialogno = ( Button ) mDialog.findViewById (R.id.No);
        mDialogyes.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                int buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));
                if (1 == buttonValue ) {
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameBF();
                    contentRead = mySQLiteAdapter.queueAllBF();
                    mySQLiteAdapter.queueNameBF ();

                    TABLE_NAME = "TABLE_BF";
                    myString = contentRead.replaceAll(" ", "%20");

                }else if (2 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameBM ();
                    contentRead = mySQLiteAdapter.queueAllBM();
                    mySQLiteAdapter.queueNameBM();

                    TABLE_NAME = "TABLE_BM";
                    myString = contentRead.replaceAll(" ", "%20");

                }else if (3 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameBC ();
                    contentRead = mySQLiteAdapter.queueAllBC();
                    mySQLiteAdapter.queueNameBC();

                    TABLE_NAME = "TABLE_BC";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (4 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    contentRead = mySQLiteAdapter.queueAllCC ();
                    mySQLiteAdapter.queueNameCC();

                    TABLE_NAME = "TABLE_CC";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (5 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameCM ();
                    contentRead = mySQLiteAdapter.queueAllCM();
                    mySQLiteAdapter.queueNameCM();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_CM";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (6 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameMC ();
                    contentRead = mySQLiteAdapter.queueAllMC();
                    mySQLiteAdapter.queueNameMC();

                    TABLE_NAME = "TABLE_MC";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (7 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameRC ();
                    contentRead = mySQLiteAdapter.queueAllRC();
                    mySQLiteAdapter.queueNameRC();

                    TABLE_NAME = "TABLE_RC";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (8 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameSC ();
                    contentRead = mySQLiteAdapter.queueAllSC();
                    mySQLiteAdapter.queueNameSC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_SC";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (9 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameUM ();
                    contentRead = mySQLiteAdapter.queueAllUM();
                    mySQLiteAdapter.queueNameUM();

                    TABLE_NAME = "TABLE_UM";
                    myString = contentRead.replaceAll(" ", "%20");


                }else if (10 == buttonValue){
                    //gets the name of the unchecked ingredients and put %20 on every space
                    mySQLiteAdapter.getInstance ();
                    mySQLiteAdapter.queueNameVC ();
                    contentRead = mySQLiteAdapter.queueAllVC();
                    mySQLiteAdapter.queueNameVC();

                    TABLE_NAME = "TABLE_VC";
                    myString = contentRead.replaceAll(" ", "%20");

                }

                startActivity(new Intent (Ingredients.this, SubBF.class));
            }
        });

        mDialogno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
    }

    public void onBackPressed() {
        String sql = "UPDATE " +TABLE_BF+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql1 = "UPDATE " +TABLE_BC+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql2 = "UPDATE " +TABLE_BM+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql3 = "UPDATE " +TABLE_CC+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql4 = "UPDATE " +TABLE_CM+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql5 = "UPDATE " +TABLE_MC+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql6 = "UPDATE " +TABLE_RC+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql7 = "UPDATE " +TABLE_SC+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql8 = "UPDATE " +TABLE_UM+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";
        String sql9 = "UPDATE " +TABLE_VC+ " SET " +KEY_STATUS+ " = 0 WHERE " +KEY_STATUS+ " = 1";

        dh.execSQL (sql);
        dh.execSQL (sql1);
        dh.execSQL (sql2);
        dh.execSQL (sql3);
        dh.execSQL (sql4);
        dh.execSQL (sql5);
        dh.execSQL (sql6);
        dh.execSQL (sql7);
        dh.execSQL (sql8);
        dh.execSQL (sql9);

        startActivity(new Intent (Ingredients.this, MainActivity.class));
    }

    public void clickHandler(View view){

        if(view.getId() == R.id.checkbox){
            cursor.requery(); /* to get the updated values from sqlite on changing the check of checkbox*/
        }
    }

    public void onContinue(View view) {
        mDialog.show();
    }
}