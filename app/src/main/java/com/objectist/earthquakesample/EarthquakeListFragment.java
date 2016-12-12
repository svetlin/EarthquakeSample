package com.objectist.earthquakesample;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

/**
 * Created by svetlin on 12/11/16.
 */
public class EarthquakeListFragment extends ListFragment
{

    private static Location myLocation;

    ArrayAdapter<Earthquake> mAdapter;

    ArrayList<Earthquake> mEarthquakes = new ArrayList<Earthquake>();

    public static void setMyLocation(Location location)
    {
        myLocation = location;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        int layoutID = android.R.layout.simple_list_item_1;
        mAdapter = new ArrayAdapter<Earthquake>(getActivity(), layoutID, mEarthquakes);
        setListAdapter(mAdapter);
        refreshEarthquakesData();
    }

    private void refreshEarthquakesData()
    {
        mEarthquakes.clear();
        EarthquakeAsyncTask asyncTask = new EarthquakeAsyncTask(this);
        asyncTask.execute();
    }

    public void mapDataToUI(EarthquakeList earthQlist)
    {

        Set<String> ids = earthQlist.getEarthquakelist().keySet();
        for (String id : ids)
        {
            Location location = new Location(id);
            location.setLatitude(earthQlist.getEarthquakelist().get(id).getLatitude());
            location.setLongitude(earthQlist.getEarthquakelist().get(id).getLongitude());
            Earthquake earthquake = new Earthquake(id, location);
            if (null != myLocation)
            {
                earthquake.setDistance(myLocation.distanceTo(location));
            }
            mEarthquakes.add(earthquake);
        }

        Collections.sort(mEarthquakes, new Comparator<Earthquake>()
        {
            @Override
            public int compare(Earthquake lhs, Earthquake rhs)
            {
                return (int) (lhs.getDistance() - rhs.getDistance());
            }
        });
        mAdapter.notifyDataSetChanged();
    }

}
