package com.example.hp.assignment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {
    EditText pname,review,drname,drtitle;
    ImageButton timely,food,blood,staff;
    Button submit;
    SQLiteDatabase fortis,max;
    String patientName,reviewText,drName,drTitle;
    LinearLayout timelyV,foodV,StaffV,BloodV;
    String s1="yes",s2="yes",s3="yes",s4="yes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();


        pname = findViewById(R.id.patient);
        review = findViewById(R.id.review);
        drname = findViewById(R.id.drname);
        drtitle = findViewById(R.id.drtitle);
        timely = findViewById(R.id.timelyDr);
        food = findViewById(R.id.food);
        blood = findViewById(R.id.blood);
        staff = findViewById(R.id.staff);
        timelyV = findViewById(R.id.timeView);
        foodV = findViewById(R.id.foodView);
        StaffV = findViewById(R.id.staffView);
        BloodV = findViewById(R.id.bloodView);
        submit = findViewById(R.id.submit);


        Intent i1 = getIntent();
        final String intString = i1.getExtras().getString("table");

        fortis = openOrCreateDatabase("fortis",Context.MODE_PRIVATE,null);
        max = openOrCreateDatabase("max",Context.MODE_PRIVATE,null);
        patientName = pname.getText().toString();
        reviewText = review.getText().toString();
        drName = drname.getText().toString();
        drTitle = drtitle.getText().toString();
        timely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timelyV.setVisibility(View.GONE);
                s1="no";
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodV.setVisibility(View.GONE);
                s2="no";
            }
        });
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BloodV.setVisibility(View.GONE);
                s3="no";
            }
        });
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaffV.setVisibility(View.GONE);
                s4="no";
            }
        });


            try {
                String s = "Create table fortis(pname varchar(20),review varchar(80),drName varchar(20),drTitle varchar(4),timely varchar(50),food varchar(50),blood varchar(50),staff varchar(50))";
                fortis.execSQL(s);
            } catch (Exception e) {
            }
        try {
            String s = "Create table maxHos(pname varchar(20),review varchar(80),drName varchar(20),drTitle varchar(4),timely varchar(20),food varchar(20),blood varchar(20),staff varchar(20))";
            max.execSQL(s);
        } catch (Exception e) {
        }
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(intString.equals("fortis")){
                    String s5 = "Insert into fortis values('" + patientName + "','" + reviewText + "','"
                            + drName + "','" + drTitle + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')";
                    fortis.execSQL(s5);
                    Toast.makeText(ReviewActivity.this,"Added Success",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ReviewActivity.this,MainActivity.class);
                    startActivity(intent);}
                    else{
                        String s5 = "Insert into maxHos values('" + patientName + "','" + reviewText + "','"
                                + drName + "','" + drTitle + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')";
                        max.execSQL(s5);
                        Toast.makeText(ReviewActivity.this,"Added Success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ReviewActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
            });








    }
}
