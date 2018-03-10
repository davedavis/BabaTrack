package com.echofly.babatrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        // Instantiate a new ArrayAdapter called itemsAdapter by passing the context, the layout ID of either a custom XML layout
        // for the list item or an Android default list item that's built in( android.R.layout.simple_list_item_1), and the array
        // list itself.
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pinkNoises);
        // Create a new ListView called "ListView" without having to cast.
        ListView listView = (ListView) findViewById(R.id.list);
        //Pass the adapter to the listView's setAdapter method.
        listView.setAdapter(itemsAdapter);

    }
}
