package com.example.kenneth.thisforthat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.squareup.okhttp.Headers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewIngredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_new_ingredients);

        readCSV ();
    }

    public void readCSV(){
        List<IngredientsHolder> data = new ArrayList<> ();
        try {
            String sCurrentline = null;
            BufferedReader br = new BufferedReader(new FileReader ("/sdcard/TABLE_BF.csv"));
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
        lv.setAdapter(new CustomAdapter(NewIngredients.this,newMain));
    }
}
