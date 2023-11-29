package com.example.anew;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewGreeting;
    private Button btnBack;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            textViewGreeting = findViewById(R.id.textViewGreeting);
            btnBack = findViewById(R.id.btnBack);

            int bgColor = getBgColor();
            int textColor = getTextColor();  // Retrieve text color from intent
            int imageResource = getImageResource();
            String greetingText = getIntent().getStringExtra("greetingText");

            // Set background color
            getWindow().getDecorView().setBackgroundColor(bgColor);

            // Set text color
            textViewGreeting.setTextColor(textColor);

            // Set image resource
            if (imageResource != 0) {
                textViewGreeting.setBackgroundResource(imageResource);
            }

            // Set greeting text
            textViewGreeting.setText(greetingText);

            btnBack.setOnClickListener(v -> finish());
        }

    public int getBgColor() {
        return getIntent().getIntExtra("bgColor", Color.BLACK);
    }

    public int getTextColor() {
        return getIntent().getIntExtra("textColor", Color.WHITE);
    }

    public int getImageResource() {
        return getIntent().getIntExtra("imageResource", 0);
    }

// ...

    }
