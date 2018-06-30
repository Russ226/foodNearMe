package com.example.russ.foodnearme.settings;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by russ on 6/28/18.
 */

public class UserSettings {
    private final static int RADIUS = 2;
    private final static String UNIT = "Kilometers";
    private static final String PREFERENCES_NAME = "Settings";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public UserSettings(Context context) {
        prefs = context.getSharedPreferences(PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public int getRADIUS() {
        return RADIUS;
    }

    public String getUNIT() {
        return UNIT;
    }

    public void setRADIUS(int radius){
        editor.putInt(String.valueOf(RADIUS), radius);
        editor.commit();
    }

    public void setUNIT(String unit){
        editor.putString(UNIT, unit);
        editor.commit();
    }




}
