package com.example.russ.foodnearme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by russ on 6/26/18.
 */

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private ArrayList<String> cuisines;
    private Context cuisineContext;


    public CuisineAdapter(@NonNull Context context){
        cuisineContext = context;
        createList();
    }


    @Override
    public CuisineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cuisineContext).inflate(R.layout.type_of_food_card, parent, false);
        return new CuisineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CuisineViewHolder holder, int position) {
        final String cuisine = cuisines.get(position);
        holder.cuisineName.setText(cuisine);
    }



    @Override
    public int getItemCount() {
        return cuisines.size();
    }

    private void createList(){
        cuisines = new ArrayList<>();

        cuisines.add("Burgers");
        cuisines.add("Chinese");
        cuisines.add("Korean");
        cuisines.add("BBQ");
        cuisines.add("Ramen");
        cuisines.add("Sushi");

    }

    class CuisineViewHolder extends RecyclerView.ViewHolder {
        TextView cuisineName;


        public CuisineViewHolder(View itemView) {
            super(itemView);
            cuisineName = (TextView) itemView.findViewById(R.id.cuisine_name);
        }
    }
}
