package com.example.russ.foodnearme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.russ.foodnearme.R;

import org.w3c.dom.Text;

public class NearByLocationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_locations);

        Bundle bundle = getIntent().getExtras();
        TextView cuisneName = (TextView)findViewById(R.id.test_text);
        cuisneName.setText(bundle.get("cuisine").toString());
    }

}
