package com.example.myapplication;


import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TTSManager implements TextToSpeech.OnInitListener {
    private TextToSpeech tts = null;
    private boolean isLoaded = false;

    public TTSManager(Context context) {
        try {
            isLoaded = false;
            tts = new TextToSpeech(context, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            isLoaded = true;
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.d("TAG", "This language is not supported");
            }
        } else {
            Log.d("TAG", "Init failed");
        }
    }

    public void shutdown() {
        tts.shutdown();
    }

    public void speak(String text, boolean flushQueue) {
        if (isLoaded) {
            if (flushQueue) {
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            } else {
                tts.speak(text, TextToSpeech.QUEUE_ADD, null);
            }
        }
             else {
                Log.d("TAG", "TTS not initialized");

            }



    }
}

