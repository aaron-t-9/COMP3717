package com.bcit.aaron_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// COMP 3717 - Week 2, Lab 1: Colorized Text

// Aaron

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void colorizeBlue(View view) {
        TextView textInput = findViewById(R.id.textView_main_colorizedText);
        EditText editText = findViewById(R.id.editText_main_textToColorize);

        String str = editText.getText().toString();

        if(str.equals("")) {
            textInput.setText("Enter some text!");
            textInput.setTextColor(Color.BLACK);
        }
        else {
            textInput.setText(str);
            textInput.setTextColor(Color.BLUE);
        }
    }

    public void colorizeRed(View view) {
        TextView textInput = findViewById(R.id.textView_main_colorizedText);
        EditText editText = findViewById(R.id.editText_main_textToColorize);

        String str = editText.getText().toString();

        if(str.equals("")) {
            textInput.setText("Enter some text!");
            textInput.setTextColor(Color.BLACK);
        }
        else {
            textInput.setText(str);
            textInput.setTextColor(Color.RED);
        }
    }

    public void colorizeGreen(View view) {
        TextView textInput = findViewById(R.id.textView_main_colorizedText);
        EditText editText = findViewById(R.id.editText_main_textToColorize);

        String str= editText.getText().toString();

        if(str.equals("")) {
            textInput.setText("Enter some text!");
            textInput.setTextColor(Color.BLACK);
        }
        else {
            textInput.setText(str);
            textInput.setTextColor(Color.GREEN);
        }
    }

    public void clearText(View view) {
        TextView textInput = findViewById(R.id.textView_main_colorizedText);
        textInput.setText("");
    }
}