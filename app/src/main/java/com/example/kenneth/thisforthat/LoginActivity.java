package com.example.kenneth.thisforthat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);

    }

    public void onSignIn(View view) {
        // get the Refferences of views
        final EditText editTextUserName = ( EditText ) findViewById (R.id.txtSigninUsername);
        final EditText editTextPassword = ( EditText ) findViewById (R.id.txtSigninPassword);
        // get The User name and Password
        String username = editTextUserName.getText ().toString ();
        String password = editTextPassword.getText ().toString ();

        String filePath = "/sdcard/insert.csv";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader (new FileReader (filePath));
            String line;
            while ((line = bufferedReader.readLine ()) != null) {
                String[] col = line.split (",");
                // check if the Stored password matches with Password entered by user
                if (username.equals (col[0]) && password.equals (col[1])) {
                    startActivity(new Intent (LoginActivity.this, MainActivity.class));

                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Username", username);
                    editor.commit();
                    return;
                } if(!username.equals (col[0]) || !password.equals (col[1])) {
                    //Toast.makeText(getApplicationContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent (LoginActivity.this, LogoActivity.class));
    }
}
