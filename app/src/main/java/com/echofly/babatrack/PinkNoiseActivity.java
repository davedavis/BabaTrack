package com.echofly.babatrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PinkNoiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pink_noise);

        // Todo: Make these hardcoded
        // Initializing a string array to store the sound names. These could be hard coded in the
        // TextView but I'm following along with the course so want to do these this way.
        ArrayList<String> pinkNoises = new ArrayList<String>();
        // Adding the names of the sounds to the string array.
        pinkNoises.add("Absorption");
        pinkNoises.add("Celestial");
        pinkNoises.add("Escape Velocity");
        pinkNoises.add("Heliocentric");
        pinkNoises.add("Lithosphere");
        pinkNoises.add("Parabola");
        pinkNoises.add("Quasar");
        pinkNoises.add("Triton");
        pinkNoises.add("Ultraviolet");
        pinkNoises.add("Zenith");


        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        for (int i = 0; i < pinkNoises.size(); i++) {
            TextView pinkNoisesTextView = new TextView(this);
            pinkNoisesTextView.setText(pinkNoises.get(i));
            rootView.addView(pinkNoisesTextView);
        }


    }
}
