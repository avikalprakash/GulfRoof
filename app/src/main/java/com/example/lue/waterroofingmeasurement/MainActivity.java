package com.example.lue.waterroofingmeasurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Adapter.UserSessionManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn, btncustm, buttonExit, buttonAdmin;
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new UserSessionManager(getApplicationContext());
        btn = (Button) findViewById(R.id.push_button);
        btncustm = (Button) findViewById(R.id.btncust);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        buttonAdmin = (Button) findViewById(R.id.btnAdmin);
        buttonAdmin.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);

            }
        });
        btncustm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent(MainActivity.this, Registration.class);
               // startActivity(i);
            }

        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonExit:
                finish();
                break;
            case R.id.btnAdmin:
                startActivity(new Intent(getApplicationContext(), AdminLogin.class));
                break;
        }
    }
}