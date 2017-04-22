package com.example.matt.project5services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    private final String EGGS = "Eggs";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Yay broadcasts", Toast.LENGTH_SHORT).show();

        Bundle extra = intent.getExtras();
        Intent i = new Intent(context, MyService.class);

        int num = extra.getInt(EGGS);

        i.putExtra(EGGS, num);
        context.startService(i);
    }
}
