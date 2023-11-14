package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TTSManager ttsManager=null;
    private EditText et;
    private Button bt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsManager = new TTSManager(this);
        et=findViewById(R.id.et);
        bt=findViewById(R.id.bt);
        bt.setOnClickListener(this::speakOnClick);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutdown();
    }
    public void speakOnClick(View v) {

        String text = et.getText().toString();
        ttsManager.speak(text,true);
    }

}