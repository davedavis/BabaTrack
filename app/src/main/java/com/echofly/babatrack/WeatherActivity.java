package com.echofly.babatrack;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    // Initializing mMediaPlayer variable that will hold a Mediaplayer object accessible from within
    // the anonymous OnItemClickListener Class.
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //Create a new ArrayList of the custom object type "Sound" that we created.
        // Set it to final so it can be accessed by the onClick method in the anonymous
        // SetItemOnClickListner class below (because we're in the onCreate method here).
        final ArrayList<Sound> weatherNoises = new ArrayList<Sound>();
        // Create new Sound objects and pass them into the Array List.


        // Verbose way to do it.
        // Sound w = new Sound("Beautifully deep sound ideal for sleeping.", "Absorption");
        // pinkNoises.add(w);

        // Better way, instantiate new objects when adding to the ArrayList.
        // Sample data

        weatherNoises.add(new Sound("Wind", "Beautifully deep sound ideal for sleeping. This sound is great for helping babies get to sleep.", R.drawable.number_one, R.raw.sound));
        weatherNoises.add(new Sound("Light Rain", "Rumbling and raw, perfect for entering sleep. Great for when baby is restless or distracted.", R.drawable.number_two, R.raw.sound2));
        weatherNoises.add(new Sound("Heavy Rain", "Sharper and static, perfect for REM.This sound is great for helping babies get to sleep.", R.drawable.number_three, R.raw.sound3));
        weatherNoises.add(new Sound("Thunder", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_four, R.raw.sound4));
        weatherNoises.add(new Sound("Snow", "Late stage Pink Noise, Ideal for ending the night.This sound is great for helping babies get to sleep.", R.drawable.number_five, R.raw.sound5));
        weatherNoises.add(new Sound("Storm", "Beautifully deep sound ideal for sleeping. Great for when baby is restless or distracted.", R.drawable.number_six, R.raw.sound6));
        weatherNoises.add(new Sound("Thunder", "Rumbling and raw, perfect for entering sleep.This sound is great for helping babies get to sleep.", R.drawable.number_seven, R.raw.sound7));
        weatherNoises.add(new Sound("Hurricane", "Sharper and static, perfect for REM. This sound is great for helping babies get to sleep.", R.drawable.number_eight, R.raw.sound8));
        weatherNoises.add(new Sound("Breeze", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_nine, R.raw.sound9));
        weatherNoises.add(new Sound("Mayhem", "Late stage Pink Noise, Ideal for ending the night. This sound is great for helping babies get to sleep.", R.drawable.number_ten, R.raw.sound10));


        // Instantiate a new ArrayAdapter called itemsAdapter by passing the context, the layout ID of either a custom XML layout
        // for the list item or an Android default list item that's built in( android.R.layout.simple_list_item_1), and the array
        // list itself.
        SoundAdapter adapter = new SoundAdapter(this, weatherNoises, R.color.category_weather);
        // Create a new ListView called "ListView" without having to cast.
        ListView listView = (ListView) findViewById(R.id.list);
        //Pass the adapter to the listView's setAdapter method.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Sound} object at the given position the user clicked on.

                Sound sound = weatherNoises.get(position);

                mMediaPlayer = MediaPlayer.create(WeatherActivity.this, sound.getAudioResourceId());
                mMediaPlayer.start();

                // release MediaPlayer using helper method when song is complete.

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });


    }


    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            Log.e("WeatherActivity", "Media Player successfully released!!!!!!!!!!!!!!!!");

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }


}
