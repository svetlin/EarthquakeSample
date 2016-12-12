package com.objectist.earthquakesample;

import co.scarletshark.geojson.GeoJsonObject;
import co.scarletshark.geojson.JsonCoordinate;
import co.scarletshark.geojson.JsonObject;
import co.scarletshark.geojson.JsonPair;
import co.scarletshark.geojson.JsonParser;

/**
 * Created by svetlin on 12/11/16.
 */

class EarthquakeFeatureGeometry
{

    protected String type;

    protected double longitude;

    protected double latitude;

    protected double depth;

    EarthquakeFeatureGeometry(JsonPair geopair)
    {

        JsonObject geo = JsonParser.parseObject(geopair.getValueAsString().toString());

        GeoJsonObject geom = JsonParser.parseGeometry(geo);

        JsonCoordinate[] coords = geom.getCoordinates();

        JsonCoordinate coord = coords[0];
        this.longitude = coord.getLongitude();
        this.latitude = coord.getLatitude();
        this.depth = coord.getAltitude();

    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getDepth()
    {
        return depth;
    }

    public void setDepth(double depth)
    {
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return "EarthquakeFeatureGeometry{" +
                "type='" + type + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", depth=" + depth +
                '}';
    }
}