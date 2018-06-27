package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by russ on 6/27/18.
 */

public class Photo {
    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @SerializedName("html_attributions")
    private List<String> htmlAttributions;

    @SerializedName("photo_reference")
    private String photoReference;

    public Photo(int height, int width, List<String> htmlAttributions, String photoReference) {
        this.height = height;
        this.width = width;
        this.htmlAttributions = htmlAttributions;
        this.photoReference = photoReference;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "height=" + height +
                ", width=" + width +
                ", htmlAttributions=" + htmlAttributions +
                ", photoReference='" + photoReference + '\'' +
                '}';
    }
}
