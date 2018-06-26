package com.example.russ.foodnearme;

/**
 * Created by russ on 6/26/18.
 */

public class Cuisine {
    private String name;
    private int imageSrc;

    public Cuisine(String name, int imageSrc) {
        this.name = name;
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public int getImageSrc() {
        return imageSrc;
    }
}
