package com.objectist.earthquakesample;

import android.location.Location;

/**
 * Created by svetlin on 12/11/16.
 */
public class Earthquake
{

    private String mId;

    private Location mLocation;

    private float mDistance;

    public Earthquake(String id, Location location)
    {
        mId = id;
        mLocation = location;
    }

    public String getId()
    {
        return mId;
    }

    public Location getLocation()
    {
        return mLocation;
    }

    public float getDistance()
    {
        return mDistance;
    }

    public void setDistance(float distance)
    {
        mDistance = distance / 1000;
    }


    @Override
    public String toString()
    {
        return "id=" + getId() + " lat=" + getLocation().getLatitude() + " long=" + getLocation().getLongitude() + " dist= " + getDistance() + " kms";
    }
}
