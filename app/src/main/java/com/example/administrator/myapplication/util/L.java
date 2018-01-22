package com.example.administrator.myapplication.util;

import android.content.Context;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/11.
 */

public class L {
    public static boolean D = true;
    public static boolean I = true;
    public static boolean W = true;
    public static boolean E = true;

    public L() {
    }

    public static void d(String tag, String message) {
        if(D) {
            Log.d(tag, message);
        }

    }

    public static void d(Context context, String message) {
        String tag = context.getClass().getSimpleName();
        d(tag, message);
    }

    public static void d(Class<?> clazz, String message) {
        String tag = clazz.getSimpleName();
        d(tag, message);
    }

    public static void d(String message) {
        d(getClassName(), message);
    }

    public static void i(String tag, String message) {
        Log.i(tag, message);
    }

    public static void i(Context context, String message) {
        String tag = context.getClass().getSimpleName();
        i(tag, message);
    }

    public static void i(Class<?> clazz, String message) {
        String tag = clazz.getSimpleName();
        i(tag, message);
    }

    public static void i(String message) {
        i(getClassName(), message);
    }

    public static void w(String tag, String message) {
        Log.w(tag, message);
    }

    public static void w(Context context, String message) {
        String tag = context.getClass().getSimpleName();
        w(tag, message);
    }

    public static void w(Class<?> clazz, String message) {
        String tag = clazz.getSimpleName();
        w(tag, message);
    }

    public static void w(String message) {
        w(getClassName(), message);
    }

    public static void e(String tag, String message) {
        if(E) {
            Log.e(tag, message);
        }

    }

    public static void e(String message) {
        e(getClassName(), message);
    }

    public static void e(Context context, String message) {
        String tag = context.getClass().getSimpleName();
        e(tag, message);
    }

    public static void e(Class<?> clazz, String message) {
        String tag = clazz.getSimpleName();
        e(tag, message);
    }

    private static String getClassName() {
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        String result = thisMethodStack.getClassName();
        int lastIndex = result.lastIndexOf(".");
        result = result.substring(lastIndex + 1, result.length());
        return result;
    }

    public static void debug(boolean d) {
        D = d;
    }

    public static void info(boolean i) {
        I = i;
    }

    public static void warn(boolean w) {
        W = w;
    }

    public static void error(boolean e) {
        E = e;
    }

    public static void setDebugState(boolean d, boolean i, boolean w, boolean e) {
        D = d;
        I = i;
        W = w;
        E = e;
    }

    public static void openAll() {
        D = true;
        I = true;
        W = true;
        E = true;
    }

    public static void closeAll() {
        D = false;
        I = false;
        W = false;
        E = false;
    }
}
