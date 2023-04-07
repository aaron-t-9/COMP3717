package com.bcit.aaron_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public static final String SONG_LIST = "com.bcit.aaron_lab2.one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void songButtonDirectory(View view) {
        Intent songsActivity = new Intent(this, SongsActivity.class);

        if (view.getId() == R.id.button_main_songs1) {

            ArrayList<CharSequence> songListOne = new ArrayList<>();
            songListOne.add("Never Gonna Give You Up");
            songListOne.add("Stayin' Alive");
            songListOne.add("Take On Me");
            songListOne.add("Eye of the Tiger");
            songListOne.add("I Ran (So Far Away)");

            songsActivity.putCharSequenceArrayListExtra(SONG_LIST, songListOne);
        }
        else {
            songsActivity.putExtra(SONG_LIST, 2);
        }

        startActivity(songsActivity);
    }
}