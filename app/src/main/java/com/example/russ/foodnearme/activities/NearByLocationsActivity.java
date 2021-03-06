package com.example.russ.foodnearme.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.russ.foodnearme.R;
import com.example.russ.foodnearme.restaurant.GooglePlacesURL;
import com.example.russ.foodnearme.restaurant.PlacesResult;
import com.example.russ.foodnearme.restaurant.RestaurantAdapter;
import com.example.russ.foodnearme.restaurant.Result;
import com.example.russ.foodnearme.settings.UserLocation;
import com.example.russ.foodnearme.settings.UserSettings;

import org.w3c.dom.Text;


import java.util.ArrayList;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

import static java.lang.Math.floor;

public class NearByLocationsActivity extends AppCompatActivity {
    private RecyclerView restaurantView;
    private RestaurantAdapter restaurantAdapter;
    private Call<PlacesResult> getPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_locations);

        final UserLocation userLocation = new UserLocation(getApplicationContext());

        Bundle bundle = getIntent().getExtras();
        String cuisine = bundle.getString("cuisine");

        final UserSettings userSettings = new UserSettings(getApplicationContext());

        FloatingActionButton homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodChoice.class);
                startActivity(intent);
            }
        });



        final Context context = this;

        OkHttpClient httpClient = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(GooglePlacesURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient);

        final Retrofit retrofit = builder.build();

        final GooglePlacesURL requests = retrofit.create(GooglePlacesURL.class);
        if(userSettings.getUNIT() == "Kilometers"){
            getPlaces = requests.getRestaurants(String.valueOf(userLocation.getLatitude()) + ',' + String.valueOf(userLocation.getLongitude()), String.valueOf(userSettings.getRADIUS() * 1000), "restaurant", cuisine, "AIzaSyB60oq2EJuUpDw31a1Bg4v5QanRsNX_fN4");

        }else{
            getPlaces = requests.getRestaurants(String.valueOf(userLocation.getLatitude()) + ',' + String.valueOf(userLocation.getLongitude()), String.valueOf(Double.valueOf(userSettings.getRADIUS()) * 1609.34), "restaurant", cuisine, "AIzaSyB60oq2EJuUpDw31a1Bg4v5QanRsNX_fN4");

        }
        //System.out.println(getPlaces.request().url());
        getPlaces.enqueue(new Callback<PlacesResult>() {
            @Override
            public void onResponse(Call<PlacesResult> call, Response<PlacesResult> response) {
                ArrayList<Result> results = (ArrayList<Result>) response.body().getResults();
                findDistance(results, userLocation.getLatitude(), userLocation.getLongitude(), userSettings.getUNIT());
                Collections.sort(results);

                restaurantView = findViewById(R.id.restaurants_Recycler);
                restaurantAdapter =  new RestaurantAdapter(results, context);

                restaurantView.setAdapter(restaurantAdapter);
                restaurantView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<PlacesResult> call, Throwable t) {
                System.out.println(t);
            }
        });

    }

    public void findDistance(ArrayList<Result> results, double userLat, double userLong, String unit){
        for(Result loc: results){
            Location locLocation = new Location("");
            locLocation.setLatitude(loc.getGeometries().getLocation().getLat());
            locLocation.setLongitude(loc.getGeometries().getLocation().getLng());

            Location userLocation = new Location("");
            userLocation.setLatitude(userLat);
            userLocation.setLongitude(userLong);
            if(unit == "Kilometers"){
                loc.setDistance(floor(locLocation.distanceTo(userLocation) / 1000 ));
            }else{
                loc.setDistance(floor(locLocation.distanceTo(userLocation) * 0.000621371));
            }

        }
    }

}
