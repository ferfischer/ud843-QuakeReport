package com.example.android.quakereport;

/**
 * Created by fernando.fischer on 21/06/2017.
 */

public class Earthquake {

    private String magnitude;
    private String location;
    private String date;

    public Earthquake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
