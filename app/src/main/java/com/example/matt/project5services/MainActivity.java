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

        setTitle("Eggs? Eggs!");

    }

    public void addOne(View view) {
        Intent intent = new Intent("com.example.matt.Project5Services.MYACTION");
        intent.putExtra(EGGS, 1);
        sendBroadcast(intent);
    }

    public void addTwo(View view) {
        Intent intent = new Intent("com.example.matt.Project5Services.MYACTION");
        intent.putExtra(EGGS, 2);
        sendBroadcast(intent);
    }

    public void subtractOne(View view) {
        Intent intent = new Intent("com.example.matt.Project5Services.MYACTION");
        intent.putExtra(EGGS, -1);
        sendBroadcast(intent);
    }

    public void breakfast(View view) {
        Intent intent = new Intent("com.example.matt.Project5Services.MYACTION");
        intent.putExtra(EGGS, 3);
        sendBroadcast(intent);
    }
}
