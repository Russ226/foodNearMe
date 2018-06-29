package com.example.russ.foodnearme.settings;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Menu;

import com.example.russ.foodnearme.R;

/**
 * Created by russ on 6/29/18.
 */

public class UserLocation implements LocationListener {
    double latitude, longitude;

    public UserLocation(Context context) {


        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

       latitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude();
       longitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude();
    }

    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub

        latitude = location.getLatitude();
        longitude = location.getLongitude();


    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return String.valueOf(latitude + ',' + longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

