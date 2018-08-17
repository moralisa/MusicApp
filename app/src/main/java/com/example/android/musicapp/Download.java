package com.example.android.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Download extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create an array of songs
        final ArrayList<Song> songs = new ArrayList<>();

        //songs.add("one");
        songs.add(new Song("The Black Eyed Peas", "Light Up The Night"));
        songs.add(new Song("Ed Sheeran", "Perfect"));
        songs.add(new Song("Meganoidi", "Zeta Reticoli"));
        songs.add(new Song("Cecilia Krull", "My life is going on"));
        songs.add(new Song("Boy", "La La La"));

        SongAdapter adapter = new SongAdapter(this, songs);

        final ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }

                int resID = getResources().getIdentifier(list.get(position), String.valueOf(R.raw.over_the_horizon), getPackageName());
                mediaPlayer = MediaPlayer.create(Download.this, resID);
                mediaPlayer.start();
            }
        });
    }
}



