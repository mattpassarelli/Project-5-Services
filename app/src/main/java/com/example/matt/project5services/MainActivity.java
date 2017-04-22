package com.example.matt.project5services;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String EGGS = "Eggs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

    }

    public void addOne(View view) {
        Intent intent = new Intent("com.example.matt.Project5Services.MYACTION");
        intent.putExtra(EGGS, 1);
        sendBroadcast(intent);
    }
}
