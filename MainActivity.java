package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1, bt2, bt3, bt4, bt5, bt6;
    private final CharSequence[] colors_items = {"Red", "Green", "Blue"}; //color choices
    private AlertDialog exitdialog, colordialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this); //create alert dialog builder
                builder.setTitle("Pick background color"); //set dialog title
                builder.setMultiChoiceItems(colors_items, -1, this::onColorClick); //set color listener
                builder.setCancelable(false); //make the dialog uncancelable
                builder.setIcon(android.R.drawable.star_on); //set dialog icon
                colordialog = builder.create(); //create dialog from builder
                colordialog.show(); //show dialog

            }
                private void onColorClick (DialogInterface dialogInterface,int which){
                }

            private void listener(DialogInterface dialogInterface, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:

                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        finish();   //prevent returning here by using the back key
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        });
        bt1.setOnClickListener(this);
    }


    private void ExitConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // create alert dialog builder
        builder.setTitle("Exit confirmation"); // set dialog title
        builder.setMessage("Are you sure you want to exit ?"); // set dialog text
        builder.setPositiveButton("Yes", this::onExitChosen); // set listener - if positive button is pressed
        builder.setNegativeButton("No", this::onExitChosen); // set listener - if negative button is pressed
        builder.setCancelable(false); // make the dialog uncancelable
        builder.setIcon(android.R.drawable.ic_menu_close_clear_cancel); // set dialog icon
        exitdialog = builder.create(); // create dialog from builder
        exitdialog.show(); // show dialog
    }

    public void onExitChosen(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                finish();   //prevent returning here by using the back key
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        ExitConfirmDialog();
    }
}
