// Todo: Add Dark Theme for night viewing.
// Todo: Add correct sounds per category.
// Todo: Fix White Noise background colour.
// Todo: Source image resources.
// ToDo: Add correct launcher icon(s).
// Todo: Perform Lint.
// Todo: Modify list items to change play icon to pause/stop icon when playing.
// Todo: Modify List items to show star/heart.
// Todo: Modify app bar to show toggle for favourites.
// Todo: Add current playing sounds to notification area.

package com.echofly.babatrack;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Displays a {@link ViewPager} where each page shows a different day of the week.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());



        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Attach the TabLayout to the ViewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
