package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 6/27/18.
 */

public class ViewPort {
    @SerializedName("northeast")
    private Location northEast;

    @SerializedName("southwest")
    private Location southWest;

    public ViewPort(Location northEast, Location southWest) {
        this.northEast = northEast;
        this.southWest = southWest;
    }

    public Location getNorthEast() {
        return northEast;
    }

    public Location getSouthWest() {
        return southWest;
    }

    @Override
    public String toString() {
        return "ViewPort{" +
                "northEast=" + northEast +
                ", southWest=" + southWest +
                '}';
    }
}
