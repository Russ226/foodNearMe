package com.example.russ.foodnearme.activities;

import android.content.Context;
import android.content.Intent;
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

import org.w3c.dom.Text;


import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NearByLocationsActivity extends AppCompatActivity {
    private RecyclerView restaurantView;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_locations);

        Bundle bundle = getIntent().getExtras();
        String cuisine = bundle.getString("cuisine");

        final Context context = this;

        OkHttpClient httpClient = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(GooglePlacesURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient);

        final Retrofit retrofit = builder.build();



        final GooglePlacesURL requests = retrofit.create(GooglePlacesURL.class);
        Call<PlacesResult> getPlaces = requests.getRestaurants("38.928486,-77.032961", "8000", "restaurant", "chinese", "AIzaSyB60oq2EJuUpDw31a1Bg4v5QanRsNX_fN4");
        getPlaces.enqueue(new Callback<PlacesResult>() {
            @Override
            public void onResponse(Call<PlacesResult> call, Response<PlacesResult> response) {
                restaurantView = findViewById(R.id.restaurants_Recycler);
                restaurantAdapter =  new RestaurantAdapter((ArrayList<Result>) response.body().getResults(), context);

                restaurantView.setAdapter(restaurantAdapter);
                restaurantView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<PlacesResult> call, Throwable t) {
                System.out.println(t);
            }
        });

    }

}