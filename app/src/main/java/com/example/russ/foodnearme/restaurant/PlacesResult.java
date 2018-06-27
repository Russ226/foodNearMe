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
