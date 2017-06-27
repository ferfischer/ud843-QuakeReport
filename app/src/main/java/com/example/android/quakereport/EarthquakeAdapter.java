package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fernando.fischer on 21/06/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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

        Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(currentEarthquake.getMagnitude());

        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(currentEarthquake.getLocation());


        Date dateObject = new Date(currentEarthquake.getDate());

        TextView dateDay = (TextView) listItemView.findViewById(R.id.dateDay);
        dateDay.setText( formatDate(dateObject) );

        TextView dateHour = (TextView) listItemView.findViewById(R.id.dateHour);
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
}
