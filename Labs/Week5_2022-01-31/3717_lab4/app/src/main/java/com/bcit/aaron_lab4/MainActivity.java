package com.bcit.aaron_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }

    void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView_main);

        String[] items = {"1", "2", "3", "4", "5"};

        ItemSwitchy itemSwitchyAdapter = new ItemSwitchy(items);
        recyclerView.setAdapter(itemSwitchyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
