package com.example.kenneth.thisforthat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

    }

    public void onClick(View view) {
        String code = "0", name = "";

        switch (view.getId ()) {
            case R.id.btnBlackForest:
                code = "1";
                name = "Black Forest";
                break;
            case R.id.btnBrazodeMercedes:
                code = "2";
                name = "Brazo de Mercedes";
                break;
            case R.id.btnBlueberryCheesecake:
                code = "3";
                name = "Blueberry Cheesecake";
                break;
            case R.id.btnChocolate:
                code = "4";
                name = "Chocolate Cake";
                break;
            case R.id.btnChocolateMousse:
                code = "5";
                name = "Chocolate Mousse";
                break;
            case R.id.btnMocha:
                code = "6";
                name = "Mocha Cake";
                break;
            case R.id.btnRice:
                code = "7";
                name = "Rice Cake";
                break;
            case R.id.btnStrawberry:
                code = "8";
                name = "Strawberry Cake";
                break;
            case R.id.btnUbe:
                code = "9";
                name = "Ube Macapuno";
                break;
            case R.id.btnVanilla:
                code = "10";
                name = "Vanilla Cake";
                break;

        }

        Intent i = new Intent (this, Ingredients.class);
        i.putExtra ("yourcode", code);
        startActivity (i);
    }

    public void onLogout(View view){
        Intent intent = new Intent(this, LogoActivity.class);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }
}