package com.example.russ.foodnearme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FoodChoice extends AppCompatActivity {
    private RecyclerView cuisinesView;
    private CuisineAdapter cuisineAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_choice);


        cuisinesView = findViewById(R.id.types_Recycler);
        cuisineAdapter= new CuisineAdapter(this);

        cuisinesView.setAdapter(cuisineAdapter);
        cuisinesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

}
