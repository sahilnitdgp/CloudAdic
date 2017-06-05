package com.example.sahil.cloudadic;


import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    Typeface weatherFont;

    TextView cityField;
    TextView updateField;
    TextView detailsField;
    TextView currentTemperaturreField;
    TextView weatherIcon;

    Handler handler;


    public WeatherFragment() {
        // Required empty public constructor
        handler = new Handler();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        weatherFont = Typeface.createFromAsset(getActivity().getAssets(),"weather.ttf");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_weather,container,false);

      //  cityField = (TextView)rootView.findViewById(R.id.city_field);
      //  updateField = (TextView)rootView.findViewById(R.id.update_field);
       // detailsField = (TextView)rootView.findViewById(R.id.details_field);
       // currentTemperaturreField = (TextView)rootView.findViewById(R.id.current_temperature_field);
      //  weatherIcon = (TextView)rootView.findViewById(R.id.weather_icon);

        weatherIcon.setTypeface(weatherFont);
        return rootView;
    }

}
