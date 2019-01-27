package com.example.kenneth.thisforthat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignupActivity extends AppCompatActivity {
    String filePath = "/sdcard/insert.csv";
    EditText editTextUserName, editTextPassword, editTextConfirmPassword;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Get Refferences of Views
        editTextUserName = (EditText)findViewById(R.id.txtSignupUsername);
        editTextPassword = (EditText)findViewById(R.id.txtSignupPassword);
        editTextConfirmPassword = (EditText)findViewById(R.id.txtSignupConfirm);

        btnCreateAccount = (Button)findViewById(R.id.btnSignup);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                // check if any of the fields are vacant
                if(username.equals("")||password.equals("")||confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter (new FileWriter(filePath, true));
                        writer.write(username);
                        writer.write(",");
                        writer.write (password);
                        writer.write ("\n");

                        writer.flush ();
                        writer.close ();

                        Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                        startActivity(new Intent (SignupActivity.this, LoginActivity.class));
                        return;
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent (SignupActivity.this, LogoActivity.class));
    }

}
