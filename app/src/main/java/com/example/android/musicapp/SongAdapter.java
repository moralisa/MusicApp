package com.example.android.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        Song currentSong = getItem(position);
        TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);

        assert currentSong != null;
        artistTextView.setText(currentSong.getDefaultSinger());

        TextView songTextView = listItemView.findViewById(R.id.song_text_view);

        songTextView.setText(currentSong.getDefaultSong());

        return listItemView;
    }

}