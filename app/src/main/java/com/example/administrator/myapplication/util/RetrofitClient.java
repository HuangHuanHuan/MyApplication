package com.example.administrator.myapplication.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2018/1/11.
 */

public class RetrofitClient {
    public static final String RETROFIT_HEADER_NOCACHE = "cache-mode:no-cache";
    private static RetrofitClient instance;
    private Retrofit.Builder mRetrofitBuilder;
    private okhttp3.OkHttpClient.Builder mOkHttpBuilder = HttpClient.getInstance().getBuilder();

    public RetrofitClient() {
        this.mRetrofitBuilder = (new Retrofit.Builder()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(BaseConverterFactory.create()).client(this.mOkHttpBuilder.build());
    }

    public static RetrofitClient getInstance() {
        if(instance == null) {
            Class var0 = RetrofitClient.class;
            synchronized(RetrofitClient.class) {
                if(instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }

        return instance;
    }

    public Retrofit.Builder getRetrofitBuilder() {
        return this.mRetrofitBuilder;
    }

    public Retrofit getRetrofit() {
        return this.mRetrofitBuilder.client(this.mOkHttpBuilder.build()).build();
    }
}
