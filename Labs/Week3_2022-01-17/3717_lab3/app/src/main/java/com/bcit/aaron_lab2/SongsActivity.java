package com.bcit.aaron_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        setupSpinner();
    }

    public void setupSpinner() {
        Spinner spinner = findViewById(R.id.spinner_songs_favSongs);
        Intent intent = getIntent();

        Integer button_pressed = intent.getIntExtra(MainActivity.SONG_LIST, 0);
        if (button_pressed == 2) {
            ArrayAdapter<CharSequence> arrAdapter = ArrayAdapter.createFromResource(this, R.array.songListTwo, R.layout.support_simple_spinner_dropdown_item);
            arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(arrAdapter);
        }
        else{
            ArrayList<String> songListOne = intent.getStringArrayListExtra(MainActivity.SONG_LIST);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, songListOne);
            spinner.setAdapter(arrayAdapter);
        }

    }
}