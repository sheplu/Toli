package com.oromys.sheplu.toli;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stats);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String value = extra.getString("note_paul");
            Integer value2 = extra.getInt("note_miche");

            TextView paul = (TextView) findViewById(R.id.paul);
            paul.setText(value);
            TextView miche = (TextView) findViewById(R.id.miche);
            miche.setText(value2.toString());
        }

        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

        ArrayList<LocationProvider> providers =
                new ArrayList<LocationProvider>();

        List<String> noms = locationManager.getProviders(true);

        for (String nom : noms) {
            providers.add(locationManager.getProvider(nom));
        }

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(criteria.POWER_HIGH);
        criteria.setSpeedRequired(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                60000, 150, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Log.d("GPS", "Latitude: " + location.getLatitude());
                        Log.d("GPS", "Longitude: " + location.getLongitude());
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                });

    }
}
