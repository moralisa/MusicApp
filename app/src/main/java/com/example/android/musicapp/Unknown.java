package com.example.android.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Unknown extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create an array of songs
        final ArrayList<Song> songs = new ArrayList<>();

        //songs.add("one");
        songs.add(new Song ("Astrid S", "Such a Boy"));
        songs.add(new Song("Dagny", "Love You Like That"));
        songs.add(new Song("Sonny alven", "You Touch"));

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
                mediaPlayer = MediaPlayer.create(Unknown.this, resID);
                mediaPlayer.start();
            }
        });
    }
}


