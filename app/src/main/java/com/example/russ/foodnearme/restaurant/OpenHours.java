package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 6/27/18.
 */

public class OpenHours {
    @SerializedName("open_now")
    private boolean openNow;

    public OpenHours(boolean openNow) {
        this.openNow = openNow;
    }

    public boolean isOpenNow() {
        return openNow;
    }

    @Override
    public String toString() {
        return "OpenHours{" +
                "openNow=" + openNow +
                '}';
    }
}
