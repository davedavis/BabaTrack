package com.echofly.babatrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PinkNoiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pink_noise);


        ArrayList<Sound> pinkNoises = new ArrayList<Sound>();
        // Create new Sound objects and pass them into the Array List.


        // Verbose way to do it.
        //        Sound w = new Sound("Beautifully deep sound ideal for sleeping.", "Absorption");
        //        pinkNoises.add(w);

        // Better way, instantiate new objects when adding to the ArrayList.
        // Sample data
        // Todo: Implement database and network calls to check for noise updates.

        pinkNoises.add(new Sound("Absorprion", "Beautifully deep sound ideal for sleeping. This sound is great for helping babies get to sleep.", R.drawable.number_one));
        pinkNoises.add(new Sound("Celestial", "Rumbling and raw, perfect for entering sleep. Great for when baby is restless or distracted.", R.drawable.number_two));
        pinkNoises.add(new Sound("Escape Velocity", "Sharper and static, perfect for REM.This sound is great for helping babies get to sleep.", R.drawable.number_three));
        pinkNoises.add(new Sound("Heliocentric", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_four));
        pinkNoises.add(new Sound("Lithosphere", "Late stage Pink Noise, Ideal for ending the night.This sound is great for helping babies get to sleep.", R.drawable.number_five));
        pinkNoises.add(new Sound("Parabola", "Beautifully deep sound ideal for sleeping. Great for when baby is restless or distracted.", R.drawable.number_six));
        pinkNoises.add(new Sound("Quasar", "Rumbling and raw, perfect for entering sleep.This sound is great for helping babies get to sleep.", R.drawable.number_seven));
        pinkNoises.add(new Sound("Triton", "Sharper and static, perfect for REM. This sound is great for helping babies get to sleep.", R.drawable.number_eight));
        pinkNoises.add(new Sound("Ultraviolet", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_nine));
        pinkNoises.add(new Sound("Zenith", "Late stage Pink Noise, Ideal for ending the night. This sound is great for helping babies get to sleep.", R.drawable.number_ten));



        // Instantiate a new ArrayAdapter called itemsAdapter by passing the context, the layout ID of either a custom XML layout
        // for the list item or an Android default list item that's built in( android.R.layout.simple_list_item_1), and the array
        // list itself.
        SoundAdapter adapter = new SoundAdapter(this, pinkNoises);
        // Create a new ListView called "ListView" without having to cast.
        ListView listView = (ListView) findViewById(R.id.list);
        //Pass the adapter to the listView's setAdapter method.
        listView.setAdapter(adapter);

    }
}
