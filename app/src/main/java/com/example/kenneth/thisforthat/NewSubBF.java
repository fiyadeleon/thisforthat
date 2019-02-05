package com.example.kenneth.thisforthat;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import static com.example.kenneth.thisforthat.NewIngredients.mDialog;

public class NewSubBF extends AppCompatActivity {
    Dialog nDialog;
    Button nDialogyes, nDialogno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_new_sub_bf);

        createDialog ();
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
}
