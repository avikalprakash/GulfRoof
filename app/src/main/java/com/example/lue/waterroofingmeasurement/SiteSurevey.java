package com.example.lue.waterroofingmeasurement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lue on 11-09-2017.
 */

public class SiteSurevey extends AppCompatActivity {
 Button btncalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitesurvey);


        btncalculate=(Button)findViewById(R.id.btnsurvey);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal=new Intent(SiteSurevey.this,Calculate.class);
                startActivity(cal);
            }
        });

    }
}
