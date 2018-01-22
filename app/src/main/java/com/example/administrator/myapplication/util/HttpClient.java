package com.example.administrator.myapplication.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/11.
 */

public class HttpClient {
    private static final int DEFAULT_TIME_OUT = 5;
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private static final int DEFAULT_WRITE_TIME_OUT = 10;
    private static HttpClient instance;
    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    public HttpClient() {
        this.builder.readTimeout(10L, TimeUnit.SECONDS);
        this.builder.writeTimeout(10L, TimeUnit.SECONDS);
        this.builder.connectTimeout(5L, TimeUnit.SECONDS);
        //this.builder = ProgressManager.getInstance().with(this.builder);
    }

    public static HttpClient getInstance() {
        if(instance == null) {
            Class var0 = HttpClient.class;
            synchronized(HttpClient.class) {
                if(instance == null) {
                    instance = new HttpClient();
                }
            }
        }

        return instance;
    }

    public OkHttpClient.Builder getBuilder() {
        return this.builder;
    }
}
