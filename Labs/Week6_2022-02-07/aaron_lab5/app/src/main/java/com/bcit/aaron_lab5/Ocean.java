package com.bcit.aaron_lab5;

import java.io.Serializable;

public class Ocean implements Serializable {

    private String name;
    private int resourceId;

    public Ocean(String name, int resourceId) {
        this.name = name;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public int getResourceId() {
        return resourceId;
    }
}
