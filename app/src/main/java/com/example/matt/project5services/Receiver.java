package com.example.matt.project5services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Yay broadcasts", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
