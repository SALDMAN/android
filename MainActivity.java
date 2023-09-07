package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Human[] person = new Human[5];
        int age, bigest = 0, smallest = 0, before = 0;
        String samecity = "";
        person[0] = new Human("yair", 16, "pardes-hana", false, "male");
        person[1] = new Human("aiala", 20, "haifa", true, "female");
        person[2] = new Human("ahmed", 30, "jaser", true, "male");
        person[3] = new Human("ziv", 31, "binyamina", true, "female");
        person[4] = new Human("illay", 36, "binyamina", false, "male");
        for (int i = 0; i < 5; i++) {
            age = 0;
            //check if they are female
            if (person[i].getGender().equals("female")) {
                Log.d("female:", "female");
                age = person[i].getAge();
                age--;
                //check their age
            } else {
                age = person[i].getAge();
                age++;
            }
            //check the bigest man
            if (age > bigest) {
                bigest = age;
                //check the youngest
            } else if (smallest < age) {
                smallest = age;
            }
        }
        //print both
        Log.d("bigest:", "" + bigest);
        Log.d("smallest:", "" + smallest);
        for (int i = 0; i < person.length; i++) {
            for (int j = i + 1; j < person.length; j++) {
                // Check if both people are over 30 and live in the same city
                if (person[i].getAge() > 30 && person[j].getAge() > 30 && person[i].getCity().equals(person[j].getCity())) {
                    Log.d("same:", "" + person[j].getId());
                }
                //else they are not
                else{
                    Log.d("False:","false");
                }
            }
        }
    }
}