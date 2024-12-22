package com.example.doctor.models;

public class Category {
    private int id; // Unique identifier for the category
    private String name; // Name of the category
    private int imageResId; // Resource ID for the category image

    public Category(int id, String name, int imageResId) {
        this.id = id;
        this.name = name;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
