package com.onevizion.booksonevizion.models;

public class SortModel {
    private String[] properties;
    private String type;

    public SortModel(String[] properties, String type) {
        this.properties = properties;
        this.type = type;
    }

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
