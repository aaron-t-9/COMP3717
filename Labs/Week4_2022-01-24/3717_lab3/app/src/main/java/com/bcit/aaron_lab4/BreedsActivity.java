package com.bcit.aaron_lab4;

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
    }

    public void breedsButtonHandler(View view) {
        Bundle extras;
        Bundle funFacts = new Bundle();
        extras = getIntent().getExtras();

//       Button btn = findViewById(R.id.button_breeds_breedOne);
//       String str = btn.getText().toString();
//        System.out.println(str);

        extras.getString();
                button.setText();
        if(view.getId() == R.id.button_breeds_breedOne) {
            System.out.println(extras.getString("btn1"));
        }
        else if (view.getId() == R.id.button_breeds_breedTwo) {
            System.out.println(extras.getString("btn2"));
        }
        else {
            System.out.println(extras.getString("btn3"));
        }



    }
}