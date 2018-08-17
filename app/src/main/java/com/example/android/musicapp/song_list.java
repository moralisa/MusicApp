package com.example.android.musicapp;

class Song {

    private String mDefaultSinger;

    private String mDafaultSong;

    public Song(String defaultSinger, String defaultSong) {
        mDefaultSinger = defaultSinger;
        mDafaultSong = defaultSong;
    }

    public String getDefaultSinger() {
        return mDefaultSinger;
    }

    public String getDefaultSong() {
        return mDafaultSong;
    }
}

