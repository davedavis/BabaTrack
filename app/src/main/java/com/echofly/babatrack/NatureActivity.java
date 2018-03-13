package com.echofly.babatrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        // Content/logic of the Activity.
        ArrayList<Sound> natureNoises = new ArrayList<Sound>();
        // Create new Sound objects and pass them into the Array List.


        // Verbose way to do it.
        //        Sound w = new Sound("Beautifully deep sound ideal for sleeping.", "Absorption");
        //        pinkNoises.add(w);

        // Better way, instantiate new objects when adding to the ArrayList.
        // Sample data
        // Todo: Implement database and network calls to check for noise updates.
        // Add an image resource ID to use an image in the ListView. Otherwise, the adapter will hide it.
        natureNoises.add(new Sound("Antimatter", "Beautifully deep sound ideal for sleeping. This sound is great for helping babies get to sleep."));
        natureNoises.add(new Sound("White Hole", "Rumbling and raw, perfect for entering sleep. Great for when baby is restless or distracted.", R.drawable.number_two));
        natureNoises.add(new Sound("Cluster", "Sharper and static, perfect for REM.This sound is great for helping babies get to sleep.", R.drawable.number_three));
        natureNoises.add(new Sound("Exoplanet", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_four));
        natureNoises.add(new Sound("Iodestar", "Late stage Pink Noise, Ideal for ending the night.This sound is great for helping babies get to sleep.", R.drawable.number_five));
        natureNoises.add(new Sound("Nebula", "Beautifully deep sound ideal for sleeping. Great for when baby is restless or distracted.", R.drawable.number_six));
        natureNoises.add(new Sound("Nova", "Rumbling and raw, perfect for entering sleep.This sound is great for helping babies get to sleep.", R.drawable.number_seven));
        natureNoises.add(new Sound("Supernova", "Sharper and static, perfect for REM. This sound is great for helping babies get to sleep.", R.drawable.number_eight));
        natureNoises.add(new Sound("Satellite", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_nine));
        natureNoises.add(new Sound("Pulsar", "Late stage Pink Noise, Ideal for ending the night. This sound is great for helping babies get to sleep.", R.drawable.number_ten));


        // Instantiate a new ArrayAdapter called itemsAdapter by passing the context, the layout ID of either a custom XML layout
        // for the list item or an Android default list item that's built in( android.R.layout.simple_list_item_1), and the array
        // list itself.
        SoundAdapter adapter = new SoundAdapter(this, natureNoises);
        // Create a new ListView called "ListView" without having to cast.
        ListView listView = (ListView) findViewById(R.id.list);
        //Pass the adapter to the listView's setAdapter method.
        listView.setAdapter(adapter);



    }
}
