package com.example.saavanapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public abstract class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

       bottomNavigationView = findViewById(R.id.navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);


       }

    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        bottomNavigationView.postDelayed(() -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home_nav_button) {
                startActivity(new Intent(this, HomeActivity.class));
            } else if (itemId == R.id.radio_nav_button) {
                startActivity(new Intent(this, RadioActivity.class));
            } else if (itemId == R.id.browse_nav_button) {
                startActivity(new Intent(this, BrowseActivity.class));
            }
            else if(itemId == R.id.my_music_nav_button){
                startActivity(new Intent(this,MyMusicActivity.class));
            }
            finish();
        }, 300);
        return true;
    }


    private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId) {
        MenuItem item = bottomNavigationView.getMenu().findItem(itemId);
        item.setChecked(true);
    }

    abstract int getContentViewId();

    abstract int getNavigationMenuItemId();

}
