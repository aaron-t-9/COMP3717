package com.bcit.aaron_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Hippo> hippos = new ArrayList<>();

        Hippo jerry = new Hippo("Jerry", 7, "Peanuts", R.drawable.hippo1);
        Hippo matilda = new Hippo("Matilda", 1, "Bananas", R.drawable.hippo2);
        Hippo allison = new Hippo("Allison", 12, "Coconuts", R.drawable.hippo3);
        Hippo craig = new Hippo("Craig", 2, "Potatoes", R.drawable.hippo4);

        hippos.add(jerry);
        hippos.add(matilda);
        hippos.add(allison);
        hippos.add(craig);

        setupSpinner(hippos);

        Button infoBtn = findViewById(R.id.button_main_fullInv);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInv(view, hippos);
            }
        });
    }

    void setupSpinner(ArrayList<Hippo> hippos) {

        Spinner spinner = findViewById(R.id.spinner_main_hippoNames);
        ArrayList<String> hippoNames = new ArrayList<>();

        for (int index = 0; index < hippos.size(); index++) {
            hippoNames.add(hippos.get(index).getName());
        }


        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hippoNames);
        spinner.setAdapter(arrAdapter);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    String hippotest = hippos.get(1).getName();


                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long rowId) {
                        String hippoName = hippoNames.get(position);
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


                        Fragment previewFrag = PreviewFragment.newInstance(hippos.get(position));
                        fragmentTransaction.replace(R.id.fragment_main_preview, previewFrag);


                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                }
        );}

        public void goToInv(View view, ArrayList<Hippo> hippos) {
            Intent intent = new Intent(this, InventoryActivity.class);

            Bundle extras = new Bundle();

            extras.putSerializable("HIPPO_ARR", (Serializable) hippos);
            intent.putExtras(extras);

            startActivity(intent);
        }
}