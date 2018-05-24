package com.example.lue.waterroofingmeasurement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import Adapter.UserSessionManager;

/**
 * Created by lue on 11-09-2017.
 */

public class Home extends AppCompatActivity implements View.OnClickListener {
TextView txtmakeoffer,txtspef,txtsetting,txtcustomerlist;
    TextView layoutMakeOffer, customerListLayout, layoutSpecification;
  //  UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
      /*  session = new UserSessionManager(getApplicationContext());
        if (session.checkLogin())
            finish();*/
        layoutMakeOffer=(TextView)findViewById(R.id.layoutMakeOffer);
        customerListLayout=(TextView)findViewById(R.id.customerListLayout);
        layoutSpecification=(TextView)findViewById(R.id.layoutSpecification);
       // txtspef=(TextView)findViewById(R.id.txtspecification);
       // txtcustomerlist=(TextView) findViewById(R.id.txtcustomerlist);
        txtsetting=(TextView)findViewById(R.id.txtsetting);
        customerListLayout.setOnClickListener(this);
        layoutMakeOffer.setOnClickListener(this);
        layoutSpecification.setOnClickListener(this);


        txtsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent survey=new Intent(Home.this,Profile.class);
                startActivity(new Intent(Home.this,Profile.class));
            }
        });

//        txtquote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent quot=new Intent(Home.this,OneRoof.class);
//                startActivity(quot);
//            }
//        });
// addcustomer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent custom=new Intent(Home.this,Registration.class);
//                startActivity(custom);
//            }
//        });

    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           /* case R.id.logout_menu:
                signOut();
                break;*/
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.customerListLayout:
               // Intent custmlist=new Intent(Home.this,CustomerDetails.class);
                startActivity(new Intent(Home.this,CustomerList.class));
                break;
            case R.id.layoutMakeOffer:
               // Intent sale=new Intent(Home.this,Registration.class);
                startActivity(new Intent(Home.this,ChooseOffer.class));
                break;
            case R.id.layoutSpecification:
               // Intent quot =new Intent(Home.this, Specificationscreen.class);
                startActivity(new Intent(Home.this, Specificationscreen.class));
                break;
        }
    }
   /* private void signOut()
    {
        session.logoutUser();
        Home.this.finish();
    }*/
}
