package com.example.kenneth.thisforthat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import static com.example.kenneth.thisforthat.DatabaseHelper.onhand;

public class NewIngredients extends Activity implements OnClickListener {
    ListView mListView;
    Button btnShowCheckedItems;
    CustomAdapter<IngredientsHolder> mAdapter;
    public static Dialog mDialog;
    public Button mDialogyes, mDialogno;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ingredients);

        mListView = (ListView) findViewById(android.R.id.list);
        btnShowCheckedItems = (Button) findViewById(R.id.btnContinue);

        init();
        addListeners();
        createDialog();
    }

    private void init() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        final String getName = sp.getString ("btnName", "");
        List<IngredientsHolder> data = new ArrayList<> ();
        try {
            String sCurrentline = null;
            BufferedReader br = new BufferedReader(new FileReader ("/sdcard/"+getName+".csv"));
            sCurrentline = br.readLine ();
            while ((sCurrentline = br.readLine()) != null) {
                String[] arr = sCurrentline.split(",");
                IngredientsHolder ingredient = new IngredientsHolder(arr[0], arr[1], arr[2]);
                data.add(ingredient);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, List<IngredientsHolder>> ingredientsByName = data.stream().collect(Collectors.groupingBy(IngredientsHolder::getName));

        List<IngredientsHolder> main = new ArrayList<>();
        List<IngredientsHolder> other = new ArrayList<>();

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
            System.out.println (other.size ());
        });

        List<IngredientsHolder> newMain = main.stream().distinct().collect(Collectors.toList());
        ListView lv = (ListView) findViewById(R.id.list);

        mAdapter = new CustomAdapter<IngredientsHolder>(this, ( ArrayList<IngredientsHolder> ) newMain);
        lv.setAdapter(mAdapter);
    }

    private void addListeners() {
        btnShowCheckedItems.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*if(mAdapter != null) {
            ArrayList<IngredientsHolder> mArrayProducts = mAdapter.getCheckedItems();
            Log.d(MainActivity.class.getSimpleName(), "Selected Items: " + mArrayProducts.toString());
            Toast.makeText(getApplicationContext(), "Selected Items: " + mArrayProducts.toString(), Toast.LENGTH_LONG).show();
        }*/

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
                ArrayList<IngredientsHolder> mArrayProducts = mAdapter.getCheckedItems();
                startActivity(new Intent (NewIngredients.this, NewSubBF.class));
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
        startActivity(new Intent (NewIngredients.this, MainActivity.class));
    }
}