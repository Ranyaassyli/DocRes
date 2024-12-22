package com.example.doctor.models;

public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private float rating;
    private int profileImageResId;

    public Doctor(int id, String name, String specialty, float rating, int profileImageResId) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.rating = rating;
        this.profileImageResId = profileImageResId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public float getRating() {
        return rating;
    }

    public int getProfileImageResId() {
        return profileImageResId;
    }
}
