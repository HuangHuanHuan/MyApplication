package com.example.administrator.myapplication.util;

import android.util.Log;

import com.example.administrator.myapplication.MainApplication;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2018/1/11.
 * 提供接口实例
 */

public class RetrofitServiceManager {
    private Retrofit mRetrofit;
    private static Retrofit mRetrofit1;
    String TAG = "RetrofitServiceManager";

    private RetrofitServiceManager() {


        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(BaseConverterFactory.create())
                .client(genericClient())
                .baseUrl("http://openapi.iqiyi.com/")
                .build();
    }

    //添加头部信息的拦截器
    public OkHttpClient genericClient() {
        Cache okhttpcache = new Cache(new File(MainApplication.getContext().getExternalCacheDir(), "hhhcache"), 10 * 1024 * 1024);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().build();
//                                .addHeader("ClientHeaderInfo","1eyJWZXJDb2RlIjoiMS41LjAiLCJBY2NvdW50SURTaWduYXR1cmUiOiIiLCJBcHBMYW5nIjoiemgiLCJCU1NJRCI6Ijg0JTNBM0ElM0E0QiUzQTM1JTNBM0QlM0E0MCIsIkNIQ29kZSI6IkEwMDEiLCJUb2tlbiI6Ik4wZk1zcm5kaWZ2blZhOXlZOHZBbmhhUnA5eUJjUkJzSU1paDRUdXBZcGdcdTAwM2QiLCJTaW1JREZBIjoiIiwiRGV2aWNlTGFuZyI6InpoIiwiRGV2aWNlTW9kZWwiOiJPUFBPK1IxMSIsIlNlc3Npb25JRCI6IiIsIklERkEiOiIiLCJJREZWIjoiIiwiSU1FSSI6Ijg2NjE3NDAxMDg0NTg3OSIsIkpiRmxhZyI6IiIsIkxvZ2luQ29kZSI6IiIsIkxvZ2luU2lnbmF0dXJlIjoiIiwiU2VyaWFsIjoiODQzYTRiMzUzZDQwNzc1NSIsIk1hYyI6Ijg0JTNBM0ElM0E0QiUzQTM1JTNBM0QlM0E0MCIsIlNjcmVlbiI6IjEyODAqNzIwIiwiUlRpbWUiOiIiLCJPU1ZlciI6IjQuNC4yIiwiT3BlbklEIjoiODQzYTRiMzUzZDQwNzc1NV84NjYxNzQwMTA4NDU4NzlfODQlM0EzQSUzQTRCJTNBMzUlM0EzRCUzQTQwIiwiUGxhdEZvcm0iOjExLCJQcm9kdWN0SUQiOjMxNjgsIlByb2plY3RJRCI6OSwiT1NUeXBlIjoyLCJOZXQiOjEsIkxvZ2luU3RhbXAiOjAsIkRldmljZVR5cGUiOjIsIkRhdGFUeXBlIjoyLCJDSElEIjowLCJUb2tlblR5cGUiOjEsIkFjY291bnRJRCI6MCwiVmVySUQiOjE1MDB9")
                        Log.i(TAG, "intercept: " + request.url());
                        return chain.proceed(request);
                    }
                })
//                .cache(okhttpcache)
                .build();
        return okHttpClient;
    }

    /**
     * 获取RetrofitServiceManager
     *
     * @return
     */
    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();

        private SingletonHolder() {
        }
    }
}
