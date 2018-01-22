package com.example.administrator.myapplication.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/1/11.
 */

public class JsonHelper {
    private static final String TAG = JsonHelper.class.getSimpleName();
    private static Gson sGson = null;

    public JsonHelper() {
    }

    public static Gson getGson() {
        if(sGson == null) {
            sGson = new Gson();
        }

        return sGson;
    }

    public static Gson getExposeGson() {
        if(sGson == null) {
            GsonBuilder gsonBuilder = (new GsonBuilder()).registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory());
            sGson = gsonBuilder.create();
        }

        return sGson;
    }

    public static String toJson(Object src) {
        return getGson().toJson(src);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        return getGson().toJson(src, typeOfSrc);
    }

    public static String toExposeJson(Object src) {
        return getExposeGson().toJson(src);
    }

    public static String toExposeJson(Object src, Type typeOfSrc) {
        return getExposeGson().toJson(src, typeOfSrc);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return getGson().fromJson(json, classOfT);
        } catch (JsonSyntaxException var3) {
            var3.printStackTrace();
            L.e(TAG, var3.getMessage());
            return null;
        }
    }

    public static <T> T fromJson(JSONObject json, Class<T> classOfT) {
        return null != json?fromJson(json.toString(), classOfT):null;
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        try {
            return getExposeGson().fromJson(json, typeOfT);
        } catch (JsonSyntaxException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(JSONObject json, Type typeOfT) {
        return null != json? (T) fromJson(json.toString(), typeOfT) :null;
    }

    public static <T> T fromExposeJson(String json, Class<T> classOfT) {
        try {
            return getExposeGson().fromJson(json, classOfT);
        } catch (JsonSyntaxException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T fromExposeJson(JSONObject json, Class<T> classOfT) {
        return null != json?fromExposeJson(json.toString(), classOfT):null;
    }

    public static <T> T fromExposeJson(String json, Type typeOfT) {
        try {
            return getExposeGson().fromJson(json, typeOfT);
        } catch (JsonSyntaxException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T fromExposeJson(JSONObject json, Type typeOfT) {
        return null != json? (T) fromExposeJson(json.toString(), typeOfT) :null;
    }

    public static boolean isJson(String json) {
        try {
            (new JsonParser()).parse(json);
            return true;
        } catch (JsonParseException var2) {
            return false;
        }
    }
}
