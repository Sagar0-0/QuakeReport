package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;


public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Word currentWord = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        currentWord.splitString();
        TextView mainplaceTextView = (TextView) listItemView.findViewById(R.id.place);
        mainplaceTextView.setText(currentWord.getMainPlace());

        TextView offsetTextView=(TextView)listItemView.findViewById(R.id.nearby);
        offsetTextView.setText(currentWord.getOffsetPlace());




        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentWord.getMagnitude());
        magnitudeView.setText(output);



        //Creating date class object
        Date dateObject = new Date(currentWord.getMtime());
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        return listItemView;
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);

    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private int getMagnitudeColor(double mag){
        int color;
        switch((int)mag){
            case 1:
                color=R.color.magnitude1;
                break;
            case 2:
                color=R.color.magnitude2;
                break;
            case 3:
                color=R.color.magnitude3;
                break;
            case 4:
                color=R.color.magnitude4;
                break;
            case 5:
                color=R.color.magnitude5;
                break;
            case 6:
                color=R.color.magnitude6;
                break;
            case 7:
                color=R.color.magnitude7;
                break;
            case 8:
                color=R.color.magnitude8;
                break;
            case 9:
                color=R.color.magnitude9;
                break;
            default:
                color=R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), color);
    }
}