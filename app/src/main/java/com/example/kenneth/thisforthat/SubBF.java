package com.example.kenneth.thisforthat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.kenneth.thisforthat.Ingredients.*;

public class SubBF extends AppCompatActivity {
    public static List<String> missing = new ArrayList<String>();
    public static List<String[]> missingData = new ArrayList<String[]>();

    BufferedReader br = null;
    TextView data;
    TextView listContent;
    String sCurrentline;
    File file;
    Dialog nDialog;
    Button nDialogyes, nDialogno;
    String findSub;
    int index = 0;
    SQLiteDatabase dh;

    List<String[]> subData = new ArrayList<String[]>();
    List<String> sub = new ArrayList<String>();

    String[][] arrSubData; //string array of all available substitute ingredients
    String[][] arrMissingData; //array for the file ingMissing.csv

    String[] arrMissing; //string array for user's missing ingredients
    String[] arrSub; //array para istore ung mga name ng sub ing specifically each for the main ing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sub_bf);

        //createDialog ();

        data = (TextView) findViewById(R.id.txtSub);
        listContent = (TextView )findViewById(R.id.txtAPI);

        arrMissing = new String[missing.size()];
        missing.toArray(arrMissing);

        arrSub = new String[missing.size()];
        sub.toArray(arrSub);

        missingData.clear ();
        getSubData ();
        getMissingData ();

        listContent.setText (arrMissing[0]);
        findSub = arrMissing[0];

        displaySub ();
        //compareData ();
    }

    private void displaySub(){
        //dito tinatawag ung method for algo
        //System.out.println (arrSubData[1][0]);
        sub.clear ();
        findSub = arrMissing[0];
        for(int i = 0; i < subData.size ()-1; i++) {
            if (findSub.equals(arrSubData[i][0])) {
                //ingredient's name
                biDi ();
                //compareData ();
                break;
            }
        }
    }

    private void getSubData(){
        //kinukuha nitong method na to ung values ng column na name at subname ng mga sub ing
        //tas iniistore sa array list
        try {
            file = new File("/sdcard/"+TABLE_NAME+".csv");
            br = new BufferedReader(new FileReader (file));

            while ((sCurrentline = br.readLine ()) != null) {
                subData.add (sCurrentline.split (","));
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        arrSubData = new String[subData.size()][];
        subData.toArray(arrSubData);
    }

    private void getMissingData(){
        //kinukuha nitong method na to ung values ng column na name at subname ng mga missing ing
        //tas iniistore sa array list
        try {
            String pathName = TABLE_NAME+"/"+arrMissing[0];
            file = new File("/sdcard/"+pathName+".csv");
            br = new BufferedReader(new FileReader (file));

            while ((sCurrentline = br.readLine ()) != null) {
                missingData.add (sCurrentline.split (","));
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        arrMissingData = new String[missingData.size ()][];
        missingData.toArray (arrMissingData);
    }

    public void biDi() {
        int start = 0;
        int end = subData.size()-1;

        int path = 0;
        int index = 0;
        for (int i = 0; (i < (subData.size () / 2)); i++) {
            if (findSub.equals (arrSubData[start][0])) {
                System.out.println ("start " +arrSubData[start+1][1]);
                sub.add(arrSubData[start+1][1]);

            }
            if (findSub.equals (arrSubData[end][0])) {
                System.out.println ("end " +arrSubData[end+1][1]);
                sub.add(arrSubData[end+1][1]);

            }

            start++;
            end--;
            //path++;
        }
        if(sub.size ()!=0){
            data.setText(sub.get (0));
        }else{
            data.setText("No available substitute ingredient");
        }
    }

    private void compareData(){
        int subColLength = arrSubData[0].length;

        int missingColLength = arrMissingData[0].length;
        int missingRowLength = arrMissingData.length;
        int missing = missingColLength-1;

        int startCount = 2;
        int endCount = subColLength - 1;


        System.out.println ("BAKET");
        if(missingColLength==1 && missingRowLength==2) {
            System.out.println ("1");
            for (int i = 0; (i < subColLength / 2); i++) {
                if (arrMissingData[0][0].equals (arrSubData[0][startCount])) {
                    System.out.println ("start " + arrSubData[1][startCount]);
                    sub.add(arrSubData[1][startCount]);
                }
                if (arrMissingData[0][0].equals (arrSubData[0][endCount])) {
                    System.out.println ("end " + arrSubData[1][endCount]);
                }

                startCount++;
                endCount--;
            }
        }else if(missingColLength>1 && missingRowLength==2) {
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
        mDialog.dismiss();
        //nDialog.show ();
        Intent backToHomeActivityIntent = new Intent(SubBF.this, Ingredients.class);
        backToHomeActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(backToHomeActivityIntent);
    }

    public void onSelect(View view){
        for(int i = 1; i < missing.size (); i++) {
            if (missing.size () != 0) {
                findSub = arrMissing[i];
                index = i;

                listContent.setText (arrMissing[i]);
                System.out.println (arrMissing[i]);

                for(int j = 0; j < subData.size ()-1; j++) {
                    if (arrMissing[index].equals(arrSubData[j][0])) {
                        //ingredient's name
                        biDi ();
                        //compareData ();
                        break;
                    }
                }
            } else {
                data.setText ("No available substitute ingredient");
            }
        }
    }

    public void onNext(View view){
        sub.clear ();
        missing.remove (0);
        if(sub.size ()!=0){
            data.setText(sub.get (1));
        }else{
            data.setText("No available substitute ingredient");
        }
    }

    public void onUtensils(View view){

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
                startActivity(new Intent (SubBF.this, MainActivity.class));
            }
        });

        nDialogno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nDialog.dismiss();
            }
        });
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }
}


