package com.example.russ.foodnearme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.example.russ.foodnearme.R;
import com.example.russ.foodnearme.cuisine.Cuisine;
import com.example.russ.foodnearme.cuisine.CuisineAdapter;

import java.util.ArrayList;

public class FoodChoice extends AppCompatActivity {
    private RecyclerView cuisinesView;
    private CuisineAdapter cuisineAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_choice);


        cuisinesView = findViewById(R.id.types_Recycler);
        cuisineAdapter= new CuisineAdapter(this, createList());

        cuisinesView.setAdapter(cuisineAdapter);
        cuisinesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FloatingActionButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });




    }

    private ArrayList<Cuisine> createList(){
        ArrayList<Cuisine> cuisines = new ArrayList<>();

        cuisines.add(new Cuisine("Burgers", R.drawable.burger));
        cuisines.add(new Cuisine("Chinese", R.drawable.chinese));
        cuisines.add(new Cuisine("Korean", R.drawable.korean));
        cuisines.add(new Cuisine("BBQ", R.drawable.bbq));
        cuisines.add(new Cuisine("Ramen", R.drawable.ramen));
        cuisines.add(new Cuisine("Sushi", R.drawable.sushi));

        return cuisines;

    }

}
