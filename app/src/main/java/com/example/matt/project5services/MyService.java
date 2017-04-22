package com.example.matt.project5services;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import java.util.Random;

public class MyService extends Service {

    private int eggs = 0;
    private int add = 0;
    private final String EGGS = "Eggs";
    private final String prefEggs = "EGGS";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private String message = "";

    @SuppressLint("CommitPrefEdits")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = prefs.edit();

        Bundle nums = intent.getExtras();

        add = nums.getInt(EGGS);
        makeNotification();


        return Service.START_NOT_STICKY;
    }

    private void makeNotification() {
        Random r = new Random();
        int id = r.nextInt(9999 - 1000) + 1000;

        eggs = prefs.getInt(prefEggs, 0);

        switch (add) {
            case 1:
                eggs += 1;
                message = "1 Added!";
                break;
            case 2:
                eggs += 2;
                message = "2 Added!";
                break;
            case -1:
                eggs -= 1;
                message = "1 Subtracted!";
                if (eggs < 0) {
                    eggs = 0;
                    message = "You can't have negative eggs man";
                }
                break;
            case 3:
                if (eggs >= 6) {
                    eggs -= 6;
                    message = "We're having Omelets. We have " + eggs + " eggs available";
                } else {
                    message = "We only have " + eggs + " eggs. Have you considered waffles?";
                }
                break;
        }

        editor.putInt(prefEggs, eggs);
        editor.commit();


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification note = new Notification.Builder(this)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(message)
                .setSmallIcon(R.drawable.eggs)
                .build();

        manager.notify(id, note);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
