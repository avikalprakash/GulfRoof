package com.example.lue.waterroofingmeasurement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lue on 13-09-2017.
 */

public class OneRoof extends AppCompatActivity  {
    Button moreroof, btndone;
    EditText codst1;
    String totalSpecification="";
    String speci1="TA 1";
    String speci2="LW 75";
    String speci3="PU 35";
    String speci4="PU COAT";
    String speci5="Poly 50";
    String speci6="GTX";
    String speci7="TA 2";
    String speci8="Lw 100";
    String speci9="PU 50";
    String speci10="LqM";
    String speci11="Lqrm";
    int z=2;

    String TotalSpecification="";
    String speciA="Torch Applied membrane single layer";
    String speciB="Light weight foam screed 75mm";
    String speciC="Polyurethane foam 35mm";
    String speciD="polyurethane foam coating";
    String speciE="Polystrene board 50mm";
    String speciF="Geotextile 100gsm";
    String speciG="Torch Applied membrane double layer";
    String speciH="Light weight foam screed 100mm";
    String speciI="Polyurethane foam 75mm";
    String speciJ="Liquid membrane";
    String speciK="Liquid reinforced membrane";

    CheckBox chk1, chk2, chk3, chk4, chk5, chk7, chk8, chk9,chk6,chk10,chk11 ;
    public static final String PREFS_VIEW= "PREFS_VIEW";
    public static final String PREFS_ROOFTYPE= "PREFS_ROOFTYPE";
    public static final String PREFS_AREA= "PREFS_AREA";
    public static final String PREFS_NUMBER= "PREF_NUMBER";
    public static final String PREFS_SPECIFICATION= "PREFS_SPECIFICATION";
    public static final String PREFS_FULL_SPECIFICATION= "PREFS_FULL_SPECIFICATION";
    public static final String PREFS_COST= "PREFS_COST";
    public static final String KEY_PREFS_VIEW = "KEY_ROOVIEW";
    public static final String KEY_ROOFTYPE = "KEY_ROOFTYPE";
    public static final String KEY_AREA = "KEY_AREA";
    public static final String KEY_NUMBER = "KEY_NUMBER";
    public static final String KEY_COST = "KEY_COST";
    public static final String KEY_SPECIFICATION = "KEY_SPECIFICATION";
    public static final String KEY_FULL_SPECIFICATION = "KEY_FULL_SPECIFICATION";
    private SharedPreferences prefRoofView;
    private SharedPreferences prefsRooftype;
    private SharedPreferences prefsArea;
    private SharedPreferences prefsNumber;
    private SharedPreferences prefscost;
    private SharedPreferences prefsSpecification;
    private SharedPreferences prefsFullSpecification;
    float c1=2.500f;
    float c2=3.300f;
    float c3=3.300f;
    float c4=2.000f;
    float c5=3.000f;
    float c6=0.300f;
    float c7=5.000f;
    float c8=4.300f;
    float c9=4.300f;
    float c10=2.500f;
    float c11=2.500f;
    float totalC=0.0f;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    public static final String C1="c1";
    public static final String C2="c2";
    public static final String C3="c3";
    public static final String C4="c4";
    public static final String C5="c5";
    public static final String C6="c6";
    public static final String C7="c7";
    public static final String C8="c8";
    public static final String C9="c9";
    public static final String C10="c10";
    public static final String C11="c11";
    public static final String MyPref = "MyPref";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roofone);
        moreroof = (Button) findViewById(R.id.btn_more);
        btndone = (Button) findViewById(R.id.btn_done);

       final  TextView roofview=(TextView)findViewById(R.id.textViewHead);
       final  EditText rooftype=(EditText) findViewById(R.id.editText3);
       final  EditText area=(EditText) findViewById(R.id.area);
       final  EditText numer=(EditText) findViewById(R.id.editText7);
         codst1=(EditText) findViewById(R.id.editText8);
        sharedpreferences=getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        String  ch1 = sharedpreferences.getString(C1, "");
        String  ch2 = sharedpreferences.getString(C2, "");
        String  ch3 = sharedpreferences.getString(C3, "");
        String  ch4 = sharedpreferences.getString(C4, "");
        String  ch5 = sharedpreferences.getString(C5, "");
        String  ch6 = sharedpreferences.getString(C6, "");
        String  ch7 = sharedpreferences.getString(C7, "");
        String  ch8 = sharedpreferences.getString(C8, "");
        String  ch9 = sharedpreferences.getString(C9, "");
        String  ch10 = sharedpreferences.getString(C10, "");
        String  ch11 = sharedpreferences.getString(C11, "");

        /*if (!ch1.equals("")){
            c1= Double.parseDouble(ch1);
        }
        if (!ch2.equals("")){
            c2= Double.parseDouble(ch2);
        }
        if (!ch3.equals("")){
            c3= Double.parseDouble(ch3);
        }
        if (!ch4.equals("")){
            c4= Double.parseDouble(ch4);
        }
        if (!ch5.equals("")){
            c5= Double.parseDouble(ch5);
        }
        if (!ch6.equals("")){
            c6= Double.parseDouble(ch6);
        }
        if (!ch7.equals("")){
            c7= Double.parseDouble(ch7);
        }
        if (!ch8.equals("")){
            c8= Double.parseDouble(ch8);
        }
        if (!ch9.equals("")){
            c9= Double.parseDouble(ch9);
        }
        if (!ch10.equals("")){
            c10= Double.parseDouble(ch10);
        }
        if (!ch11.equals("")){
            c11= Double.parseDouble(ch11);
        }*/

        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        chk3 = (CheckBox) findViewById(R.id.checkBox3);
        chk4 = (CheckBox) findViewById(R.id.checkBox4);
        chk5 = (CheckBox) findViewById(R.id.checkBox5);
        chk6 = (CheckBox) findViewById(R.id.checkBox6);
        chk7 = (CheckBox) findViewById(R.id.checkBox7);
        chk8 = (CheckBox) findViewById(R.id.checkBox8);
        chk9 = (CheckBox) findViewById(R.id.checkBox9);
        chk10 = (CheckBox) findViewById(R.id.checkBox10);
        chk11 = (CheckBox) findViewById(R.id.checkBox11);
        //chk10=(CheckBox) findViewById(R.id.checkBox15);





      /*  chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m=0;
                m++;

                if (chk1.isChecked()&& m>0) {
                    z++;
                    totalC = c1;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = speci1;
                    TotalSpecification = speciA + "(" + String.valueOf(c1) + "/Sq.m BD)";


                } if(!chk1.isChecked()) {
                    m--;
                    z--;
                    totalC = totalC - c1;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk2.isChecked()&& m>0) {

                    totalC = totalC + c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci2;
                    TotalSpecification = TotalSpecification + ", " + speciB + "(" + String.valueOf(c2) + "/Sq.m BD)";
                    String s = "v";

                }
                if (chk3.isChecked()&& m>0) {
                    totalC = totalC + c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci3;
                    TotalSpecification = TotalSpecification + ", " + speciC + "(" + String.valueOf(c3) + "/Sq.m BD)";

                }
                if (chk4.isChecked()&& m>0) {
                    totalC = totalC + c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci4;
                    TotalSpecification = TotalSpecification + ", " + speciD + "(" + String.valueOf(c4) + "/Sq.m BD)";
                }
                if (chk5.isChecked()&& m>0) {
                    totalC = totalC + c5;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci5;
                    TotalSpecification = TotalSpecification + ", " + speciE + "(" + String.valueOf(c5) + "/Sq.m BD)";
                }
                if (chk6.isChecked()&& m>0) {
                    totalC = totalC + c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci6;
                    TotalSpecification = TotalSpecification + ", " + speciF + "(" + String.valueOf(c6) + "/Sq.m BD)";
                }
                if (chk7.isChecked()&& m>0) {
                    totalC = totalC + c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci7;
                    TotalSpecification = TotalSpecification + ", " + speciG + "(" + String.valueOf(c7) + "/Sq.m BD)";
                }
                if (chk8.isChecked()&& m>0) {
                    totalC = totalC + c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci8;
                    TotalSpecification = TotalSpecification + ", " + speciH + "(" + String.valueOf(c8) + "/Sq.m BD)";
                }
                if (chk9.isChecked()&& m>0) {
                    totalC = totalC + c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci9;
                    TotalSpecification = TotalSpecification + ", " + speciI + "(" + String.valueOf(c9) + "/Sq.m BD)";
                }
                if (chk10.isChecked()&& m>0) {
                    totalC = totalC + c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci10;
                    TotalSpecification = TotalSpecification + ", " + speciJ + "(" + String.valueOf(c10) + "/Sq.m BD)";
                }
                if (chk11.isChecked()&& m>0) {
                    totalC = totalC + c11;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci11;
                    TotalSpecification = TotalSpecification + ", " + speciK + "(" + String.valueOf(c11) + "/Sq.m BD)";
                }


              *//*  chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }

        });

        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                i++;

                if (chk2.isChecked()&& i>0) {
                    totalC=c2;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci2;
                    TotalSpecification=speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }

                if(!chk2.isChecked()) {
                    i--;
                    z--;
                    totalC=totalC-c2;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked()&& i>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                    String s="v";


                }
                if ( chk3.isChecked()&& i>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk4.isChecked()&& i>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked()&& i>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked()&& i>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked()&& i>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked()&& i>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked()&& i>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && i>0) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && i>0) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
                *//*chk1.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int j=0;
                j++;
                if (chk3.isChecked() && j>0) {
                    totalC=c3;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci3;
                    TotalSpecification=speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }if (!chk3.isChecked()){
                    j--;
                    z--;
                    totalC=totalC-c3;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && j>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && j>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && j>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+" /Sq.m BD)";
                }
                if (chk5.isChecked() && j>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && j>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && j>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD )";
                }
                if (chk8.isChecked() && j>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && j>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && j>0 ) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && j>0) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
            }


       *//* chk1.setChecked(false);
        chk2.setChecked(false);
        chk4.setChecked(false);
        chk5.setChecked(false);
        chk6.setChecked(false);
        chk7.setChecked(false);
        chk8.setChecked(false);
        chk9.setChecked(false);
        chk10.setChecked(false);
        chk11.setChecked(false);*//*


        });

        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int k=0;
                k++;
                if (chk4.isChecked() && k>0) {
                    totalC=c4;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci4;
                    TotalSpecification=speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }if (! chk4.isChecked()){
                    k--;
                    z--;
                    totalC=totalC-c4;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && k>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && k>0) {
                    totalC=totalC+c2;
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && k>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && k>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && k>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && k>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && k>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && k>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && k>0) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && k>0) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
                *//*chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });

        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l=0;
                l++;
                if (chk5.isChecked()&& l>0) {
                    totalC=c5;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci5;
                    TotalSpecification=speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }if (! chk5.isChecked()){
                    l--;
                    z--;
                    totalC=totalC-c5;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked()&& l>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked()&& l>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked()&& l>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk3.isChecked()&& l>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk6.isChecked()&& l>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked()&& l>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked()&& l>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked()&& l>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && l>0) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && l>0) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
                *//*chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });
        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n=0;
                n++;
                if (chk6.isChecked()&& n>0) {
                    totalC=c6;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci6;
                    TotalSpecification=speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }if (! chk6.isChecked()){
                    n--;
                    z--;
                    totalC=totalC-c6;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked()&& n>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked()&& n>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked()&& n>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked()&& n>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk3.isChecked()&& n>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk7.isChecked()&& n>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked()&& n>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked()&& n>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && n>0) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && n>0) {
                    totalC = c11 + totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
              *//*  chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });

        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int o=0;
                o++;
                if (chk7.isChecked() && o>0) {
                    totalC=c7;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci7;
                    TotalSpecification=speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }if (!chk7.isChecked()){
                    o--;
                    z--;
                    totalC=totalC-c7;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && o>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && o>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && o>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && o>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && o>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && o>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && o>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && o>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && o>0 ) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && o>0 ) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
            *//*    chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });

        chk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p=0;
                p++;
                if (chk8.isChecked() && p>0) {
                    totalC=c8;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci8;
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }if (!chk8.isChecked()){
                    p--;
                    z--;
                    totalC=totalC-c8;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && p>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && p>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && p>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && p>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && p>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && p>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && p>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && p>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked()  && p>0) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && p>0) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
              *//*  chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });

        chk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q=0;
                q++;
                if (chk9.isChecked() && q>0) {
                    totalC=c9;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci9;
                    TotalSpecification=speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }if (!chk9.isChecked()){
                    q--;
                    z--;
                    totalC=totalC-c9;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && q>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && q>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && q>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && q>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && q>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && q>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && q>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && q>0) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk10.isChecked()  && q>0) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && q>0 ) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
               *//* chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });


        chk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int r=0;
                r++;
                if (chk10.isChecked() && r>0) {
                    totalC=c10;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci10;
                    TotalSpecification=speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }if (!chk10.isChecked()){
                    z--;
                    totalC=totalC-c10;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && r>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && r>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && r>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && r>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && r>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && r>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && r>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && r>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && r>0 ) {
                    totalC=totalC+c3;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && r>0) {
                    totalC=c11+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
               *//* chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk11.setChecked(false);*//*
            }
        });
        chk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s=0;
                s++;
                if (chk11.isChecked() && s>0) {
                    totalC=c11;
                    z++;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=speci11;
                    TotalSpecification=speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }if (!chk11.isChecked()){
                    s--;
                    z--;
                    totalC=totalC-c11;
                    codst1.setText(String.valueOf(totalC));
                }
                if (z==2){
                    codst1.getText().clear();
                }
                if (chk1.isChecked() && s>0) {
                    totalC=c1+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && s>0) {
                    totalC=totalC+c2;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && s>0) {
                    totalC=totalC+c4;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && s>0) {
                    totalC=totalC+c5;
                    codst1.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && s>0) {
                    totalC=totalC+c6;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && s>0) {
                    totalC=totalC+c7;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && s>0) {
                    totalC=totalC+c8;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && s>0) {
                    totalC=totalC+c9;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && s>0 ) {
                    totalC=totalC+c10;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && s>0 ) {
                    totalC=c3+totalC;
                    codst1.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
               *//* chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);*//*
            }
        });
*/

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c1;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci1;
                        TotalSpecification =speciA + "(" + String.valueOf(c1) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci1;
                        TotalSpecification =TotalSpecification+", "+ speciA + "(" + String.valueOf(c1) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c1;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci1, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciA + "(" + String.valueOf(c1) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciA, "").replace("(", "").replace(String.valueOf(c1), "")
                    .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c2;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci2;
                        TotalSpecification = speciB + "(" + String.valueOf(c2) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci2;
                        TotalSpecification =TotalSpecification+", "+ speciB + "(" + String.valueOf(c2) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c2;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci2, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciB + "(" + String.valueOf(c2) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciB, "").replace("(", "").replace(String.valueOf(c2), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c3;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci3;
                        TotalSpecification = speciC + "(" + String.valueOf(c1) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci3;
                        TotalSpecification =TotalSpecification+", "+ speciC + "(" + String.valueOf(c3) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c3;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci3, "").replace(",", "");
                //    TotalSpecification =TotalSpecification+", "+ speciC + "(" + String.valueOf(c3) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciC, "").replace("(", "").replace(String.valueOf(c3), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c4;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci4;
                        TotalSpecification = speciD + "(" + String.valueOf(c4) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci4;
                        TotalSpecification =TotalSpecification+", "+ speciD + "(" + String.valueOf(c4) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c4;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci4, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciD + "(" + String.valueOf(c4) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciD, "").replace("(", "").replace(String.valueOf(c4), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c5;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci5;
                        TotalSpecification = speciF + "(" + String.valueOf(c5) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci5;
                        TotalSpecification =TotalSpecification+", "+ speciF + "(" + String.valueOf(c5) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c5;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci5, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciF + "(" + String.valueOf(c5) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciE, "").replace("(", "").replace(String.valueOf(c5), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c6;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci6;
                        TotalSpecification = speciF + "(" + String.valueOf(c6) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci6;
                        TotalSpecification =TotalSpecification+", "+ speciF + "(" + String.valueOf(c6) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c6;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci6, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciF + "(" + String.valueOf(c6) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciF, "").replace("(", "").replace(String.valueOf(c6), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c7;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci7;
                        TotalSpecification = speciG + "(" + String.valueOf(c7) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci7;
                        TotalSpecification =TotalSpecification+", "+ speciG + "(" + String.valueOf(c7) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c7;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci7, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciG + "(" + String.valueOf(c7) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciG, "").replace("(", "").replace(String.valueOf(c7), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c8;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci8;
                        TotalSpecification =speciH + "(" + String.valueOf(c8) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci8;
                        TotalSpecification =TotalSpecification+", "+ speciH + "(" + String.valueOf(c8) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c8;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci8, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciH + "(" + String.valueOf(c8) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciH, "").replace("(", "").replace(String.valueOf(c8), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c9;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci9;
                        TotalSpecification =speciI + "(" + String.valueOf(c9) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci9;
                        TotalSpecification =TotalSpecification+", "+ speciI + "(" + String.valueOf(c9) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c9;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci9, "").replace(",", "");
                 //   TotalSpecification =TotalSpecification+", "+ speciI + "(" + String.valueOf(c9) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciI, "").replace("(", "").replace(String.valueOf(c9), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c10;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci10;
                        TotalSpecification = speciJ + "(" + String.valueOf(c10) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci10;
                        TotalSpecification =TotalSpecification+", "+ speciJ + "(" + String.valueOf(c10) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c10;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci10, "").replace(",", "");
                  //  TotalSpecification =TotalSpecification+", "+ speciJ + "(" + String.valueOf(c10) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciJ, "").replace("(", "").replace(String.valueOf(c10), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });
        chk11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    z++;
                    totalC = totalC+c11;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    if (totalSpecification.equals("")){
                        totalSpecification =speci11;
                        TotalSpecification =speciK + "(" + String.valueOf(c11) + "/Sq.m BD)";
                    }else {
                        totalSpecification =totalSpecification+", "+ speci11;
                        TotalSpecification =TotalSpecification+", "+ speciK + "(" + String.valueOf(c11) + "/Sq.m BD)";
                    }
                }else if (!compoundButton.isChecked()){
                    z--;
                    totalC = totalC - c11;
                    String fTotalC = String.format("%.03f", totalC);
                    codst1.setText(String.valueOf(fTotalC));
                    totalSpecification= totalSpecification.replace(speci11, "").replace(",", "");
                   // TotalSpecification =TotalSpecification+", "+ speciK + "(" + String.valueOf(c11) + "/Sq.m BD)";
                    TotalSpecification =TotalSpecification.replace(speciK, "").replace("(", "").replace(String.valueOf(c11), "")
                            .replace("/Sq.m BD)", "");
                }
                if (z==2){
                    codst1.getText().clear();
                }
            }
        });


        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String sType= rooftype.getText().toString();
                String sArea= area.getText().toString();
                String sNum= numer.getText().toString();
                String sCost= codst1.getText().toString();
                if (sNum.equals("") || sCost.equals("") || sType.equals("") || sArea.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(OneRoof.this);
                    builder.setMessage("Please fill all the details")
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else {
                    try {
                        prefRoofView = getSharedPreferences(OneRoof.KEY_PREFS_VIEW, Context.MODE_PRIVATE);
                        prefsRooftype = getSharedPreferences(OneRoof.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
                        prefsArea = getSharedPreferences(OneRoof.PREFS_AREA, Context.MODE_PRIVATE);
                        prefsNumber = getSharedPreferences(OneRoof.PREFS_NUMBER, Context.MODE_PRIVATE);
                        prefsSpecification = getSharedPreferences(OneRoof.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
                        prefsFullSpecification = getSharedPreferences(OneRoof.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);
                        prefscost = getSharedPreferences(OneRoof.PREFS_COST, Context.MODE_PRIVATE + Context.MODE_PRIVATE);
                        SharedPreferences.Editor privateEdit = prefsRooftype.edit();
                        SharedPreferences.Editor worldReadEdit = prefsArea.edit();
                        SharedPreferences.Editor worldWriteEdit = prefsNumber.edit();
                        SharedPreferences.Editor worldReadWriteEdit = prefscost.edit();
                        SharedPreferences.Editor worldReadWriteSpecEdit = prefsSpecification.edit();
                        SharedPreferences.Editor worldReadWriteFullSpecEdit = prefsFullSpecification.edit();
                        SharedPreferences.Editor worlldView = prefRoofView.edit();

                        privateEdit.putString(OneRoof.KEY_ROOFTYPE, rooftype.getText().toString());
                        worldReadEdit.putString(OneRoof.KEY_AREA, area.getText().toString());
                        worldWriteEdit.putString(OneRoof.KEY_NUMBER, numer.getText().toString());
                        worldReadWriteEdit.putString(OneRoof.KEY_COST, codst1.getText().toString());
                        worldReadWriteSpecEdit.putString(OneRoof.KEY_SPECIFICATION, totalSpecification);
                        worldReadWriteFullSpecEdit.putString(OneRoof.KEY_FULL_SPECIFICATION, TotalSpecification);
                        worlldView.putString(OneRoof.KEY_PREFS_VIEW, roofview.getText().toString());
                        //Commit the sharedPreferences into a file
                        privateEdit.commit();
                        worldReadEdit.commit();
                        worldWriteEdit.commit();
                        worldReadWriteEdit.commit();
                        worldReadWriteSpecEdit.commit();
                        worldReadWriteFullSpecEdit.commit();
                        worlldView.commit();
                    }catch (Exception e){

                    }
                    startActivity(new Intent(OneRoof.this, OrderDetails.class));

                }
//        databaseHandler1.insertData();

            }
        });
        moreroof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sType= rooftype.getText().toString();
                String sArea= area.getText().toString();
                String sNum= numer.getText().toString();
                String sCost= codst1.getText().toString();
                if (sNum.equals("") || sCost.equals("") || sType.equals("") || sArea.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(OneRoof.this);
                    builder.setMessage("Please fill all the details")
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                } else {


                    try {
                        prefRoofView = getSharedPreferences(OneRoof.KEY_PREFS_VIEW, Context.MODE_PRIVATE);
                        prefsRooftype = getSharedPreferences(OneRoof.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
                        prefsArea = getSharedPreferences(OneRoof.PREFS_AREA, Context.MODE_PRIVATE);
                        prefsNumber = getSharedPreferences(OneRoof.PREFS_NUMBER, Context.MODE_PRIVATE);
                        prefsSpecification = getSharedPreferences(OneRoof.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
                        prefsFullSpecification = getSharedPreferences(OneRoof.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);
                        prefscost = getSharedPreferences(OneRoof.PREFS_COST, Context.MODE_PRIVATE + Context.MODE_PRIVATE);
                        SharedPreferences.Editor privateEdit = prefsRooftype.edit();
                        SharedPreferences.Editor worldReadEdit = prefsArea.edit();
                        SharedPreferences.Editor worldWriteEdit = prefsNumber.edit();
                        SharedPreferences.Editor worldReadWriteEdit = prefscost.edit();
                        SharedPreferences.Editor worldReadWriteSpecEdit = prefsSpecification.edit();
                        SharedPreferences.Editor worldReadWriteFullSpecEdit = prefsFullSpecification.edit();
                        SharedPreferences.Editor worlldView = prefRoofView.edit();

                        privateEdit.putString(OneRoof.KEY_ROOFTYPE, rooftype.getText().toString());
                        worldReadEdit.putString(OneRoof.KEY_AREA, area.getText().toString());
                        worldWriteEdit.putString(OneRoof.KEY_NUMBER, numer.getText().toString());
                        worldReadWriteEdit.putString(OneRoof.KEY_COST, codst1.getText().toString());
                        worldReadWriteSpecEdit.putString(OneRoof.KEY_SPECIFICATION, totalSpecification);
                        worldReadWriteFullSpecEdit.putString(OneRoof.KEY_FULL_SPECIFICATION, TotalSpecification);
                        worlldView.putString(OneRoof.KEY_PREFS_VIEW, roofview.getText().toString());
                        //Commit the sharedPreferences into a file
                        privateEdit.commit();
                        worldReadEdit.commit();
                        worldWriteEdit.commit();
                        worldReadWriteEdit.commit();
                        worldReadWriteSpecEdit.commit();
                        worldReadWriteFullSpecEdit.commit();
                        worlldView.commit();
                    } catch (Exception e) {
                    }
                    // Intent oneroof = new Intent(OneRoof.this, Roof2.class);
                    startActivity(new Intent(OneRoof.this, Roof2.class));

                }
            }
        });

}



}

