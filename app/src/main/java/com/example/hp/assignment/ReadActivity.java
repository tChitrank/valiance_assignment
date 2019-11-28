package com.example.hp.assignment;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {
    TextView pname,review,drname,drtitle;
    ImageView clearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        clearView = view.findViewById(R.id.searchClose);

        Intent intent = getIntent();
        String intString = intent.getExtras().getString("table");

        pname = findViewById(R.id.patient1);
        review = findViewById(R.id.review1);
        drname = findViewById(R.id.drname1);
        drtitle = findViewById(R.id.drtitle1);

        if(intString.equals("FORTIS")){
            pname.setText("Mr.Akshay");
            review.setText("Mr sivaraj and his team have been brilliantin operations for cataracts in both of my eyes\n" +
                    "I am 82 and mr sivaraj has given me the best vision of my life\n" +
                    "A brilliant surgeon");
            drname.setText("Mr.Sivraj");
            drtitle.setText("Eye Surgeon");
        }
        clearView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ReadActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
