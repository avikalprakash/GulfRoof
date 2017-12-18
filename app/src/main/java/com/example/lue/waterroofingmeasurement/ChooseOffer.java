package com.example.lue.waterroofingmeasurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseOffer extends AppCompatActivity implements View.OnClickListener {
    Button newOffer, Existing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_offer);
        newOffer=(Button)findViewById(R.id.newEnter);
        Existing=(Button)findViewById(R.id.existing);
        newOffer.setOnClickListener(this);
        Existing.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.newEnter:
                startActivity(new Intent(getApplicationContext(), Registration.class));
                break;
            case R.id.existing:
                startActivity(new Intent(getApplicationContext(), CustomerDetails.class));
                break;
        }
    }
}
