package com.example.doctor.models;

import com.example.doctor.models.Doctor;

import java.util.Date;

public class Reservation {
    private Doctor doctor;
    private Date date;
    private String time;

    public Reservation(Doctor doctor, Date date, String time) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
