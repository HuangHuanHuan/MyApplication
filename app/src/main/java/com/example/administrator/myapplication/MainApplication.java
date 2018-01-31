package com.example.administrator.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/1/11.
 */

public class MainApplication extends Application{
    //master分支修改
    public static Context mContext ;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    public static Context getContext(){
        return mContext;
    }
}
