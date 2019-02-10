package com.example.kenneth.thisforthat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
                    BufferedWriter writer = null, writer1 = null;
                    try {
                        writer = new BufferedWriter (new FileWriter(filePath, true));
                        writer.write(username);
                        writer.write(",");
                        writer.write (password);
                        writer.write ("\n");
                        writer.flush ();
                        writer.close ();

                        addColumn ();

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

    public void addColumn(){
        String username = editTextUserName.getText().toString();
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            File file = new File("/sdcard/TABLE_BF.csv");
            File newfile = new File("/sdcard/TABLE_BF.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_BM.csv");
            File newfile = new File("/sdcard/TABLE_BM.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_BC.csv");
            File newfile = new File("/sdcard/TABLE_BC.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_CC.csv");
            File newfile = new File("/sdcard/TABLE_CC.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_CM.csv");
            File newfile = new File("/sdcard/TABLE_CM.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_MC.csv");
            File newfile = new File("/sdcard/TABLE_MC.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_RC.csv");
            File newfile = new File("/sdcard/TABLE_RC.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_SC.csv");
            File newfile = new File("/sdcard/TABLE_SC.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_UM.csv");
            File newfile = new File("/sdcard/TABLE_UM.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        try {
            File file = new File("/sdcard/TABLE_VC.csv");
            File newfile = new File("/sdcard/TABLE_VC.csv");

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
            boolean deleted = file.delete();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile, false)));

            String line = null;

            line = br.readLine();
            String addedColumn = username;
            bw.write(line+","+addedColumn);
            bw.write ("\n");

            while((line = br.readLine())!=null){
                bw.write(line+","+"0");
                bw.write ("\n");
            }
        } catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close ();
                bw.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

    }

    public void onBackPressed(){
        startActivity(new Intent (SignupActivity.this, LogoActivity.class));
    }

}
