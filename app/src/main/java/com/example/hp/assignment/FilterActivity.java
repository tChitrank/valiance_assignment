package com.example.hp.assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FilterActivity extends AppCompatActivity {
    ImageView closeView;
    Button locality,radiusView,ratingsView;
    CardView localcv,radiuscv,ratingscv;
    ImageButton sector39,sector62;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    CheckBox km1,km2,km3,star5,star4,star3,star2;
    LinearLayout lsector39,lsector62;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        closeView = view.findViewById(R.id.searchClose);

        sp = getSharedPreferences("My Pref",MODE_PRIVATE);
        edit = sp.edit();
        locality = findViewById(R.id.local);
        radiusView = findViewById(R.id.radius);
        ratingsView = findViewById(R.id.ratings);
        localcv = findViewById(R.id.localcv);
        radiuscv = findViewById(R.id.radiuscv);
        ratingscv = findViewById(R.id.ratingscv);
        sector39 = findViewById(R.id.sector39);
        sector62 = findViewById(R.id.sector62);
        km1 = findViewById(R.id.km1);
        km2 = findViewById(R.id.km2);
        km3 = findViewById(R.id.km3);
        star2 = findViewById(R.id.rated2);
        star3 = findViewById(R.id.rated3);
        star4 = findViewById(R.id.rated4);
        star5 = findViewById(R.id.rated5);
        lsector39 = findViewById(R.id.layout39);
        lsector62 = findViewById(R.id.layout62);

        locality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localcv.setVisibility(View.VISIBLE);
                radiuscv.setVisibility(View.GONE);
                ratingscv.setVisibility(View.GONE);
            }
        });
        radiusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localcv.setVisibility(View.GONE);
                radiuscv.setVisibility(View.VISIBLE);
                ratingscv.setVisibility(View.GONE);
            }
        });
        ratingsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localcv.setVisibility(View.GONE);
                radiuscv.setVisibility(View.GONE);
                ratingscv.setVisibility(View.VISIBLE);
            }
        });

        sector39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lsector39.setVisibility(View.GONE);
                edit.putString("sector39","no");
            }
        });
        sector62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lsector62.setVisibility(View.GONE);
                edit.putString("sector62","null");
            }
        });

        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(km1.isChecked()){
                    edit.putString("1km","yes");
                }
                if(km2.isChecked()){
                    edit.putString("2km","yes");
                }
                if(star2.isChecked()){
                    edit.putString("2star","yes");
                }
                if(star3.isChecked()){
                    edit.putString("3star","yes");
                }
                if(star4.isChecked()){
                    edit.putString("4star","yes");
                }
                if(star5.isChecked()){
                    edit.putString("5star","yes");
                }
                edit.commit();
                Intent intent= new Intent(FilterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
