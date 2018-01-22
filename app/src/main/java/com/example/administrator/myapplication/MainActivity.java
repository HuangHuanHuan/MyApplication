package com.example.administrator.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.myapplication.model.VideoBean;
import com.example.administrator.myapplication.util.RetrofitServiceManager;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    @BindView(R.id.playerview)
    SimpleExoPlayerView mPlayerview;
    private VideoBean.DataBean.UrllistBean.M3u8Bean m3u8Bean;
    private ExtractorMediaSource videoSource;
    private SimpleExoPlayer player;
    private String m3u8Content;
    private List<String> m3u8Ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        //player();
    }

    private void init() {
        API api = RetrofitServiceManager.getInstance().create(API.class);
        Observable<VideoBean> videoBeanObservable = api.getList("2.373fb83a60ecd66f8562f7e04d483431", "0d36c4e68e034c6db46f41027065868e");
        videoBeanObservable.subscribeOn(Schedulers.io())
                .map(new Function<VideoBean, VideoBean.DataBean.UrllistBean.M3u8Bean>() {
                    @Override
                    public VideoBean.DataBean.UrllistBean.M3u8Bean apply(@NonNull VideoBean videoBean) throws Exception {
                        return videoBean.getData().getUrllist().getM3u8();
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<VideoBean.DataBean.UrllistBean.M3u8Bean, ObservableSource<retrofit2.Response<ResponseBody>>>() {
                    @Override
                    public ObservableSource<retrofit2.Response<ResponseBody>> apply(@NonNull VideoBean.DataBean.UrllistBean.M3u8Bean m3u8Bean) throws Exception {
                        API api = RetrofitServiceManager.getInstance().create(API.class);
                        return api.getM3u8List(m3u8Bean.get_$1());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<ResponseBody>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe: " + "---");
                    }

                    @Override
                    public void onNext(Response<ResponseBody> responseBodyResponse) {
                        try {
                            m3u8Ts = new ArrayList<String>();
                            m3u8Content = responseBodyResponse.body().string();
                            m3ubplayer();
                            String regex = "((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>[\\u4e00-\\u9fa5]*]*)+)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>[\\u4e00-\\u9fa5]*]*)+)";
                            Pattern p = Pattern.compile(regex);
                            Matcher m = p.matcher(m3u8Content);
                            while (m.find()) {
                                Log.i(TAG, "onNext: " + m.group() + "   位置：[" + m.start() + "," + m.end() + "]");
                                m3u8Ts.add(m.group());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //创建了新分支---------------------------------------

    private void m3ubplayer() {
        // 1.创建一个默认TrackSelector,用来选择磁道
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        //选择磁道
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        //把播放器添加到视图
        mPlayerview.setPlayer(player);

        Uri uri = Uri.parse(m3u8Content);
        DefaultBandwidthMeter bandMeter = new DefaultBandwidthMeter();

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "MyApplication"), bandMeter);
        MediaSource mediasource = new HlsMediaSource(uri, dataSourceFactory, 1, null, null);
        LoopingMediaSource loppingMediaSource = new LoopingMediaSource(mediasource);
        player.prepare(loppingMediaSource);
        player.setPlayWhenReady(true);
    }
}
