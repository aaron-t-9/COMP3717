package com.bcit.aaron_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BreedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);

        Bundle extras;
        extras = getIntent().getExtras();

        Button btn1 = findViewById(R.id.button_breeds_breedOne);
        btn1.setText(extras.getString("btn1"));

        Button btn2 = findViewById(R.id.button_breeds_breedTwo);
        btn2.setText(extras.getString("btn2"));

        Button btn3 = findViewById(R.id.button_breeds_breedThree);
        btn3.setText(extras.getString("btn3"));
    }

    public void breedsButtonHandler(View view) {
        Intent intentFactsActivity = new Intent(this, FactsActivity.class);

        Bundle extras;
        extras = getIntent().getExtras();

        String prefix;
        boolean dogBtnClicked = extras.getBoolean("dog");
        if (dogBtnClicked) {
            prefix = "dog";
        }
        else {
            prefix = "cat";
        }

        if(view.getId() == R.id.button_breeds_breedOne) {
            extras.putString("prefix", prefix + "Fact1");
        }
        else if (view.getId() == R.id.button_breeds_breedTwo) {
            extras.putString("prefix", prefix + "Fact2");
        }
        else {
            extras.putString("prefix", prefix + "Fact3");
        }

        intentFactsActivity.putExtras(extras);
        startActivity(intentFactsActivity);
    }
}