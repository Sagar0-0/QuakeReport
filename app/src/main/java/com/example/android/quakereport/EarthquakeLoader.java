package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.security.PrivateKey;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Word>> {
    private String u;
    public EarthquakeLoader(Context context,String s) {
        super(context);
        u=s;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Word> loadInBackground() {

        Log.e("loaderclass","we are inside load in background");
        if(u==null)return null;

        List<Word> result = QueryUtils.fetchEarthquakeData(u);
        return result;
    }
}
