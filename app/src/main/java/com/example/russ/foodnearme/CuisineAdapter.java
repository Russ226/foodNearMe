package com.example.russ.foodnearme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by russ on 6/26/18.
 */

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private ArrayList<Cuisine> cuisines;
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
        final Cuisine cuisine = cuisines.get(position);
        holder.foodImg.setImageResource(cuisine.getImageSrc());
        holder.cuisineName.setText(cuisine.getName());


    }



    @Override
    public int getItemCount() {
        return cuisines.size();
    }

    private void createList(){
        cuisines = new ArrayList<>();

        cuisines.add(new Cuisine("Burgers", R.drawable.burger));
        cuisines.add(new Cuisine("Chinese", R.drawable.chinese));
        cuisines.add(new Cuisine("Korean", R.drawable.korean));
        cuisines.add(new Cuisine("BBQ", R.drawable.bbq));
        cuisines.add(new Cuisine("Ramen", R.drawable.ramen));
        cuisines.add(new Cuisine("Sushi", R.drawable.sushi));

    }

    class CuisineViewHolder extends RecyclerView.ViewHolder {
        TextView cuisineName;
        ImageView foodImg;

        public CuisineViewHolder(View itemView) {
            super(itemView);
            cuisineName = (TextView) itemView.findViewById(R.id.cuisine_name);
            foodImg = (ImageView) itemView.findViewById(R.id.food_img);
        }
    }
}
