package com.example.android3homework2.model;

import java.io.Serializable;

public class MainModel implements Serializable {
    public String name;
    public String description;

    public MainModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
