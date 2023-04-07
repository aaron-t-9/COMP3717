package com.bcit.aaron_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonHandler(View view) {

        Intent intentBreedsActivity = new Intent(this, BreedsActivity.class);
        Bundle extras = new Bundle();

        extras.putString("dogFact1", "Shiba Inu's curled tail helps them retain body heat.");
        extras.putString("dogFact2", "Corgi's have two coats of fur to keep them warm.");
        extras.putString("dogFact3", "The pug is one of the oldest dog breeds.");

        extras.putString("catFact1", "Bengal cats love to play in water.");
        extras.putString("catFact2", "Siamese cats love to talk and meow.");
        extras.putString("catFact3", "Ragdoll cats go completely limp when picked up.");

        if (view.getId() == R.id.button_main_dogs) {
            extras.putBoolean("dog", true);

            extras.putString("btn1", "Shiba Inu");
            extras.putString("btn2", "Corgi");
            extras.putString("btn3", "Pug");
        }
        else {
            extras.putBoolean("dog", false);

            extras.putString("btn1", "Bengal Cat");
            extras.putString("btn2", "Siamese");
            extras.putString("btn3", "Ragdoll");
        }
        intentBreedsActivity.putExtras(extras);
        startActivity(intentBreedsActivity);
    }
}