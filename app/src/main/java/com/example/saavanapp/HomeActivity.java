package com.example.saavanapp;

import android.app.ActionBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class HomeActivity extends MainActivity {

    private RecyclerView mTrendRecyclerView;
    private RecyclerView.Adapter mTrendAdapter;
    private RecyclerView.LayoutManager mTrendLayoutManager;

    private RecyclerView RecommRecyclerView;
    private RecyclerView.Adapter RecommAdapter;
    private RecyclerView.LayoutManager RecommLayoutManager;
    private static String LOG_TAG = "HomeActivity";




    private String[] AlbumNames =new String[]
            {"Weekly Top 15",
                    "Total Dhamaal",
                    "Badla",
                    "NY se Mumbai",
                    "BIBA",
                    "Sonchiriya"};

    private String[] SongNames = new String[]{
            "Saavn",
            "Gaorov-Roshin,Laxmikant-Pyarelal",
            "Amaal Malik",
            "NaS",
            "Marshmello,Pritam",
            "Vishal Bhardwaj"
    };

    private Integer[] images = new Integer[]{
            R.drawable.weekly_top_15,
            R.drawable.total_dhamaal,
            R.drawable.badla,
            R.drawable.ny_se_mumbai,
            R.drawable.biba,
            R.drawable.sonchiriya
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Setting up custom designed action bar
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.home_actionbar);

        mTrendRecyclerView = findViewById(R.id.trending_recycler_view);
        mTrendRecyclerView.setHasFixedSize(true);
        mTrendLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mTrendRecyclerView.setLayoutManager(mTrendLayoutManager);
        mTrendAdapter = new SongsAdapter(getDataSet());
        mTrendRecyclerView.setAdapter(mTrendAdapter);


        RecommRecyclerView = findViewById(R.id.recommended_recycler_view);
        RecommRecyclerView.setHasFixedSize(true);
        RecommLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecommRecyclerView.setLayoutManager(RecommLayoutManager);
        RecommAdapter = new SongsAdapter(getDataSet());
        RecommRecyclerView.setAdapter(RecommAdapter);

    }

    @Override
    int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.home_nav_button;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((SongsAdapter) mTrendAdapter).setOnItemClickListener(
                new SongsAdapter.CustomClickListener() {

                    public void onItemClick(int position, View v) {
                        Log.i(LOG_TAG, " Clicked on Item " + position);
                    }
                });
    }

    private ArrayList<CardIcon> getDataSet() {
        ArrayList results = new ArrayList<CardIcon>();
        for (int index = 0; index < AlbumNames.length; index++) {
            CardIcon obj = new CardIcon(AlbumNames[index],
                    SongNames[index],
                    images[index]);

            results.add(index, obj);
        }
        return results;
    }

}
