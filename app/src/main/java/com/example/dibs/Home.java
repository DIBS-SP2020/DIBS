package com.example.dibs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Member;


public class Home extends AppCompatActivity {

    private static final String LOG_TAG =
            Home.class.getSimpleName();

    @Override
    protected void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);




    }

    public void launchBounties(View view) {
        Log.d(LOG_TAG, "Bounties button clicked!");
        Intent bounties = new Intent(this, Bounties.class);
        startActivity(bounties);
    }

    public void launchCalendar(View view) {
        Log.d(LOG_TAG, "Calendar button clicked!");
        Intent calendar = new Intent(this, Calendar.class);
        startActivity(calendar);
    }

    public void launchMembers(View view) {
        Log.d(LOG_TAG, "Members button clicked!");
        Intent members = new Intent(this, Members.class);
        startActivity(members);
    }

    public void launchPoints(View view) {
        Log.d(LOG_TAG, "com.example.dibs.Points button clicked!");
        Intent points = new Intent(this, Points.class);
        startActivity(points);
    }

}
