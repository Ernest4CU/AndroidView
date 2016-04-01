package com.example.ernest.androidview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private String url1 = "/mnt/sdcard1/bell.mp4";
    private String url2 = "/mnt/sdcard1/bell2.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        /**
         * VideoView控制视频播放的功能相对较少，具体而言，它只有start和pause方法。为了提供更多的控制，
         * 可以实例化一个MediaController，并通过setMediaController方法把它设置为VideoView的控制器。
         */
        videoplay(url2);
//        videoView.setVideoURI(Uri.parse("/mnt/sdcard1/bell.mp4"));
//        videoView.start();
    }
    public void videoplay(String path) {
        try {
            Uri uri = Uri.parse(path);
            videoView.setVideoURI(uri);
            videoView.start();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.start();// 播放
//                mp.setLooping(true);
//            }
//        });
        }
        catch(Exception e){}
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            int count ;
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(count ==1) {
                    android.util.Log.i("test", "播放完毕00000000" + count);
                    Uri uri = Uri.parse(url2);
                    videoView.setVideoURI(uri);
                    count = 0;
                }
                else {
                    android.util.Log.i("test", "播放完毕111111111" + count);
                    Uri uri = Uri.parse(url1);
                    videoView.setVideoURI(uri);
                    count = 1;
                }
                videoView.start();// 播放
            }
        });
    }
}
