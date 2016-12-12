package com.objectist.earthquakesample;

import android.os.AsyncTask;

/**
 * Created by svetlin on 12/11/16.
 */

public class EarthquakeAsyncTask extends AsyncTask<Void, Integer, Void>
{

    private EarthquakeListFragment mEarthquakeListFragment;

    private EarthquakeList mEarthQlist;

    public EarthquakeAsyncTask(EarthquakeListFragment earthquakeListFragment)
    {
        this.mEarthquakeListFragment = earthquakeListFragment;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values)
    {
        super.onProgressUpdate(values);

    }

    @Override
    protected Void doInBackground(Void... arg0)
    {

        mEarthQlist = new EarthquakeList();
        mEarthQlist.loadFromUSGS();

        return null;
    }

    @Override
    protected void onPostExecute(Void result)
    {
        mEarthquakeListFragment.mapDataToUI(mEarthQlist);
        super.onPostExecute(result);
    }
}