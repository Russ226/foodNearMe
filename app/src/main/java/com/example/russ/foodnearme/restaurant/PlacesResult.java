package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by russ on 6/26/18.
 */

public class PlacesResult {
    @SerializedName("html_attributions")
    private String[] htmlAttributes;

    @SerializedName("results")
    private List<Result> results;

    @SerializedName("status")
    private String status;

    public PlacesResult(String[] htmlAttributes, List<Result> results, String status) {
        this.htmlAttributes = htmlAttributes;
        this.results = results;
        this.status = status;
    }

    public String[] getHtmlAttributes() {
        return htmlAttributes;
    }

    public List<Result> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }
}

class Result{

    @SerializedName("geometry")
    private List<Geometry> geometries;

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

    public Result(List<Geometry> geometries, String icon, String id, String name, OpenHours openHours, List<Photo> photos, String placeID, PlusCode plusCode, String rating, String reference, String scope, List<String> types, String vicinity) {
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

    public List<Geometry> getGeometries() {
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
}


class Geometry{

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
}

class Location{
    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}

class ViewPort{
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
}

class OpenHours {
    @SerializedName("open_now")
    private boolean openNow;

    public OpenHours(boolean openNow) {
        this.openNow = openNow;
    }

    public boolean isOpenNow() {
        return openNow;
    }
}

class Photo{
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
}
class PlusCode{

    @SerializedName("compound_code")
    private String compoundCode;

    @SerializedName("global_code")
    private String globalCode;

    public PlusCode(String compoundCode, String globalCode) {
        this.compoundCode = compoundCode;
        this.globalCode = globalCode;
    }

    public String getCompoundCode() {
        return compoundCode;
    }

    public String getGlobalCode() {
        return globalCode;
    }
}