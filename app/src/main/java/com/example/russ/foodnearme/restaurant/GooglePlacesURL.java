package com.example.russ.foodnearme.restaurant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by russ on 6/26/18.
 */

public interface GooglePlacesURL {

    String BASE_URL = "https://maps.googleapis.com";

    @GET("/maps/api/place/nearbysearch/json")
    Call<PlacesResult> getRestaurants(@Query("location") String location,@Query("radius") String radius, @Query("type") String type, @Query("keyword") String keyword, @Query("key") String key);

}
