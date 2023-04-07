package com.bcit.aaron_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


//        Intent intent = getIntent();
//        Bundle args = intent.getBundleExtra("BUNDLE");

        ArrayList<Hippo> hippos = (ArrayList<Hippo>) getIntent().getSerializableExtra("HIPPO_ARR");
        System.out.println(hippos.get(0));


        RecyclerView recyclerView = findViewById(R.id.recyclerView_inv);


        InventoryViewAdapter invAdapter = new InventoryViewAdapter(hippos);
        recyclerView.setAdapter(invAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}