package com.echofly.babatrack;

/**
 * Created by Dave Davis on 10/03/2018.
 *
 * @link Sound represents a sound/noise that a user wants to play.
 * It contains a default description, a title and an image resource.
 */

public class Sound {

    /**
     * Title of the sound
     */
    private String mTitle;

    /**
     * Description of the sound
     */
    private String mDescription;

    /**
     * Image resource ID of the image associated with the sound.
     */
    private int mImageResourceId;


    /**
     * Constructor to create a new Sound object.
     *
     * @param title       is the sound title.
     * @param description is the translatable description of the noise. .
     */
    public Sound(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    /**
     * Overloaded constructor to create a new Sound object with an associated image.
     *
     * @param title           is the sound title.
     * @param description     is the translatable description of the noise.
     * @param imageResourceId is the ID of the image in drawable.
     */
    public Sound(String title, String description, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the Title.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the Description.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Get the Image.
     */
    public int getImageResourceId() {

        return mImageResourceId;
    }

}

