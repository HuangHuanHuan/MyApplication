package com.example.administrator.myapplication;

import com.example.administrator.myapplication.model.VideoBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/1/18.
 */

public interface API {

    @GET("api/file/fullStatus/")
    Observable<VideoBean> getList(@Query("access_token") String access_token, @Query("file_id") String file_id);

    //不是json格式的数据，类型定义String无法解析，不走onNext方法
    @GET
    Observable<Response<ResponseBody>> getM3u8List(@Url String path);
}
