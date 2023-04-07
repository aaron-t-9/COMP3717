package com.bcit.aaron_lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ocean pacific = new Ocean("Pacific", 700085);
        Ocean atlantic = new Ocean("Atlantic", 700013);
        Ocean indian = new Ocean("Indian", 700057);

        Fragment pacificFrag = OceanFragment.newInstance(pacific);
        Fragment atlanticFrag = OceanFragment.newInstance(atlantic);
        Fragment indianFrag = OceanFragment.newInstance(indian);

        Fragment pacificFragFact = FactsFragment.newInstance(pacific);
        Fragment atlanticFragFact = FactsFragment.newInstance(atlantic);
        Fragment indianFragFact = FactsFragment.newInstance(indian);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main_ocean, pacificFrag);
        fragmentTransaction.replace(R.id.fragment_main_facts, pacificFragFact);
        fragmentTransaction.commit();


        Button nextBtn = findViewById(R.id.button_main_next);
        nextBtn.setOnClickListener(new View.OnClickListener() {



            int buttonTracker = 0;

            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                if (buttonTracker == 0) {
                    fragmentTransaction.replace(R.id.fragment_main_ocean, atlanticFrag);
                    fragmentTransaction.replace(R.id.fragment_main_facts, atlanticFragFact);
                    buttonTracker++;
                }
                else if (buttonTracker == 1) {
                    fragmentTransaction.replace(R.id.fragment_main_ocean, indianFrag);
                    fragmentTransaction.replace(R.id.fragment_main_facts, indianFragFact);

                    buttonTracker++;
                }
                else if (buttonTracker == 2) {
                    fragmentTransaction.replace(R.id.fragment_main_ocean, pacificFrag);
                    fragmentTransaction.replace(R.id.fragment_main_facts, pacificFragFact);

                    buttonTracker = 0;
                }

                fragmentTransaction.commit();
            }
        });
    }
}