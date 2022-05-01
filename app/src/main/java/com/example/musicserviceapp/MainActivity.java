package com.example.musicserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSong(View view) {
        Intent intent=new Intent(this,MyMusicService.class);
        startService(intent);
    }

    public void stopSong(View view) {
        Intent intent=new Intent(this,MyMusicService.class);
        stopService(intent);
    }
}