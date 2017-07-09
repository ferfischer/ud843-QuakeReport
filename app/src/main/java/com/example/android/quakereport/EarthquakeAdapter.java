package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fernando.fischer on 21/06/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List objects) {
        super(context, 0, objects);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);

        // Sete a cor de fundo apropriada no círculo de magnitude.
        // Busque o fundo do TextView, que é um GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Obtenha a cor de fundo apropriada baseada na magnitude do terremoto atual
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Sete a cor no círculo de magnitude
        magnitudeCircle.setColor(magnitudeColor);


        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitude.setText( formatter.format(currentEarthquake.getMagnitude()) );

        TextView location = (TextView) listItemView.findViewById(R.id.location);
        TextView distance = (TextView) listItemView.findViewById(R.id.distance);

        String mLocation = currentEarthquake.getLocation();
        if ( mLocation.contains(LOCATION_SEPARATOR) ) {
            String[] localParts = mLocation.split(LOCATION_SEPARATOR);
            distance.setText(localParts[0]+LOCATION_SEPARATOR);
            location.setText(localParts[1]);
        } else {
            distance.setText(R.string.near_the);
            location.setText(mLocation);
        }


        Date dateObject = new Date(currentEarthquake.getDate());

        TextView dateDay = (TextView) listItemView.findViewById(R.id.date);
        dateDay.setText( formatDate(dateObject) );

        TextView dateHour = (TextView) listItemView.findViewById(R.id.time);
        dateHour.setText( formatTime(dateObject) );

        return listItemView;
    }

    /**
     * Retorna a data string formatada (i.e. "Mar 3, 1984") de um objeto Date.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Retorna a data string formatada (i.e. "4:30 PM") de um objeto Date.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
