package com.example.kenneth.thisforthat;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.kenneth.thisforthat.NewIngredients.*;

public class NewSubBF extends AppCompatActivity {

    BufferedReader br = null;
    TextView data;
    TextView listContent;
    String sCurrentline;
    File file;
    Dialog nDialog;
    Button nDialogyes, nDialogno;

    List<String[]> subData = new ArrayList<String[]> ();
    List<String> sub = new ArrayList<String> ();
    List<String> onhandList = new ArrayList<String> ();
    List<String> subList = new ArrayList<String> ();

    String[][] arrSubData;

    String[] arrSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sub_bf);

        Button buttonDone = ( Button ) findViewById (R.id.btnDone);
        Button buttonNext = ( Button ) findViewById (R.id.btnNext);
        buttonDone.setVisibility(View.GONE);
        buttonNext.setVisibility(View.VISIBLE);

        createDialog ();

        data = ( TextView ) findViewById (R.id.txtData);
        listContent = ( TextView ) findViewById (R.id.txtAPI);

        arrSub = new String[newMissing.size ()];
        sub.toArray (arrSub);

        listContent.setText (String.valueOf (newMissing.get(0)));
        getSubData ();
    }

    private void getSubData() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(NewSubBF.this);
        final String getName = sp.getString ("btnName", "");

        subData.clear ();
        try {
            file = new File ("/sdcard/" + getName + ".csv");
            br = new BufferedReader (new FileReader (file));

            sCurrentline = br.readLine ();
            while ((sCurrentline = br.readLine ()) != null) {
                subData.add (sCurrentline.split (","));
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        arrSubData = new String[subData.size ()][];
        subData.toArray (arrSubData);

        biDi ();
    }

    public void biDi() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(NewSubBF.this);
        final String getName = sp.getString ("btnName", "");

        int start = 0;
        int end = subData.size () - 1;

        sub.clear ();
        for (int j = 0; (j < (subData.size () / 2)+1); j++) {
            if ((String.valueOf (newMissing.get (0))).equals (arrSubData[start][1])) {
                String cat = arrSubData[start][0];
                try {
                    file = new File ("/sdcard/" + getName + ".csv");
                    br = new BufferedReader (new FileReader (file));

                    sCurrentline = br.readLine ();
                    while ((sCurrentline = br.readLine ()) != null) {
                        String[] col = (sCurrentline.split (","));
                        if(cat.length () == 1) {
                            data.setText ("No available substitute ingredient");
                            return;
                        }else{
                            if (cat.equals (col[0])) {
                                System.out.println ("savedS " + col[1]);
                                sub.add (col[1]);
                            }
                        }
                    }
                    displaySub ();
                    return;
                } catch (IOException e) {
                    e.printStackTrace ();
                }

            }
            if ((String.valueOf (newMissing.get (0))).equals (arrSubData[end][1])) {
                String cat = arrSubData[end][0];
                try {
                    file = new File ("/sdcard/" + getName + ".csv");
                    br = new BufferedReader (new FileReader (file));

                    sCurrentline = br.readLine ();
                    while ((sCurrentline = br.readLine ()) != null) {
                        String[] col = (sCurrentline.split (","));
                        if(cat.length () == 1) {
                            data.setText ("No available substitute ingredient");
                            return;
                        }else{
                            if (cat.equals (col[0])) {
                                System.out.println ("savedE " + col[1]);
                                sub.add (col[1]);
                            }
                        }
                    }
                    displaySub ();
                    return;
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }

            start++;
            end--;
        }
    }

    private void displaySub() {
        subList.clear ();
        if(sub.size ()!=0) {
            ListView listView = ( ListView ) findViewById (R.id.listViewExample);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_multiple_choice, sub);
            listView.setAdapter (arrayAdapter);

            listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                    Object clickItemObj = adapterView.getAdapter ().getItem (index);
                    String strItem = clickItemObj.toString ();
                    SparseBooleanArray checked = listView.getCheckedItemPositions();
                    if(checked.get(index)){
                        subList.add(strItem);
                    }
                    else{
                        subList.remove(strItem);
                    }
                }
            });

        }else{
            data.setText ("No available substitute ingredient");
        }
    }

    public void onBackPressed() {
        oDialog.dismiss ();
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
                startActivity (new Intent (NewSubBF.this, MainActivity.class));
            }
        });

        nDialogno.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                nDialog.dismiss ();
            }
        });
    }

    public void onNext(View view){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        final int getIndex = sp.getInt ("Index", 0);
        final String getName = sp.getString ("btnName", "");
        onhandList.clear ();

        try {
            File file = new File("/sdcard/" + getName + ".csv");
            BufferedReader br = new BufferedReader(new FileReader (file));
            while((sCurrentline = br.readLine()) != null ) {
                String[] col = sCurrentline.split (",");
                onhandList.add (col[1]);
            }
            for (int i = 0; i < onhandList.size (); i++) {
                for (int j = 0; j < subList.size (); j++) {
                    if (onhandList.get (i).equals (subList.get (j))) {
                        CSVReader reader = new CSVReader (new FileReader (file), ',');
                        List<String[]> csvBody = reader.readAll ();
                        int convert = Integer.parseInt (csvBody.get (i)[getIndex]) + 1;
                        csvBody.get (i)[getIndex] = String.valueOf (convert);
                        reader.close ();

                        CSVWriter writer = new CSVWriter (new FileWriter (file), ',', CSVWriter.NO_QUOTE_CHARACTER);
                        writer.writeAll (csvBody);
                        writer.flush ();
                        writer.close ();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        newMissing.remove (0);
        if(newMissing.size()!=0) {
            listContent.setText (String.valueOf (newMissing.get(0)));
            getSubData ();
        }else if(newMissing.size()==0){
            listContent.setText ("");
            sub.clear ();
            data.setText ("Your ingredients are now complete!");

            Button buttonDone = ( Button ) findViewById (R.id.btnDone);
            Button buttonNext = ( Button ) findViewById (R.id.btnNext);
            buttonDone.setVisibility(View.VISIBLE);
            buttonNext.setVisibility(View.GONE);
        }
    }

    public void onDone(View view){
        startActivity(new Intent (NewSubBF.this, MainActivity.class));
    }

}



