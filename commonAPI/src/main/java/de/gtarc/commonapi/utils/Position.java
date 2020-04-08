package de.gtarc.commonapi.utils;


import com.google.gson.Gson;

public class Position {
    public String id;
    public double lat;
    public double lng;

    public Position(double lat, double lng, String id) {
        this.lat = lat;
        this.lng = lng;
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getJsonString(Class classOfT) {
        return new Gson().toJson(this, classOfT);
    }

    public static <T> T fromJsonString(String string, Class<T> classOfT) {
        return new Gson().fromJson(string, classOfT);
    }

}
