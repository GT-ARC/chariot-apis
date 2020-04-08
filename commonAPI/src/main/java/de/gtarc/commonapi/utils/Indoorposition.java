package de.gtarc.commonapi.utils;

import com.google.gson.Gson;

public class Indoorposition {
    public String id;
    public double indoorlat;
    public double indoorlng;

    public Indoorposition(String id, double indoorlat, double indoorlng) {
        this.id = id;
        this.indoorlat = indoorlat;
        this.indoorlng = indoorlng;
    }

    public double getIndoorlat() {
        return indoorlat;
    }

    public double getIndoorlng() {
        return indoorlng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIndoorlat(double indoorlat) {
        this.indoorlat = indoorlat;
    }

    public void setIndoorlng(double indoorlng) {
        this.indoorlng = indoorlng;
    }

    public String getJsonString(Class classOfT) {
        return new Gson().toJson(this, classOfT);
    }

    public static <T> T fromJsonString(String string, Class<T> classOfT) {
        return new Gson().fromJson(string, classOfT);
    }
}
