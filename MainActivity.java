package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TTSManager ttsManager = null;
    private EditText et;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttsManager = new TTSManager(this);

        et = findViewById(R.id.et);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutdown();
    }

    public void speakOnClick() {
        String text = et.getText().toString();
        Log.d("MainActivity", "Text to speak: " + text);
        ttsManager.speak(text, true);
    }


    @Override
    public void onClick(View view) {
        speakOnClick();
    }
}
