package com.example.lue.waterroofingmeasurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by LUE on 14-09-2017.
 */

public class Specificationscreen extends AppCompatActivity implements View.OnClickListener {

    CheckBox ta1, ta2, lw75, lw100, pu35, pu50, pucoat, lqm, lqmr, gtx, poly;
    EditText rateseen;
    Button buttonok;
    String c1, c2, c3, c4, c5, c6, c7, c8,c9, c10, c11;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    String C1="c1";
    String C2="c2";
    String C3="c3";
    String C4="c4";
    String C5="c5";
    String C6="c6";
    String C7="c7";
    String C8="c8";
    String C9="c9";
    String C10="c10";
    String C11="c11";
    public static final String MyPref = "MyPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specification);
        sharedpreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedpreferences.edit();
        sharedpreferences=getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        c1 = sharedpreferences.getString(C1, "");
        c2 = sharedpreferences.getString(C2, "");
        c3 = sharedpreferences.getString(C3, "");
        c4 = sharedpreferences.getString(C4, "");
        c5 = sharedpreferences.getString(C5, "");
        c6 = sharedpreferences.getString(C6, "");
        c7 = sharedpreferences.getString(C7, "");
        c8 = sharedpreferences.getString(C8, "");
        c9 = sharedpreferences.getString(C9, "");
        c10 = sharedpreferences.getString(C10, "");
        c11 = sharedpreferences.getString(C11, "");
        ta1 = (CheckBox) findViewById(R.id.ta1);
        ta2 = (CheckBox) findViewById(R.id.ta2);
        lw75 = (CheckBox) findViewById(R.id.lw75);
        lw100 = (CheckBox) findViewById(R.id.lw100);
        pu35 = (CheckBox) findViewById(R.id.pu35);
        pu50 = (CheckBox) findViewById(R.id.pu75);
        pucoat = (CheckBox) findViewById(R.id.pucoat);
        lqm = (CheckBox) findViewById(R.id.LqM);
        lqmr = (CheckBox) findViewById(R.id.LqMr);
        gtx = (CheckBox) findViewById(R.id.gtx);
        poly = (CheckBox) findViewById(R.id.poly50);
        rateseen = (EditText) findViewById(R.id.myrate);
        buttonok=(Button)findViewById(R.id.buttonok);
        buttonok.setOnClickListener(this);
        ta1.setOnClickListener(this);
        ta1.setOnClickListener(this);
        ta2.setOnClickListener(this);
        lw75.setOnClickListener(this);
        lw100.setOnClickListener(this);
        pu35.setOnClickListener(this);
        pu50.setOnClickListener(this);
        pucoat.setOnClickListener(this);
        lqm.setOnClickListener(this);
        lqmr.setOnClickListener(this);
        gtx.setOnClickListener(this);
        poly.setOnClickListener(this);



 /*   ta1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // onClick starts
            switch (view.getId()){

//                case R.id.ta1:
//                    rateseen.setText("500");
//                    break;
                case R.id.ta2:
                    rateseen.setText("200");
                    break;


            }
        }
    });*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

               case R.id.ta1:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                    //rateseen.setText("500");
                   rateseen.setText(c1);
                   ta2.setChecked(false);
                   lw75.setChecked(false);
                   lw100.setChecked(false);
                   pu35.setChecked(false);
                   pu50.setChecked(false);
                   pucoat.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
                    break;
               case R.id.ta2:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                   ta1.setChecked(false);
                   lw75.setChecked(false);
                   lw100.setChecked(false);
                   pu35.setChecked(false);
                   pu50.setChecked(false);
                   pucoat.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
               // rateseen.setText("200");
                   rateseen.setText(c7);
                break;
               case R.id.lw75:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
               // rateseen.setText("300");
                   rateseen.setText(c2);
                   ta1.setChecked(false);
                   ta2.setChecked(false);
                   lw100.setChecked(false);
                   pu35.setChecked(false);
                   pu50.setChecked(false);
                   pucoat.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
                break;
               case R.id.lw100:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                   ta1.setChecked(false);
                   ta2.setChecked(false);
                   lw75.setChecked(false);
                   pu35.setChecked(false);
                   pu50.setChecked(false);
                   pucoat.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
              //  rateseen.setText("400");
                   rateseen.setText(c8);
                break;

               case R.id.pu35:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                   ta1.setChecked(false);
                   ta2.setChecked(false);
                   lw75.setChecked(false);
                   lw100.setChecked(false);
                   pu50.setChecked(false);
                   pucoat.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
               // rateseen.setText("210");
                   rateseen.setText(c3);
                break;
               case R.id.pu75:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                   ta1.setChecked(false);
                   ta2.setChecked(false);
                   lw75.setChecked(false);
                   lw100.setChecked(false);
                   pu35.setChecked(false);
                   pucoat.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
                //rateseen.setText("250");
                   rateseen.setText(c9);
                break;
               case R.id.pucoat:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                   ta1.setChecked(false);
                   ta2.setChecked(false);
                   lw75.setChecked(false);
                   lw100.setChecked(false);
                   pu35.setChecked(false);
                   pu50.setChecked(false);
                   lqm.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
               // rateseen.setText("100");
                   rateseen.setText(c4);
                break;
               case R.id.LqM:
                   //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                   ta1.setChecked(false);
                   ta2.setChecked(false);
                   lw75.setChecked(false);
                   lw100.setChecked(false);
                   pu35.setChecked(false);
                   pu50.setChecked(false);
                   pucoat.setChecked(false);
                   lqmr.setChecked(false);
                   gtx.setChecked(false);
                   poly.setChecked(false);
                //rateseen.setText("150");
                   rateseen.setText(c10);
                break;
            case R.id.LqMr:
                //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                ta1.setChecked(false);
                ta2.setChecked(false);
                lw75.setChecked(false);
                lw100.setChecked(false);
                pu35.setChecked(false);
                pu50.setChecked(false);
                pucoat.setChecked(false);
                lqm.setChecked(false);
                gtx.setChecked(false);
                poly.setChecked(false);
               // rateseen.setText("222");
                rateseen.setText(c11);
                break;
            case R.id.gtx:
                //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                ta1.setChecked(false);
                ta2.setChecked(false);
                lw75.setChecked(false);
                lw100.setChecked(false);
                pu35.setChecked(false);
                pu50.setChecked(false);
                pucoat.setChecked(false);
                lqm.setChecked(false);
                lqmr.setChecked(false);
                poly.setChecked(false);
               // rateseen.setText("300");
                rateseen.setText(c6);
                break;
            case R.id.poly50:
               // rateseen.setText("350");
                rateseen.setText(c5);
                //ta1, ta2, lw75, lw100, pu35, pu75, pucoat, lqm, lqmr, gtx, poly
                ta1.setChecked(false);
                ta2.setChecked(false);
                lw75.setChecked(false);
                lw100.setChecked(false);
                pu35.setChecked(false);
                pu50.setChecked(false);
                pucoat.setChecked(false);
                lqm.setChecked(false);
                lqmr.setChecked(false);
                gtx.setChecked(false);
                break;

            case R.id.buttonok:
                if (ta1.isChecked()){
                    c1=rateseen.getText().toString();
                    editor.putString("c1", c1);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c1, Toast.LENGTH_LONG).show();
                }else if (lw75.isChecked()){
                    c2=rateseen.getText().toString();
                    editor.putString("c2", c2);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c2, Toast.LENGTH_LONG).show();
                }else if (pu35.isChecked()){
                    c3=rateseen.getText().toString();
                    editor.putString("c3", c3);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c3, Toast.LENGTH_LONG).show();
                }else if (pucoat.isChecked()){
                    c4=rateseen.getText().toString();
                    editor.putString("c4", c4);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c4, Toast.LENGTH_LONG).show();
                }else if (poly.isChecked()){
                    c5=rateseen.getText().toString();
                    editor.putString("c5", c5);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c5, Toast.LENGTH_LONG).show();
                }else if (gtx.isChecked()){
                    c6=rateseen.getText().toString();
                    editor.putString("c6", c6);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c6, Toast.LENGTH_LONG).show();
                }else if (ta2.isChecked()){
                    c7=rateseen.getText().toString();
                    editor.putString("c7", c7);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c7, Toast.LENGTH_LONG).show();

                }else if (lw100.isChecked()){
                    c8=rateseen.getText().toString();
                    editor.putString("c8", c8);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c8, Toast.LENGTH_LONG).show();
                }else if (pu50.isChecked()){
                    c9=rateseen.getText().toString();
                    editor.putString("c9", c9);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c9, Toast.LENGTH_LONG).show();
                }else if (lqm.isChecked()){
                    c10=rateseen.getText().toString();
                    editor.putString("c10", c10);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c10, Toast.LENGTH_LONG).show();
                }else if (lqmr.isChecked()){
                    c11=rateseen.getText().toString();
                    editor.putString("c11", c11);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), c11, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
