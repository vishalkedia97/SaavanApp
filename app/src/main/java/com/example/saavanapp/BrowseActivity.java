package com.example.saavanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BrowseActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_browse;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.browse_nav_button;
    }
}
