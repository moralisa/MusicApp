package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the View that shows the music category
        TextView myMusic = findViewById(R.id.myMusic);

        // Set a click listener on that View
        myMusic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the music category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link MainActivity}
                Intent myMusicIntent = new Intent(MainActivity.this, MyMusic.class);

                // Start the new activity
                startActivity(myMusicIntent);
            }
        });

// Find the View that shows the unknown category
        TextView unknown = findViewById(R.id.unknown);

        // Set a click listener on that View
        unknown.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the unknown category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link unknownActivity}
                Intent unknownIntent = new Intent(MainActivity.this, Unknown.class);

                // Start the new activity
                startActivity(unknownIntent);
            }
        });

        // Find the View that shows the download category
        TextView download = findViewById(R.id.download);

        // Set a click listener on that View
        download.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the download category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link DownloadActivity}
                Intent downloadIntent = new Intent(MainActivity.this, Download.class);

                // Start the new activity
                startActivity(downloadIntent);
            }
        });


    }
}
