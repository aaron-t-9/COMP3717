package com.bcit.aaron_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        Bundle extras;
        extras = getIntent().getExtras();

        TextView textView = findViewById(R.id.textView_facts_funFact);
        String prefix = extras.getString("prefix");
        String factToDisplay = extras.getString(prefix);
        textView.setText(factToDisplay);

        ImageView imageView = findViewById(R.id.imageView_fact_breedImage);
        System.out.println(factToDisplay);

        switch (prefix) {
            case "dogFact2":
                imageView.setImageResource(R.drawable.corgi);
                break;
            case "dogFact3":
                imageView.setImageResource(R.drawable.pug);
                break;
            case "catFact1":
                imageView.setImageResource(R.drawable.bengal);
                break;
            case "catFact2":
                imageView.setImageResource(R.drawable.siamese);
                break;
            case "catFact3":
                imageView.setImageResource(R.drawable.ragdoll);
                break;
        }

    }
}