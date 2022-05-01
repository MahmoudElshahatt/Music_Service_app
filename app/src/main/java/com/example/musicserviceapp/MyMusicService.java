package com.example.musicserviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyMusicService extends Service {
    public static final String TAG="MyMusicService";
    MediaPlayer mp ;
    public MyMusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.song);
        Log.i(TAG, "onCreate:Service Created ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp.isPlaying())
            mp.start();
        Log.i(TAG, "onStartCommand:Service started ");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if(mp.isPlaying()){
            mp.stop();
            mp.release();
        }
        Log.i(TAG, "onDestroy:Service Destroyed ");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}