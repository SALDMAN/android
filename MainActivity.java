package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bton;
    EditText text1,text2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bton = findViewById(R.id.bton);
        bton.setOnClickListener(this);
        text1 = findViewById(R.id.text1);
        text1.setText("yuval");
    }


    @Override
    public void onClick(View view) {
        text1.setText("gay");
    }
    private static class Human{

    }
}