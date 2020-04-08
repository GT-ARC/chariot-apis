package de.gtarc.chariot.messageapi;

import com.google.gson.Gson;


public abstract class AbstractPayload {


    public String getJsonString(Class classOfT) {
        return new Gson().toJson(this, classOfT);
    }


    public static <T> T fromJsonString(String string, Class<T> classOfT) {
        return new Gson().fromJson(string, classOfT);
    }


}
