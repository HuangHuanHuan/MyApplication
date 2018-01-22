package com.example.administrator.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/1/11.
 */

public class SharedPreferencesHelper {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesHelper(Context context) {
        this(context, "cache_data");
    }

    public SharedPreferencesHelper(Context context, String fileName) {
        this.preferences = context.getSharedPreferences(fileName, 0);
        this.editor = this.preferences.edit();
    }

    public void putString(String key, String value) {
        this.editor.putString(key, value);
        this.editor.apply();
    }

    public void putBoolean(String key, boolean value) {
        this.editor.putBoolean(key, value);
        this.editor.apply();
    }

    public void putFloat(String key, float value) {
        this.editor.putFloat(key, value);
        this.editor.apply();
    }

    public void putInt(String key, int value) {
        this.editor.putInt(key, value);
        this.editor.apply();
    }

    public void putLong(String key, long value) {
        this.editor.putLong(key, value);
        this.editor.apply();
    }

    public void clear() {
        this.editor.clear();
        this.editor.apply();
    }

    public void remove(String key) {
        this.editor.remove(key);
        this.editor.apply();
    }

    public String getString(String key, String defValue) {
        return this.preferences.getString(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return this.preferences.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return this.preferences.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return this.preferences.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return this.preferences.getLong(key, defValue);
    }

    public boolean contains(String key) {
        return this.preferences.contains(key);
    }
}
