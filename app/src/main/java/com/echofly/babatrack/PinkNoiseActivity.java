package com.echofly.babatrack;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PinkNoiseActivity extends AppCompatActivity {

    // Initializing mMediaPlayer variable that will hold a Mediaplayer object accessible from within
    // the anonymous OnItemClickListener Class.
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pink_noise);


        //Create a new ArrayList of the custom object type "Sound" that we created.
        // Set it to final so it can be accessed by the onClick method in the anonymous
        // SetItemOnClickListner class below (because we're in the onCreate method here).
        final ArrayList<Sound> pinkNoises = new ArrayList<Sound>();


        // Create new Sound objects and pass them into the Array List.

        // Todo: Implement database and network calls to check for noise updates.
        // Todo: Loop Sounds and provide UI for mixing.
        // Todo: Release MediaPlayer if necessary (from options)
        // Todo: Consider using SoundPool instead of MediaPlayer: https://developer.android.com/reference/android/media/SoundPool.html
        // Todo: Use loop methods to loop if user requests.
        // Todo: Currently, a new MediaPlayer Object is used for each sound. Refactor to use just one.

        pinkNoises.add(new Sound("Absorprion", "Beautifully deep sound ideal for sleeping. This sound is great for helping babies get to sleep.", R.drawable.number_one, R.raw.sound));
        pinkNoises.add(new Sound("Celestial", "Rumbling and raw, perfect for entering sleep. Great for when baby is restless or distracted.", R.drawable.number_two, R.raw.sound2));
        pinkNoises.add(new Sound("Escape Velocity", "Sharper and static, perfect for REM.This sound is great for helping babies get to sleep.", R.drawable.number_three, R.raw.sound3));
        pinkNoises.add(new Sound("Heliocentric", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_four, R.raw.sound4));
        pinkNoises.add(new Sound("Lithosphere", "Late stage Pink Noise, Ideal for ending the night.This sound is great for helping babies get to sleep.", R.drawable.number_five, R.raw.sound5));
        pinkNoises.add(new Sound("Parabola", "Beautifully deep sound ideal for sleeping. Great for when baby is restless or distracted.", R.drawable.number_six, R.raw.sound6));
        pinkNoises.add(new Sound("Quasar", "Rumbling and raw, perfect for entering sleep.This sound is great for helping babies get to sleep.", R.drawable.number_seven, R.raw.sound7));
        pinkNoises.add(new Sound("Triton", "Sharper and static, perfect for REM. This sound is great for helping babies get to sleep.", R.drawable.number_eight, R.raw.sound8));
        pinkNoises.add(new Sound("Ultraviolet", "Grinding and deep, use for deeper sleep cycles. Great for when baby is restless or distracted.", R.drawable.number_nine, R.raw.sound9));
        pinkNoises.add(new Sound("Zenith", "Late stage Pink Noise, Ideal for ending the night. This sound is great for helping babies get to sleep.", R.drawable.number_ten, R.raw.sound10));



        // Instantiate a new ArrayAdapter called itemsAdapter by passing the context, the layout ID of either a custom XML layout
        // for the list item or an Android default list item that's built in( android.R.layout.simple_list_item_1), the array
        // list itself and the sound resource.
        SoundAdapter adapter = new SoundAdapter(this, pinkNoises, R.color.category_pink_noise);
        // Create a new ListView called "ListView" without having to cast.
        ListView listView = findViewById(R.id.list);
        //Pass the adapter to the listView's setAdapter method.
        listView.setAdapter(adapter);

        // Add a setOnItemClickListener on each item in the list.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Sound} object at the given position the user clicked on.

                Sound sound = pinkNoises.get(position);
                // Debug using toString method on class. Use error level with emultor to avoid torrent of logs.
                // Todo: Remove debug logging method.
                Log.e("PinkNoiseActivity", "Current sound: " + sound);


                // Release the MediaPlayer if it currently exists because we are about to play a new file.
                // Disable this for merged playing.
                // Todo: Disable for multi track
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(PinkNoiseActivity.this, sound.getAudioResourceId());
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
            Log.e("PinkNoiseActivity", "Media Player successfully released!!!!!!!!!!!!!!!!");

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }



}
