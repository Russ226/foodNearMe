package com.example.russ.foodnearme.activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.russ.foodnearme.R;
import com.example.russ.foodnearme.settings.UserSettings;

import org.w3c.dom.Text;

public class Settings extends AppCompatActivity{
    private TextView radius;

//    CheckBox miles = (CheckBox)findViewById(R.id.checkbox_miles);
//    CheckBox meters = (CheckBox)findViewById(R.id.checkbox_meters);
    String unit;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final EditText edit = (EditText)findViewById(R.id.radius_input);

        final Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSettings userSettings = new UserSettings(getApplicationContext());
                userSettings.setRADIUS(Integer.valueOf(edit.toString()));
                userSettings.setUNIT(unit);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        final Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }




    public void onCheckboxClicked(View view) {

        switch (view.getId()){
            case R.id.checkbox_meters:
                RadioButton meters = findViewById(R.id.checkbox_meters);
                if(meters.isChecked()){
                    unit = "Meters";
                }

                break;

            case R.id.checkbox_miles:
                RadioButton miles = findViewById(R.id.checkbox_miles);
                if(miles.isChecked()){
                    unit = "Miles";
                }

                break;

        }
    }
}
