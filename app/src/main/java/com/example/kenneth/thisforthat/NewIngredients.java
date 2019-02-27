package com.example.kenneth.thisforthat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import static com.example.kenneth.thisforthat.CustomAdapter.*;

public class NewIngredients extends Activity{
    ListView mListView;
    Button btnShowCheckedItems;
    CustomAdapter<IngredientsHolder> mAdapter;
    public static Dialog oDialog;
    public Button oDialogyes, oDialogno;
    private static final String CSV_SEPARATOR = ",";
    List<String> onhandList = new ArrayList<String>();
    String sCurrentline;
    int index = 0;

    List<IngredientsHolder> main = new ArrayList<>();
    List<IngredientsHolder> other = new ArrayList<>();
    public static List<IngredientsHolder> newMissing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ingredients);

        mListView = (ListView) findViewById(android.R.id.list);
        btnShowCheckedItems = (Button) findViewById(R.id.btnContinue);

        checkUser();
        init();
        createDialog();
    }

    private void init() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        final String getName = sp.getString ("btnName", "");
        final int getIndex = sp.getInt ("Index", 0);
        List<IngredientsHolder> data = new ArrayList<> ();

        try {
            String sCurrentline = null;
            BufferedReader br = new BufferedReader(new FileReader ("/sdcard/"+getName+".csv"));
            sCurrentline = br.readLine ();
            while ((sCurrentline = br.readLine()) != null) {
                String[] arr = sCurrentline.split(",");
                IngredientsHolder ingredient = new IngredientsHolder(arr[0], arr[1], arr[getIndex]);
                data.add(ingredient);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, List<IngredientsHolder>> ingredientsByName = data.stream().collect(Collectors.groupingBy(IngredientsHolder::getName));

        //Sort on `admin` in descending order
        Comparator<IngredientsHolder> comparator = Comparator.comparing(IngredientsHolder:: getAdmin, (i1, i2) -> {
            if (i2 > i1) {
                return -1;
            } else if (i2 < i1) {
                return 1;
            }
            return 0;

        });

        //Go through each list (ingredient) and find the one with max `admin` value
        //and add it to the `main` list then add the rest to `other`
        ingredientsByName.forEach( (k, group) -> {
            IngredientsHolder max = group.stream().max(comparator).get();
            if (max.getAdmin() == 0) {
                max = group.get(0);
            }if(max.getAdmin () > 0){
                //group.forEach(System.out::println);
                int value = max.getAdmin ();

                List<IngredientsHolder> filtered = (group.stream()
                        .filter(mc -> mc.getAdmin() == value)
                        .collect(Collectors.toList()));
                //filtered.forEach(mc -> System.out.println (mc.toString ()));
            }

            main.add(max);
            group.remove(max);
            other.addAll(group);

            writeToCSV(other);
        });

        List<IngredientsHolder> newMain = main.stream().distinct().collect(Collectors.toList());

        ListView lv = (ListView) findViewById(R.id.list);
        mAdapter = new CustomAdapter<IngredientsHolder>(this, ( ArrayList<IngredientsHolder> ) newMain);
        lv.setAdapter(mAdapter);
    }

    public void checkMissing(){
        newMissing = main.stream().distinct().collect(Collectors.toList());

        for(int i = 0; i < newMissing.size(); i++) {
            for(int j = 0; j < onhand.size(); j++){
                if(onhand.get (j).trim ().equals(String.valueOf (newMissing.get (i)))){
                    newMissing.remove (newMissing.get (i));
                }
            }
        }
    }

    public void checkUser(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sp.getString("Username", "");
        System.out.println ("username "+name);
        int index = 0;

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

            SharedPreferences.Editor editor = sp.edit();
            editor.putInt ("Index", index);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace ();
        }

        System.out.println ("index "+ index);
    }

    private static void writeToCSV(List<IngredientsHolder> productList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream ("/sdcard/temp.csv"), "UTF-8"));
            for (IngredientsHolder ingredient : productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(ingredient.getName().trim().length() == 0? "" : ingredient.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(ingredient.getSubName ().trim().length() == 0? "" : ingredient.getSubName());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public void onNewContinue(View v) {
        oDialog.show ();
    }

    protected void createDialog() {
        oDialog = new Dialog (this);
        oDialog.requestWindowFeature (Window.FEATURE_NO_TITLE);
        oDialog.setContentView (R.layout.dialog_exit);

        oDialog.setCanceledOnTouchOutside (true);
        oDialog.setCancelable (true);
        oDialogyes = ( Button ) oDialog.findViewById (R.id.yes);
        oDialogno = ( Button ) oDialog.findViewById (R.id.No);
        oDialogyes.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(NewIngredients.this);
                final int getIndex = sp.getInt ("Index", 0);
                final String getName = sp.getString ("btnName", "");

                List<IngredientsHolder> onhand = mAdapter.getCheckedItems();
                onhandList.clear ();

                try {
                    File file = new File("/sdcard/"+getName+".csv");
                    BufferedReader br = new BufferedReader(new FileReader (file));
                    while((sCurrentline = br.readLine()) != null ) {
                        String[] col = sCurrentline.split (",");
                        onhandList.add (col[1]);
                    }
                    for (int i = 0; i < onhandList.size (); i++) {
                        for (int j = 0; j < onhand.size (); j++) {
                            if (onhandList.get (i).equals (onhand.get (j))) {
                                CSVReader reader = new CSVReader (new FileReader(file), ',');
                                List<String[]> csvBody = reader.readAll();
                                int convert = Integer.parseInt (csvBody.get(i)[getIndex]) + 1;
                                csvBody.get(i)[getIndex] = String.valueOf (convert);
                                reader.close();

                                CSVWriter writer = new CSVWriter(new FileWriter (file), ',', CSVWriter.NO_QUOTE_CHARACTER);
                                writer.writeAll(csvBody);
                                writer.flush();
                                writer.close();
                            }
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                checkMissing ();

                startActivity(new Intent (NewIngredients.this, NewSubBF.class));
            }
        });

        oDialogno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                oDialog.dismiss();
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent (NewIngredients.this, MainActivity.class));
    }
}