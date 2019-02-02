package com.example.kenneth.thisforthat;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.kenneth.thisforthat.DatabaseHelper.*;
import static com.example.kenneth.thisforthat.Ingredients.*;

public class SubBF extends AppCompatActivity {
    public static List<String> missing = new ArrayList<String> ();
    public static List<String[]> missingData = new ArrayList<String[]> ();

    BufferedReader br = null;
    TextView data;
    TextView listContent;
    String sCurrentline;
    File file;
    Dialog nDialog;
    Button nDialogyes, nDialogno;

    List<String[]> subData = new ArrayList<String[]> ();
    List<String> sub = new ArrayList<String> ();
    List<String> category = new ArrayList<String> ();

    String[][] arrSubData; //string array of all available substitute ingredients
    String[][] arrMissingData; //array for the file ingMissing.csv

    String[] arrMissing; //string array for user's missing ingredients
    String[] arrSub; //array para istore ung mga name ng sub ing specifically each for the main ing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sub_bf);

        Button buttonDone = ( Button ) findViewById (R.id.btnDone);
        buttonDone.setEnabled (true);

        createDialog ();

        data = ( TextView ) findViewById (R.id.txtData);
        listContent = ( TextView ) findViewById (R.id.txtAPI);

        arrMissing = new String[missing.size ()];
        missing.toArray (arrMissing);
        System.out.println (missing.size ());

        arrOnhand = new String[onhand.size ()];
        onhand.toArray (arrOnhand);

        arrSub = new String[missing.size ()];
        sub.toArray (arrSub);

        getSubData ();
        //getMissingData ();

        //displaySub ();
        //compareData ();
    }

    private void displaySub() {
        listContent.setText (arrMissing[0]);

        ListView listView = ( ListView ) findViewById (R.id.listViewExample);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_multiple_choice, sub);
        listView.setAdapter (arrayAdapter);
    }

    private void getSubData() {
        //kinukuha nitong method na to ung values ng column na name at subname ng mga sub ing
        //tas iniistore sa array list

        try {
            file = new File ("/sdcard/" + TABLE_NAME + ".csv");
            br = new BufferedReader (new FileReader (file));

            while ((sCurrentline = br.readLine ()) != null) {
                subData.add (sCurrentline.split (","));
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        arrSubData = new String[subData.size ()][];
        subData.toArray (arrSubData);

        System.out.println (subData.size ());
        biDi ();
    }

    private void getMissingData() {
        //kinukuha nitong method na to ung values ng column na name at subname ng mga missing ing
        //tas iniistore sa array list
        try {
            String pathName = TABLE_NAME + "/" + arrMissing[0];
            file = new File ("/sdcard/" + pathName + ".csv");
            if (file.exists ()) {
                br = new BufferedReader (new FileReader (file));

                sCurrentline = br.readLine ();
                sCurrentline = br.readLine ();
                while ((sCurrentline = br.readLine ()) != null) {
                    missingData.add (sCurrentline.split (","));
                }

                displaySub ();
            } else {
                data.setText ("No available substitute ingredient");
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        arrMissingData = new String[missingData.size ()][];
        missingData.toArray (arrMissingData);
    }

    public void biDi() {
        int start = 0;
        int end = subData.size () - 1;

        for (int j = 0; (j < (subData.size () / 2)); j++) {
            System.out.println ("missing "+ missing.get (0));
            System.out.println ("start1 " + arrSubData[start][1]);
            System.out.println ("end1 " + arrSubData[end][1]);
            if ((missing.get (0).trim()).equals (arrSubData[start][1])) {
                System.out.println ("pumasok start");
                System.out.println ("start " + arrSubData[start][0]);
                String cat = arrSubData[start][0];
                try {
                    file = new File ("/sdcard/" + TABLE_NAME + ".csv");
                    br = new BufferedReader (new FileReader (file));

                    while ((sCurrentline = br.readLine ()) != null) {
                        String[] col = (sCurrentline.split (","));
                        if (cat.equals (col[0])) {
                            System.out.println ("start1 " + col[1]);
                            sub.add (col[1]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace ();
                }

            }
            if ((missing.get (0).trim()).equals (arrSubData[end][1])) {
                System.out.println ("pumasok end");
                System.out.println ("end " + arrSubData[end][1]);
                String cat = arrSubData[end][0];
                try {
                    file = new File ("/sdcard/" + TABLE_NAME + ".csv");
                    br = new BufferedReader (new FileReader (file));

                    while ((sCurrentline = br.readLine ()) != null) {
                        String[] col = (sCurrentline.split (","));
                        if (cat.equals (col[0])) {
                            System.out.println ("end1 " + col[1]);
                            sub.add (col[1]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }

            start++;
            end--;
        }

        displaySub ();
    }

    private void compareData() {
        int subColLength = arrSubData[0].length;

        int missingColLength = arrMissingData[0].length;
        int missingRowLength = arrMissingData.length;
        int missing = missingColLength - 1;

        int startCount = 2;
        int endCount = subColLength - 1;


        System.out.println ("BAKET");
        if (missingColLength == 1 && missingRowLength == 2) {
            System.out.println ("1");
            for (int i = 0; (i < subColLength / 2); i++) {
                if (arrMissingData[0][0].equals (arrSubData[0][startCount])) {
                    System.out.println ("start " + arrSubData[1][startCount]);
                    sub.add (arrSubData[1][startCount]);
                }
                if (arrMissingData[0][0].equals (arrSubData[0][endCount])) {
                    System.out.println ("end " + arrSubData[1][endCount]);
                }

                startCount++;
                endCount--;
            }
        } else if (missingColLength > 1 && missingRowLength == 2) {
            System.out.println ("2");
            for (int j = 0; (j < missingColLength - 1); j++) {
                String findStart = arrMissingData[0][j];
                String findEnd = arrMissingData[0][missing];

                for (int i = 0; (i < subColLength / 2); i++) {
                    if (findStart.equals (arrSubData[0][startCount + i])) {
                        System.out.println ("start " + arrSubData[0][startCount + i]);
                    }
                    if (findEnd.equals (arrSubData[0][endCount - i])) {
                        System.out.println ("end " + arrSubData[0][endCount - i]);
                    }

                }

                missing--;
            }
        }
    }

    public void onBackPressed() {
        mDialog.dismiss ();
        nDialog.show ();
    }

    protected void createDialog() {
        nDialog = new Dialog (this);
        nDialog.requestWindowFeature (Window.FEATURE_NO_TITLE);
        nDialog.setContentView (R.layout.dialog_back);

        nDialog.setCanceledOnTouchOutside (true);
        nDialog.setCancelable (true);
        nDialogyes = ( Button ) nDialog.findViewById (R.id.yes);
        nDialogno = ( Button ) nDialog.findViewById (R.id.No);
        nDialogyes.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                startActivity (new Intent (SubBF.this, MainActivity.class));
            }
        });

        nDialogno.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                nDialog.dismiss ();
            }
        });
    }

    public void onDone(View view){
        startActivity(new Intent (SubBF.this, MainActivity.class));
    }

    public void onNext(View view){/*
        try {
            File file = new File("/sdcard/TABLE_BF.csv");
            BufferedReader br = new BufferedReader(new FileReader (file));
            while((sCurrentline = br.readLine()) != null ) {
                String[] col = sCurrentline.split (",");
                onhandList.add (col[1]);
            }
            for (int i = 0; i < onhandList.size (); i++) {
                System.out.println (onhandList.get (i));
                System.out.println (subList.get (0));
                if (onhandList.get (i).equals (subList.get (0))) {
                    CSVReader reader = new CSVReader (new FileReader("/sdcard/TABLE_BF.csv"), ',');
                    //niread nya buong csv file
                    List<String[]> csvBody = reader.readAll();
                    //kinuha nya ung index na nakalaan para sa user at nag add ng isa
                    //for everytime na meron si user nung ingredient
                    int convert = Integer.parseInt (csvBody.get(i)[3]) + 1;

                    //cinonvert ulit sa string para isave
                    csvBody.get(i)[3] = String.valueOf(convert);
                    reader.close();

                    CSVWriter writer = new CSVWriter(new FileWriter ("/sdcard/TABLE_BF.csv"), ',');
                    writer.writeAll(csvBody);
                    writer.flush();
                    writer.close();
                }

            }

            getSubData ();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        getSubData ();
    }

}



