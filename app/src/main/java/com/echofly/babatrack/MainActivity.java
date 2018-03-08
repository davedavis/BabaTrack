package com.echofly.babatrack;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
    }


        public void openPinkNoiseList(View view){
            Intent pinkNoiseIntent = new Intent(this, PinkNoiseActivity.class);
            startActivity(pinkNoiseIntent);

        }




}
