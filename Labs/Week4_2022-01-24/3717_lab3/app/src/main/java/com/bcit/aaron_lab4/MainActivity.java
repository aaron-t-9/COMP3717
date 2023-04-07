package com.bcit.aaron_lab4;

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

        if (view.getId() == R.id.button_main_dogs) {
            extras.putString("btn1", "Shiba Inu");
            extras.putString("btn2", "Corgi");
            extras.putString("btn3", "Pug");
        }
        else {
            extras.putString("btn1", "Bengal Cat");
            extras.putString("btn2", "Siamese");
            extras.putString("btn3", "Ragdoll");
        }
        intentBreedsActivity.putExtras(extras);
        startActivity(intentBreedsActivity);


    }
}