package com.example.android.quakereport;
import android.media.Image;

import java.lang.String;

public class Word {
    private String mplace;
    private double  mmag;
    private long  mtime;
    private String mainPlace;
    private String offsetPlace;
    private String url;


    public Word(String place, double  mag,long time,String url) {
        mplace=place;
        mmag=mag;
        mtime=time;
        this.url=url;
    }
    public void splitString(){
        if(mplace.contains(" of ")){
            String[] parts = mplace.split("(?<= of )");
            offsetPlace= parts[0];
            mainPlace= parts[1];
        }else{
            mainPlace=mplace;
            offsetPlace="Near the";
        }
    }

    public String getUrl() {
        return url;
    }

    public long getMtime() {
        return mtime;
    }

    public String getMainPlace() {
        return mainPlace;
    }

    public String getOffsetPlace() {
        return offsetPlace;
    }

    public double getMagnitude() {
        return mmag;
    }
}


