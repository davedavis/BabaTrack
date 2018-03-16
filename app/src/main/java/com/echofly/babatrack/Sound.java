package com.echofly.babatrack;

/**
 * Created by Dave Davis on 10/03/2018.
 *
 * @link Sound represents a sound/noise that a user wants to play.
 * It contains a default description, a title and an image resource.
 */

public class Sound {

    /**
     * Constant value that represents no image was provided for this sound
     */
    private static final int NO_IMAGE_PROVIDED = -1;
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
     * Local images in Drawable.
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /**
     * Audio resource ID for the sound
     */
    private int mAudioResourceId;



    /**
     * Constructor to create a new Sound object.
     *
     * @param title       is the sound title.
     * @param description is the translatable description of the noise.
     * @param audioResourceId is the resource ID for the audio file associated with this noise
     */
    public Sound(String title, String description, int audioResourceId) {
        mTitle = title;
        mDescription = description;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Overloaded constructor to create a new Sound object with an associated image.
     *
     * @param title           is the sound title.
     * @param description     is the translatable description of the noise.
     * @param imageResourceId is the ID of the image in drawable.
     * @param audioResourceId is the resource ID for the audio file associated with this noise
     */

    public Sound(String title, String description, int imageResourceId, int audioResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
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

    /**
     * Get the audio associated with the noise.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;}


    // Returns whether or not there is an image for this word.

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


    // Create a toString method for debugging sound objects.
    // Todo: Remove this method once published.
    @Override
    public String toString() {
        return "Sound{" +
                "mTitle='" + mTitle + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}

