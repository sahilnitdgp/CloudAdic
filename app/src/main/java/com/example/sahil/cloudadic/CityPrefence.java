package com.example.sahil.cloudadic;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by SAHIL on 6/4/2017.
 */

public class CityPrefence {

    SharedPreferences prefs;

    public CityPrefence(Activity activity)
    {
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    String getCity()
    {
        return prefs.getString("city","sydney , AU");

    }
    void setCity(String city)
    {
        prefs.edit().putString("city",city).commit();
    }
}
