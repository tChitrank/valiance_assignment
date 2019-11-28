package com.example.hp.assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button openView1,openView2,readView1,readView2;
    SharedPreferences sp ;
    SharedPreferences.Editor edit;
    SearchView searchView;
    ImageView micView,clearView,signoutView;
    CardView fortisView,maxView1;
    private static final String FORTIS_LOC="",MAX_LOC="";
    String fortisLoc,maxLoc;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        searchView = view.findViewById(R.id.searchBar);
        micView = view.findViewById(R.id.micV);
        clearView = view.findViewById(R.id.searchClose);
        signoutView = view.findViewById(R.id.signout);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        fortisView = findViewById(R.id.fortisHos);
        maxView1 = findViewById(R.id.maxHos);
        openView1 = findViewById(R.id.fortisOpen);
        openView2 = findViewById(R.id.maxOpen);
        readView1 = findViewById(R.id.fortisRead);
        readView2 = findViewById(R.id.maxRead);
        sp = getSharedPreferences("My Pref",MODE_PRIVATE);
        fortisLoc = sp.getString("sector62","");
        maxLoc = sp.getString("sector39","");


        if(fortisLoc.equals(FORTIS_LOC)){
            fortisView.setVisibility(View.VISIBLE);
        }
       /* if(fortisLoc.equals("null")){
            fortisView.setVisibility(View.GONE);
        }*/
        if(maxLoc.equals(MAX_LOC)){
            maxView1.setVisibility(View.VISIBLE);
        }
       /* if(maxLoc.equals("no")){
            maxView1.setVisibility(View.GONE);
        }*/
        micView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FilterActivity.class);
                startActivity(intent);
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if(query.equals("Eye")||query.equals("eye")){
                    fortisView.setVisibility(View.VISIBLE);
                    maxView1.setVisibility(View.GONE);
                }
                if(query.equals("Skin")||query.equals("skin")){
                    maxView1.setVisibility(View.VISIBLE);
                    fortisView.setVisibility(View.GONE);
                }
                return false;
            }
        });


        openView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReviewActivity.class);
                intent.putExtra("table","FORTIS");
                startActivity(intent);
            }
        });
        openView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReviewActivity.class);
                intent.putExtra("table","MAX");
                startActivity(intent);
            }
        });
        readView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReadActivity.class);
                intent.putExtra("table","FORTIS");
                startActivity(intent);
            }
        });
        readView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReadActivity.class);
                intent.putExtra("table","MAX");
                startActivity(intent);
            }
        });
        signoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance().signOut(getApplicationContext());
                Intent intent = new Intent(MainActivity.this,AuthActivity.class);
                startActivity(intent);
            }
        });

    }
}
