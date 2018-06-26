package com.example.russ.foodnearme.restaurant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by russ on 6/26/18.
 */

public interface GooglePlacesURL {

    String BASE_RUL = "https://maps.googleapis.com";

    @GET("/maps/api/place/radarsearch/json")
    Call<ResponseBody> getRestaurants(@Query("location") String location, @Query("type") String type, @Query("keyword") String keyword, @Query("key") String key);

}
