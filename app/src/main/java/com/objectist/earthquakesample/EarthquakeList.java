package com.objectist.earthquakesample;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Hashtable;

import co.scarletshark.geojson.JsonObject;
import co.scarletshark.geojson.JsonParser;

/**
 * Created by svetlin on 12/11/16.
 */

public class EarthquakeList
{

    final String textSource = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_month.geojson";

    protected Hashtable<String, EarthquakeFeatureGeometry> mEarthquakelist;

    public EarthquakeList()
    {
        this.mEarthquakelist = new Hashtable<String, EarthquakeFeatureGeometry>();
    }

    public void loadFromUSGS()
    {

        URL textUrl;
        try
        {
            textUrl = new URL(this.textSource);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(textUrl.openStream()));

            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = bufferReader.readLine()) != null; )
            {
                builder.append(line).append("\n");
            }
            bufferReader.close();
            String json = '[' + builder.toString() + ']';

            try
            {
                JsonObject result = JsonParser.parseObject(json);
                Object[] features = result.getPairByName("features").getValueAsArray();
                for (int i = 0; i < features.length; i++)
                {
                    String feature = features[i].toString();
                    try
                    {
                        EarthquakeFeature ef = new EarthquakeFeature(feature);
                        this.mEarthquakelist.put(ef.getId(), ef.getGeom());
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        Log.e("No location", "No location for this event: " + feature);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (UnknownHostException e)
        {

            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Hashtable<String, EarthquakeFeatureGeometry> getEarthquakelist()
    {
        return mEarthquakelist;
    }
}
