package com.example.kenneth.thisforthat;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewIngredients extends AppCompatActivity {
    public Button mDialogyes, mDialogno;

    public static String TABLE_NAME;
    public static Dialog mDialog;

    int buttonValue;
    Cursor cursor;
    ContentValues values;
    String data = "";
    String sCurrentline;
    boolean found = false;
    int index = 0;
    ListView listView;

    List<String> ingList = new ArrayList<String> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_new_ingredients);
        values = new ContentValues ();

        listView = ( ListView ) findViewById (R.id.listView);
        ingList.add ("1 1/4 tablespoon wheat flour and 3/4 tablespoon cake flour");
        ingList.add ("1/4 teaspoon of baking soda and 1/2 cup of plain yogurt");
        ingList.add ("1 cup brewed coffee");
        ingList.add ("2 teaspoons baking soda");
        ingList.add ("1/2 cup cherry liqueur");
        ingList.add ("1/2 cup cherry extra");
        ingList.add ("2 pieces egg");
        ingList.add ("1 cup milk");
        ingList.add ("1 tablespoon vinegar");
        ingList.add ("2 cups white sugar");
        ingList.add ("3/4 cup unsweetened cocoa powder");
        ingList.add ("1/2 teaspoon salt");
        ingList.add ("1/2 cup vegetable oil");
        ingList.add ("1 teaspoon vanilla extract");
        ingList.add ("1 can cherry pie filling");

        listView();
    }

    public void listView(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_multiple_choice, ingList);
        listView.setAdapter (arrayAdapter);
    }

    public void onContinue(View view){
        startActivity(new Intent (NewIngredients.this, MainActivity.class));
    }

    public void onBackPressed(){
        startActivity(new Intent (NewIngredients.this, MainActivity.class));
    }

}