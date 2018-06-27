package com.example.russ.foodnearme.restaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.russ.foodnearme.R;

import java.util.ArrayList;

/**
 * Created by russ on 6/27/18.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private ArrayList<PlacesResult> places;

    private Context restaurantContext;

    public RestaurantAdapter(@NonNull ArrayList<PlacesResult> places, Context restaurantContext) {
        this.places = places;
        this.restaurantContext = restaurantContext;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        TextView address;

        TextView isOpen;


        public RestaurantViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_of_restaurant);
            address = itemView.findViewById(R.id.address);
            isOpen = itemView.findViewById(R.id.open);
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
