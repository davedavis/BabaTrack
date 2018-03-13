package com.echofly.babatrack;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dave Davis on 10/03/2018.
 */

public class SoundAdapter extends ArrayAdapter<Sound> {


    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param sounds  A List of Sound objects to display in a list
     */

    public SoundAdapter(Activity context, ArrayList<Sound> sounds) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, sounds);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    // getView method takes in a position, a view that can be potentially be reused, and a parent
    // viewgroup for all these list items which is the listView itself.
    // The Purpose of the getView method is to return a list item view and return it to the listView.
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {

            //create a new listitem view from this resource to store in the listIremView variable above.
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Sound currentSound = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        titleTextView.setText(currentSound.getTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        descriptionTextView.setText(currentSound.getDescription());

        //Find the ImageView in the list_item.xml layout with the ID "image"
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        //Get the image resource ID from the current Sound object and
        //set the image to imageView


        //This code will just set the image. Commenting out as we're going to check for associated
        //Images and if there is none, we'll handle it. Use the line below for situations when
        //There's always an image associated.
        // iconView.setImageResource(currentSound.getImageResourceId());

        // Check if an image is provided for this sound or not
        if (currentSound.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            iconView.setImageResource(currentSound.getImageResourceId());
            // Make sure the view is visible because the view is being reused. If it's hidden, when
            // it goes to be reused, it will still be hidden. We don't want that.
            iconView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
