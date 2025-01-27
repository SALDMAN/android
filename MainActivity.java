package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "AIzaSyDMzFE85unqY6hE8anVh5jv-CW6gPyUNlE"; // Replace with your actual API key
    private static final String VIDEO_ID = "7qPlk8XJCNY"; // YouTube video ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                        MainActivity.this, API_KEY, VIDEO_ID, 0, true, true);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); // Call the super method

        if (requestCode == 1) {
            if (resultCode != RESULT_OK) {
                YouTubeInitializationResult errorReason =
                        YouTubeStandalonePlayer.getReturnedInitializationResult(data);
                if (errorReason != null) {
                    errorReason.getErrorDialog(this, 0).show();
                }
            }
        }
    }
}