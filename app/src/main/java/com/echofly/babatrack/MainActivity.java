package com.echofly.babatrack;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView pinkNoiseTextView = findViewById(R.id.pinknoise);
        TextView brownNoiseTextView = findViewById(R.id.brownnoise);
        TextView whiteNoiseTextView = findViewById(R.id.whitenoise);
        TextView natureTextView = findViewById(R.id.nature);
        TextView weatherTextView = findViewById(R.id.weather);

        // Todo: Use switch or investigate ways to make this more efficient without having to duplicate onClickListner code.
        // Todo: Remove casting as compile SDK is 26 so inference is used. Cool new feature that tutorials don't cover.
        // Todo: Add Dark Theme for night viewing.

        //Set the Pink Noise OnClickListener and use an Intent to open the Pink Noise Activity
        pinkNoiseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pinkNoiseIntent = new Intent(MainActivity.this, PinkNoiseActivity.class);
                startActivity(pinkNoiseIntent);
            }
        });


        //Set the Brown Noise OnClickListener and use an Intent to open the Brown Noise Activity
        brownNoiseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brownNoiseIntent = new Intent(MainActivity.this, BrownNoiseActivity.class);
                startActivity(brownNoiseIntent);
            }
        });

        //Set the White Noise OnClickListener and use an Intent to open the White Noise Activity
        whiteNoiseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whiteNoiseIntent = new Intent(MainActivity.this, WhiteNoiseActivity.class);
                startActivity(whiteNoiseIntent);
            }
        });

        //Set the Nature OnClickListener and use an Intent to open the Nature Activity
        natureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent natureIntent = new Intent(MainActivity.this, NatureActivity.class);
                startActivity(natureIntent);
            }
        });


        //Set the Weather OnClickListener and use an Intent to open the Pink Noise Activity
        weatherTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weatherIntent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(weatherIntent);
            }
        });





    }


}
