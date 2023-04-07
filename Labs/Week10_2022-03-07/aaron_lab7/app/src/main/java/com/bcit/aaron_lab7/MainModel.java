package com.bcit.aaron_lab7;

import java.util.List;

public class MainModel {    // fetches our data from the API and parses it, e.g. URL/DB/API management, get/post data

    List<OffLeashParks.Record> data;

    public MainModel(List<OffLeashParks.Record> data) {
        this.data = data;
    }

    public List<OffLeashParks.Record> getData() {
        return data;
    }
}
