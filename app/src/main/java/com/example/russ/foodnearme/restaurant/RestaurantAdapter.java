package com.example.russ.foodnearme.restaurant;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.russ.foodnearme.R;
import com.example.russ.foodnearme.cuisine.CuisineAdapter;
import com.example.russ.foodnearme.settings.UserSettings;

import java.util.ArrayList;

/**
 * Created by russ on 6/27/18.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private ArrayList<Result> places;

    private Context restaurantContext;

    public RestaurantAdapter(@NonNull ArrayList<Result> places, Context restaurantContext) {
        this.places = places;
        this.restaurantContext = restaurantContext;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(restaurantContext).inflate(R.layout.restaurant_cards, parent, false);
        return new RestaurantAdapter.RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        final Result result = places.get(position);
        UserSettings userSettings = new UserSettings(restaurantContext);

        holder.name.setText(result.getName());
        holder.address.setText(result.getVicinity());
        if(result.getOpenHours().isOpenNow()){
            holder.isOpen.setText("Open Now");
        }else{
            holder.isOpen.setText("Closed");
        }
        if(userSettings.getUNIT() == "Kilometers") {
            if (result.getDistance() < 1) {
                holder.distance.setText("< 1.0 KM");
            } else {
                holder.distance.setText(result.getDistance().toString() + " KM");
            }
        }else{
            if (result.getDistance() < 1) {
                holder.distance.setText("< 1.0 M");
            } else {
                holder.distance.setText(result.getDistance().toString() + " M");
            }
        }

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        TextView address;

        TextView isOpen;

        TextView googleMaps;

        TextView distance;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_of_restaurant);
            address = itemView.findViewById(R.id.address);
            isOpen = itemView.findViewById(R.id.open);
            distance = itemView.findViewById(R.id.distance);

            googleMaps = itemView.findViewById(R.id.google_maps);
            googleMaps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("google.navigation:q=" + address.getText().toString()));
                    restaurantContext.startActivity(intent);
                }
            });
        }

        public TextView getName() {
            return name;
        }

        public TextView getAddress() {
            return address;
        }

        public TextView getIsOpen() {
            return isOpen;
        }


    }
}
