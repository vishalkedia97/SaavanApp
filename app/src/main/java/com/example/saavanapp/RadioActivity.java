 package com.example.saavanapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

 public class RadioActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);


    }

     @Override
     int getContentViewId() {
         return R.layout.activity_radio;
     }

     @Override
     int getNavigationMenuItemId() {
         return R.id.radio_nav_button;
     }
 }
