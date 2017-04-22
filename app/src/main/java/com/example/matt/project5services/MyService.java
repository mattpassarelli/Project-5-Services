package com.example.matt.project5services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

    private int eggs = 0;
    private final String EGGS = "EGGS";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Bundle nums = intent.getExtras();

        eggs = nums.getInt(EGGS);
        makeNotification();


        return Service.START_NOT_STICKY;
    }

    private void makeNotification() {

        //TODO do math and NotificationManager
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
