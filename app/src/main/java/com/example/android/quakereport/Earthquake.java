package com.example.android.quakereport;

/**
 * Created by fernando.fischer on 21/06/2017.
 */

public class Earthquake {

    private String magnitude;
    private String location;
    private long date;

    public Earthquake(String magnitude, String location, long date) {
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
