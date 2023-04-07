package com.bcit.aaron_lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    /*
    I can't seem to load the JSON from the API, I'm only receiving null values. I'm using the HttpHandler.java from lecture this week and I'm not sure how to proceed, thanks!
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // crate MainPresenter and MainModel objects
        // get reference to oyr RecyclerView and set the LayoutManager for it, doesn't need an adapter for it yet cause we don't have data for it
        // MainPresenter object should call the getDataFromModel method

        String url = "https://opendata.vancouver.ca/api/records/1.0/search/?dataset=dog-off-leash-parks&q=&facet=geo_local_area";
        Future<String> request = createHttpRequestForJson(url);

        String data = null;
        try {
            data = request.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("MainActivity", data);
        ArrayList<OffLeashParks.Record> offLeashParks = parseJson(data);
        List<OffLeashParks.Record> areas = new ArrayList<>(offLeashParks);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_main_offLeashParks);
        ParksAdapter parksAdapter = new ParksAdapter(areas);

        recyclerView.setAdapter(parksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MainModel mainModel = new MainModel(areas);

        MainPresenter mainPresenter = new MainPresenter(this, mainModel);
        mainPresenter.getDataFromModel();


    }

    @Override
    public void onUpdateRecycler(List<OffLeashParks.Record> areas) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView_main_offLeashParks);
        ParksAdapter parksAdapter = new ParksAdapter(areas);

        recyclerView.setAdapter(parksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    Future<String> createHttpRequestForJson(String url) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        HttpHandler<String> httpHandler = new HttpHandler<>(url, false);   // constructor requries URL and whether it's an image or JSON

        return executorService.submit((Callable<String>) httpHandler);    // starts the second thread; httpHandler class is callable
    }

    ArrayList<OffLeashParks.Record> parseJson(String jsonStr) {

        if (jsonStr != null) {
            Log.d("MainActivity", jsonStr);
            Gson gson = new Gson();
            OffLeashParks.Root offLeashParks = gson.fromJson(jsonStr, OffLeashParks.Root.class);
            return offLeashParks.records;
        }
        else {
            Log.e("MainActivity", "json is null");  // .e for errors
            return null;
        }
    }
}