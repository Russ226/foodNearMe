package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 6/27/18.
 */

public class Geometry {
    @SerializedName("location")
    private Location location;

    @SerializedName("viewport")
    private ViewPort viewPort;

    public Geometry(Location location, ViewPort viewPort) {
        this.location = location;
        this.viewPort = viewPort;
    }

    public Location getLocation() {
        return location;
    }

    public ViewPort getViewPort() {
        return viewPort;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "location=" + location +
                ", viewPort=" + viewPort +
                '}';
    }
}
