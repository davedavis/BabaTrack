package com.echofly.babatrack;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of weather noises.
 */
public class WeatherFragment extends Fragment {

    // Initializing mMediaPlayer variable that will hold a Mediaplayer object accessible from within
    // the anonymous OnItemClickListener Class.
    private MediaPlayer mMediaPlayer;
    // Initializing AudioManager variable that we only need to initialize it once in the activity
    // lifecycle. This will be used to handle Audio Focus and be a good citizen. Step 1 in managing
    // audio focus in an activity.
    private AudioManager mAudioManager;


    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    // Make sure to check for a null object or Java will spit out an error.
                    // Todo: Implement volume duck instead of pause for ducking events.
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK && mMediaPlayer != null) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                // Play from the beginning
                // Todo: Implement position tracking and seek back.
                mMediaPlayer.seekTo(0);

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_weather, container, false);


        // Create and setup the {@link AudioManager} to request audio focus.
        // Here we're getting a reference to the AudioManager system service so we can call the
        // requestAudioFocus() method on it later.
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Create a new ArrayList of the custom object type "Sound" that we created.
        // Set it to final so it can be accessed by the onClick method in the anonymous
        // SetItemOnClickListner class below (because we're in the onCreate method here).
        final ArrayList<Sound> weatherNoises = new ArrayList<Sound>();


        // Create new Sound objects and pass them into the Array List.

        // Todo: Implement database and network calls to check for noise updates.
        // Todo: Loop Sounds and provide UI for mixing.
        // Todo: Release MediaPlayer if necessary (from options)
        // Todo: Consider using SoundPool instead of MediaPlayer: https://developer.android.com/reference/android/media/SoundPool.html
        // Todo: Use loop methods to loop if user requests.
        // Todo: Currently, a new MediaPlayer Object is used for each sound. Refactor to use just one.

        weatherNoises.add(new Sound("Wind", "Beautifully deep sound ideal for sleeping.", R.drawable.number_one, R.raw.sound));
        weatherNoises.add(new Sound("Light Rain", "Rumbling and raw, perfect for entering sleep.", R.drawable.number_two, R.raw.sound2));
        weatherNoises.add(new Sound("Heavy Rain", "Sharper and static, perfect for REM.", R.drawable.number_three, R.raw.sound3));
        weatherNoises.add(new Sound("Thunder", "Grinding and deep, use for deeper sleep cycles.", R.drawable.number_four, R.raw.sound4));
        weatherNoises.add(new Sound("Snow", "Late stage weather Noise, Ideal for ending the night.", R.drawable.number_five, R.raw.sound5));
        weatherNoises.add(new Sound("Storm", "Beautifully deep sound ideal for sleeping.", R.drawable.number_six, R.raw.sound6));
        weatherNoises.add(new Sound("Thunder", "Rumbling and raw, perfect for entering sleep.", R.drawable.number_seven, R.raw.sound7));
        weatherNoises.add(new Sound("Hurricane", "Sharper and static, perfect for REM.", R.drawable.number_eight, R.raw.sound8));
        weatherNoises.add(new Sound("Breeze", "Grinding and deep, use for deeper sleep cycles.", R.drawable.number_nine, R.raw.sound9));
        weatherNoises.add(new Sound("Mayhem", "Late stage weather Noise, Ideal for ending the night.", R.drawable.number_ten, R.raw.sound10));


        // Instantiate a new ArrayAdapter called itemsAdapter by passing the context, the layout ID of either a custom XML layout
        // for the list item or an Android default list item that's built in( android.R.layout.simple_list_item_1), the array
        // list itself and the sound resource.
        SoundAdapter adapter = new SoundAdapter(getActivity(), weatherNoises, R.color.category_weather);

        // Create a new ListView called "ListView" without having to cast.
        ListView listView = rootView.findViewById(R.id.list);

        //Pass the adapter to the listView's setAdapter method.
        listView.setAdapter(adapter);

        // Add a setOnItemClickListener on each item in the list.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Sound} object at the given position the user clicked on.

                Sound sound = weatherNoises.get(position);
                // Debug using toString method on class. Use error level with emultor to avoid torrent of logs.
                // Todo: Remove debug logging method.
                Log.e("WeatherActivity", "Current sound: " + sound);


                // Release the MediaPlayer if it currently exists because we are about to play a new file.
                // Disable this for merged playing.
                // Todo: Re-Enable for single track playback.
                releaseMediaPlayer();

                // Request audio focus now and pass it the change listener defined above), the stream type and the
                // type of focus needed. Then check if it's granted.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the Music Stream constant
                        AudioManager.STREAM_MUSIC,
                        // Request Permanent Focus
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    //Start Playback if Audio Focus is granted.
                    mMediaPlayer = MediaPlayer.create(getActivity(), sound.getAudioResourceId());
                    mMediaPlayer.start();

                    // release MediaPlayer using helper method when song is complete.
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }

                    });

                }
            }

        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
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

            // As per developer guidelines, regardless of weather or not we were granted audio focus,
            // abandon it so that it doesn't interfere with other activity lifecycles and so that we
            // don't get any callbacks from the listener.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
