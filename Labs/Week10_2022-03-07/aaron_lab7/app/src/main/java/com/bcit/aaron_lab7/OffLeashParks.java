package com.bcit.aaron_lab7;

import java.util.ArrayList;
import java.util.Date;

public class OffLeashParks {

    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
    // import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
    /* ObjectMapper om = new ObjectMapper();
    Root root = om.readValue(myJsonString, Root.class); */

    public class Parameters{
        public String dataset;
        public int rows;
        public int start;
        public ArrayList<String> facet;
        public String format;
        public String timezone;
    }

    public class Geom{
        public ArrayList<ArrayList<ArrayList<Double>>> coordinates;
        public String type;
    }

    public class Fields{
        public String geo_local_area;
        public Geom geom;
        public String url;
        public String address;
        public String name;
    }

    public class Record{
        public String datasetid;
        public String recordid;
        public Fields fields;
        public Date record_timestamp;
    }

    public class Facet{
        public String name;
        public int count;
        public String state;
        public String path;
    }

    public class FacetGroup{
        public String name;
        public ArrayList<Facet> facets;
    }

    public class Root{
        public int nhits;
        public Parameters parameters;
        public ArrayList<Record> records;
        public ArrayList<FacetGroup> facet_groups;
    }

}
