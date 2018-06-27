package com.example.russ.foodnearme.cuisine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.russ.foodnearme.R;
import com.example.russ.foodnearme.activities.NearByLocationsActivity;
import com.example.russ.foodnearme.restaurant.GooglePlacesURL;
import com.example.russ.foodnearme.restaurant.PlacesResult;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by russ on 6/26/18.
 */

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private ArrayList<Cuisine> cuisines;
    private Context cuisineContext;


    public CuisineAdapter(@NonNull Context context, ArrayList<Cuisine> cuisines){
        cuisineContext = context;
       this.cuisines = cuisines;
    }


    @Override
    public CuisineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cuisineContext).inflate(R.layout.type_of_food_card, parent, false);
        return new CuisineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CuisineViewHolder holder, int position) {
        final Cuisine cuisine = cuisines.get(position);

        holder.foodImg.setImageResource(cuisine.getImageSrc());
        holder.cuisineName.setText(cuisine.getName());



    }



    @Override
    public int getItemCount() {
        return cuisines.size();
    }



    class CuisineViewHolder extends RecyclerView.ViewHolder {
        TextView cuisineName;
        ImageView foodImg;

        public CuisineViewHolder(View itemView) {
            super(itemView);
            cuisineName = itemView.findViewById(R.id.cuisine_name);
            foodImg = itemView.findViewById(R.id.food_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;

                    switch ((String) cuisineName.getText()) {
                        case "Burgers":
                            intent = new Intent(view.getContext(), NearByLocationsActivity.class);
                            intent.putExtra("cuisine", "Burgers");
                            view.getContext().startActivity(intent);
                            break;
                        case "Chinese":
                            intent = new Intent(view.getContext(), NearByLocationsActivity.class);
                            intent.putExtra("cuisine", "Chinese");
                            view.getContext().startActivity(intent);
                            break;
                        case "Korean":
                            intent = new Intent(view.getContext(), NearByLocationsActivity.class);
                            intent.putExtra("cuisine", "Korean");
                            view.getContext().startActivity(intent);
                            break;
                        case "BBQ":
                            intent = new Intent(view.getContext(), NearByLocationsActivity.class);
                            intent.putExtra("cuisine", "BBQ");
                            view.getContext().startActivity(intent);
                            break;
                        case "Ramen":
                            intent = new Intent(view.getContext(), NearByLocationsActivity.class);
                            intent.putExtra("cuisine", "Ramen");
                            view.getContext().startActivity(intent);
                            break;
                        case "Sushi":
                            intent = new Intent(view.getContext(), NearByLocationsActivity.class);
                            intent.putExtra("cuisine", "Sushi");
                            view.getContext().startActivity(intent);
                            break;
                    }

                }
            });
        }

    }

}
