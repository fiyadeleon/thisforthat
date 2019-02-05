package com.example.kenneth.thisforthat;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.kenneth.thisforthat.DatabaseHelper.*;

public class Ingredients extends ListActivity{
    Cursor cursor;
    SQLiteDatabase dh;
    CustomCursorAdapter myCursorAdapter;
    ContentValues values;
    public DatabaseHelper mySQLiteAdapter;
    public static String TABLE_NAME;
    int buttonValue;
    public static Dialog mDialog;
    public Button mDialogyes, mDialogno;
    String sCurrentline;
    int index = 0;

    List<String> onhandList = new ArrayList<String>();
    String[] arrOnhandList;

    List<Integer> checkFreq = new ArrayList<> ();

    List<String[]> mainIng = new ArrayList<String[]> ();
    String[][] arrMainIng;

    List<String[]> subIng = new ArrayList<String[]> ();
    String[][] arrSubIng;

    List<String> tempIng = new ArrayList<String> ();
    String[] arrTempIng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidContext.setContext(this);
        dh = DatabaseHelper.getInstance().getDb();
        values = new ContentValues();

        checkUser();
        createDialog();
        display ();
    }

    public void checkUser(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sp.getString("Username", "");

        try {
            File file = new File("/sdcard/TABLE_BF.csv");
            BufferedReader br = new BufferedReader(new FileReader (file));
            sCurrentline = br.readLine ();
            String[] col = sCurrentline.split (",");

            for (int i = 0; i < col.length; i++) {
                //check kung nasa header ba ung username ng gumagamit na user then kukunin ung index
                if (col[i].equals (name)) {
                    index = i;
                }
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt ("Index", index);
        editor.commit();
    }

    public void display(){
        buttonValue = Integer.valueOf(getIntent ().getStringExtra("yourcode"));
        BufferedReader br;

        if (1 == buttonValue ) {
            File file = new File("/sdcard/TABLE_BF.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        bfListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (2 == buttonValue){
            File file = new File("/sdcard/TABLE_BM.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        bmListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (3 == buttonValue){
            File file = new File("/sdcard/TABLE_BC.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        bcListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (4 == buttonValue){
            File file = new File("/sdcard/TABLE_CC.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        ccListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (5 == buttonValue){
            File file = new File("/sdcard/TABLE_CM.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        cmListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (6 == buttonValue){
            File file = new File("/sdcard/TABLE_MC.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        mcListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (7 == buttonValue){
            File file = new File("/sdcard/TABLE_RC.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        rcListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (8 == buttonValue){
            File file = new File("/sdcard/TABLE_SC.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        scListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (9 == buttonValue){
            File file = new File("/sdcard/TABLE_UM.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        umListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }else if (10 == buttonValue){
            File file = new File("/sdcard/TABLE_VC.csv");

            try {
                String[] checkCol;
                br = new BufferedReader (new FileReader (file));
                sCurrentline = br.readLine ();
                //check lahat nung lines sa csv file
                while ((sCurrentline = br.readLine ()) != null) {
                    checkCol = sCurrentline.split (",");
                    //then iistore ung naread na data sa csv na nasa column[i]
                    checkFreq.add (Integer.valueOf (checkCol[index]));
                }

                for (Integer s : checkFreq) {
                    if(s.equals(checkFreq.get(0))) {
                        System.out.println ("puro zero");
                        vcListView ();
                    }else{
                        startActivity(new Intent (Ingredients.this, NewIngredients.class));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    protected void createDialog() {
        checkUser ();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        final int getIndex = sp.getInt ("Index", 0);

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
                onhandList.clear ();
                onhand.clear ();

                if (1 == buttonValue ) {
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllBF();
                    mySQLiteAdapter.queueNameBF();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_BF";

                    try {
                        File file = new File("/sdcard/TABLE_BF.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_BF.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_BF.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (2 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllBM();
                    mySQLiteAdapter.queueNameBM();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_BM";

                    try {
                        File file = new File("/sdcard/TABLE_BM.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_BM.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_BM.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (3 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllBC();
                    mySQLiteAdapter.queueNameBC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_BC";

                    try {
                        File file = new File("/sdcard/TABLE_BC.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_BC.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_BC.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (4 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllCC ();
                    mySQLiteAdapter.queueNameCC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_CC";

                    try {
                        File file = new File("/sdcard/TABLE_CC.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_CC.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_CC.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (5 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllCM();
                    mySQLiteAdapter.queueNameCM();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_CM";

                    try {
                        File file = new File("/sdcard/TABLE_CM.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_CM.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_CM.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (6 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllMC();
                    mySQLiteAdapter.queueNameMC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_MC";

                    try {
                        File file = new File("/sdcard/TABLE_MC.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_MC.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_MC.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (7 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllRC();
                    mySQLiteAdapter.queueNameRC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_RC";

                    try {
                        File file = new File("/sdcard/TABLE_RC.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_RC.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_RC.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (8 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllSC();
                    mySQLiteAdapter.queueNameSC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_SC";

                    try {
                        File file = new File("/sdcard/TABLE_SC.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_SC.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_SC.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (9 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllUM();
                    mySQLiteAdapter.queueNameUM();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_UM";

                    try {
                        File file = new File("/sdcard/TABLE_UM.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_UM.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_UM.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (10 == buttonValue){
                    mySQLiteAdapter = new DatabaseHelper ();
                    mySQLiteAdapter.getInstance ();
                    String contentRead = mySQLiteAdapter.queueAllVC();
                    mySQLiteAdapter.queueNameVC();
                    mySQLiteAdapter.close();

                    TABLE_NAME = "TABLE_VC";

                    try {
                        File file = new File("/sdcard/TABLE_VC.csv");
                        BufferedReader br = new BufferedReader(new FileReader (file));
                        while((sCurrentline = br.readLine()) != null ) {
                            String[] col = sCurrentline.split (",");
                            onhandList.add (col[1]);
                        }
                        for (int i = 0; i < onhandList.size (); i++) {
                            for (int j = 0; j < onhand.size (); j++) {
                                if (onhandList.get (i).equals (onhand.get (j))) {
                                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_VC.csv"), ',');
                                    List<String[]> csvBody = reader.readAll();
                                    int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                    csvBody.get(i)[getIndex] = String.valueOf (convert);
                                    reader.close();

                                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_VC.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                    writer.writeAll(csvBody);
                                    writer.flush();
                                    writer.close();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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