package com.objectist.earthquakesample;

import co.scarletshark.geojson.JsonObject;
import co.scarletshark.geojson.JsonParser;

/**
 * Created by svetlin on 12/11/16.
 */

public class EarthquakeFeature
{

    protected float mag;

    protected String place;

    protected long time;

    protected double updated;

    protected float tz;

    protected String url;

    protected String detail;

    protected float felt;

    protected float cdi;

    protected float mmi;

    protected String alert;

    protected String status;

    protected float tsunami;

    protected float sig;

    protected String net;

    protected String code;

    protected String ids;

    protected String sources;

    protected String types;

    protected float nst;

    protected float dmin;

    protected float rms;

    protected float gap;

    protected String magType;

    protected String type;

    protected EarthquakeFeatureGeometry geom;

    protected String id;

    protected String title;

    public EarthquakeFeature(String json)
    {
        JsonObject feature = JsonParser.parseObject(json);

        JsonObject prop = feature.getPairByName("properties").getValueAsObject();
        geom = new EarthquakeFeatureGeometry(feature.getPairByName("geometry"));
        this.id = feature.getPairByName("id").getValue().toString();

/*
        this.alert = prop.getPairByName("alert").getValue().toString();
        this.cdi = avoidNullPointerForNullValue(prop.getPairByName("cdi").getValue().toString());
        this.code = prop.getPairByName("code").getValue().toString();
        this.detail = prop.getPairByName("detail").getValue().toString();
        this.dmin = avoidNullPointerForNullValue(prop.getPairByName("dmin").getValue().toString());
        this.felt = avoidNullPointerForNullValue(prop.getPairByName("felt").getValue().toString());
        this.gap = avoidNullPointerForNullValue(prop.getPairByName("gap").getValue().toString());
        this.ids = prop.getPairByName("ids").getValue().toString();
        this.mag =avoidNullPointerForNullValue(prop.getPairByName("mag").getValue().toString());
        this.magType = prop.getPairByName("magType").getValue().toString();
        this.mmi = avoidNullPointerForNullValue(prop.getPairByName("mmi").getValue().toString());
        this.net = prop.getPairByName("net").getValue().toString();
        this.nst = avoidNullPointerForNullValue(prop.getPairByName("nst").getValue().toString());
        this.place = prop.getPairByName("place").getValue().toString();
        this.rms = avoidNullPointerForNullValue(prop.getPairByName("rms").getValue().toString());
        this.sig = avoidNullPointerForNullValue(prop.getPairByName("sig").getValue().toString());
        this.sources = prop.getPairByName("sources").getValue().toString();
        this.status = prop.getPairByName("status").getValue().toString();
        this.time = avoidNullPointerForNullValueL(prop.getPairByName("time").getValue());
        this.tsunami = avoidNullPointerForNullValue(prop.getPairByName("tsunami").getValue().toString());
        this.type = prop.getPairByName("type").getValue().toString();
        this.types = prop.getPairByName("types").getValue().toString();
        this.tz = avoidNullPointerForNullValue(prop.getPairByName("tz").getValue().toString());
        this.updated = avoidNullPointerForNullValueD(prop.getPairByName("updated").getValue().toString());
        this.url = prop.getPairByName("url").getValue().toString();
        this.title = prop.getPairByName("title").getValueAsString();
*/
    }

    public static float avoidNullPointerForNullValue(String val)
    {
        if (val != "null")
        {
            return Float.parseFloat(val);
        }
        else
        {
            return 0;
        }
    }

    public static double avoidNullPointerForNullValueD(String val)
    {
        if (val != "null")
        {
            return Double.parseDouble(val);
        }
        else
        {
            return 0;
        }
    }

    public EarthquakeFeatureGeometry getGeom()
    {
        return geom;
    }

    public String getId()
    {
        return id;
    }

/*
    public static long avoidNullPointerForNullValueL(JsonValue val) {
        return (long)val.getDoubleValue();
    }
*/

    public float getMag()
    {
        return mag;
    }

    public void setMag(float mag)
    {
        this.mag = mag;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public long getTime()
    {
        return time;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public double getUpdated()
    {
        return updated;
    }

    public void setUpdated(double updated)
    {
        this.updated = updated;
    }

    public float getTz()
    {
        return tz;
    }

    public void setTz(float tz)
    {
        this.tz = tz;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public float getFelt()
    {
        return felt;
    }

    public void setFelt(float felt)
    {
        this.felt = felt;
    }

    public float getCdi()
    {
        return cdi;
    }

    public void setCdi(float cdi)
    {
        this.cdi = cdi;
    }

    public float getMmi()
    {
        return mmi;
    }

    public void setMmi(float mmi)
    {
        this.mmi = mmi;
    }

    public String getAlert()
    {
        return alert;
    }

    public void setAlert(String alert)
    {
        this.alert = alert;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public float getTsunami()
    {
        return tsunami;
    }

    public void setTsunami(float tsunami)
    {
        this.tsunami = tsunami;
    }

    public float getSig()
    {
        return sig;
    }

    public void setSig(float sig)
    {
        this.sig = sig;
    }

    public String getNet()
    {
        return net;
    }

    public void setNet(String net)
    {
        this.net = net;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getIds()
    {
        return ids;
    }

    public void setIds(String ids)
    {
        this.ids = ids;
    }

    public String getSources()
    {
        return sources;
    }

    public void setSources(String sources)
    {
        this.sources = sources;
    }

    public String getTypes()
    {
        return types;
    }

    public void setTypes(String types)
    {
        this.types = types;
    }

    public float getNst()
    {
        return nst;
    }

    public void setNst(float nst)
    {
        this.nst = nst;
    }

    public float getDmin()
    {
        return dmin;
    }

    public void setDmin(float dmin)
    {
        this.dmin = dmin;
    }

    public float getRms()
    {
        return rms;
    }

    public void setRms(float rms)
    {
        this.rms = rms;
    }

    public float getGap()
    {
        return gap;
    }

    public void setGap(float gap)
    {
        this.gap = gap;
    }

    public String getMagType()
    {
        return magType;
    }

    public void setMagType(String magType)
    {
        this.magType = magType;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getLat()
    {
        return geom.getLatitude();
    }

    public double getLng()
    {
        return geom.getLongitude();
    }

    private String convertToDegrees(double d)
    {

        double long_deg = Math.floor(d);
        double long_min = Math.floor((d - Math.floor(d)) * 60);
        double long_sec = Math.round((((d - Math.floor(d)) * 60) - Math.floor(((d - Math.floor(d)) * 60))) * 60 * 1000) / 1000;
        return ((int) long_deg) + "" + '\u00b0' + ((int) long_min) + "' " + ((int) long_sec) + "''";
    }

    public String getDescription()
    {
/*
        Date date = new Date(time);
        return title + "\r\n" + DateFormat.getDateTimeInstance().format(date) + "\r\n\r\n" + String.format(MainActivity.getContext().getResources().getString(R.string.latitude),
                                                                                                           convertToDegrees(geom.getLatitude())) + "\r\n"  +  String.format(
                MainActivity.getContext().getResources().getString(R.string.longitude), convertToDegrees(geom.getLongitude()));
*/
        return "";
    }

    @Override
    public String toString()
    {
        return "EarthquakeFeature{" +
                "mag=" + mag +
                ", place='" + place + '\'' +
                ", time=" + time +
                ", updated=" + updated +
                ", tz=" + tz +
                ", url='" + url + '\'' +
                ", detail='" + detail + '\'' +
                ", felt=" + felt +
                ", cdi=" + cdi +
                ", mmi=" + mmi +
                ", alert='" + alert + '\'' +
                ", status='" + status + '\'' +
                ", tsunami=" + tsunami +
                ", sig=" + sig +
                ", net='" + net + '\'' +
                ", code='" + code + '\'' +
                ", ids='" + ids + '\'' +
                ", sources='" + sources + '\'' +
                ", types='" + types + '\'' +
                ", nst=" + nst +
                ", dmin=" + dmin +
                ", rms=" + rms +
                ", gap=" + gap +
                ", magType='" + magType + '\'' +
                ", type='" + type + '\'' +
                ", geom=" + geom.toString() + '\'' +
                ", id=" + id.toString() +
                '}';
    }
}