package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by russ on 6/27/18.
 */

public class Result {
    @SerializedName("geometry")
    private Geometry geometries;

    @SerializedName("icon")
    private String icon;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("opening_hours")
    private OpenHours openHours;

    @SerializedName("photos")
    private List<Photo> photos;

    @SerializedName("place_id")
    private String placeID;

    @SerializedName("plus_code")
    private PlusCode plusCode;

    @SerializedName("rating")
    private String rating;

    @SerializedName("reference")
    private String reference;

    @SerializedName("scope")
    private String scope;

    @SerializedName("types")
    private List<String> types;

    @SerializedName("vicinity")
    private String vicinity;

    public Result(Geometry geometries, String icon, String id, String name, OpenHours openHours, List<Photo> photos, String placeID, PlusCode plusCode, String rating, String reference, String scope, List<String> types, String vicinity) {
        this.geometries = geometries;
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.openHours = openHours;
        this.photos = photos;
        this.placeID = placeID;
        this.plusCode = plusCode;
        this.rating = rating;
        this.reference = reference;
        this.scope = scope;
        this.types = types;
        this.vicinity = vicinity;
    }

    public Geometry getGeometries() {
        return geometries;
    }

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OpenHours getOpenHours() {
        return openHours;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public String getPlaceID() {
        return placeID;
    }

    public PlusCode getPlusCode() {
        return plusCode;
    }

    public String getRating() {
        return rating;
    }

    public String getReference() {
        return reference;
    }

    public String getScope() {
        return scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getVicinity() {
        return vicinity;
    }

    @Override
    public String toString() {
        return "Result{" +
                "geometries=" + geometries +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", openHours=" + openHours +
                ", photos=" + photos +
                ", placeID='" + placeID + '\'' +
                ", plusCode=" + plusCode +
                ", rating='" + rating + '\'' +
                ", reference='" + reference + '\'' +
                ", scope='" + scope + '\'' +
                ", types=" + types +
                ", vicinity='" + vicinity + '\'' +
                '}';
    }
}
