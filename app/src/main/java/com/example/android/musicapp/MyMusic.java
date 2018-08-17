package com.example.android.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class MyMusic extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create an array of songs
        ArrayList<Song> songs = new ArrayList<>();

        //songs.add("one");
        songs.add(new Song("Ed Sheeran", "Perfect"));
        songs.add(new Song("Meganoidi", "Zeta Reticoli"));
        songs.add(new Song("Cecilia Krull", "My life is going on"));
        songs.add(new Song("Baby k", "Da zero a cento"));
        songs.add(new Song("J-AX, Fedez", "Italiana"));
        songs.add(new Song("Alvaro Soler", "La Cintura"));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        list = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for (Field field : fields) list.add(field.getName());
        {


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    if (mediaPlayer != null) {
                        mediaPlayer.release();
                    }

                    int resID = getResources().getIdentifier(list.get(i), getPackageName(), String.valueOf(R.raw.over_the_horizon));
                    mediaPlayer = MediaPlayer.create(MyMusic.this, resID);
                    mediaPlayer.start();
                }
            });
        }
    }
}


