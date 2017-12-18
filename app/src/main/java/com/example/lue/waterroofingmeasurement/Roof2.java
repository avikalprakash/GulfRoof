package com.example.lue.waterroofingmeasurement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by lue on 13-09-2017.
 */

public class Roof2 extends AppCompatActivity {

   // public static final String PREFS_VIEW = "PREFS_VIEW";
    public static final String PREFS_ROOFTYPE = "PREFS_ROOFTYPE";
    public static final String PREFS_AREA = "PREFS_AREA";
    public static final String PREFS_NUMBER = "PREF_NUMBER";
    public static final String PREFS_COST = "PREFS_COST";
    public static final String PREFS_SPECIFICATION= "PREFS_SPECIFICATION";
    public static final String PREFS_FULL_SPECIFICATION= "PREFS_FULL_SPECIFICATION";
 //   public static final String KEY_PREFS_VIEW = "KEY_ROOVIEW";
    public static final String KEY_ROOFTYPE2 = "KEY_ROOFTYPE2";
    public static final String KEY_AREA2 = "KEY_AREA2";
    public static final String KEY_NUMBER2 = "KEY_NUMBER2";
    public static final String KEY_COST2= "KEY_COST2";
    public static final String KEY_SPECIFICATION2 = "KEY_SPECIFICATION2";
    public static final String KEY_FULL_SPECIFICATION2 = "KEY_FULL_SPECIFICATION2";
 ///   private SharedPreferences prefRoofView;
    private SharedPreferences prefsRooftype;
    private SharedPreferences prefsArea;
    private SharedPreferences prefsNumber;
    private SharedPreferences prefscost;
    private SharedPreferences prefsSpecification;
    private SharedPreferences prefsFullSpecification;
CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11,chk22,chk23;
    Button moreroof2,btnroof2;
    Double c1=2.500;
    Double c2=3.300;
    Double c3=3.300;
    Double c4=2.000;
    Double c5=3.000;
    Double c6=0.300;
    Double c7=5.000;
    Double c8=4.300;
    Double c9=4.300;
    Double c10=2.500;
    Double c11=2.500;
    Double totalC=0.0;
    String totalSpecification;
    String speci1="TA 1";
    String speci2="LW 75";
    String speci3="PU 35";
    String speci4="PU COAT";
    String speci5="Poly 50";
    String speci6="GTX";
    String speci7="TA 2";
    String speci8="Lw 100";
    String speci9="PU 75";
    String speci10="LqM";
    String speci11="Lqrm";

    String TotalSpecification;
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
        setContentView(R.layout.tworoof);

        moreroof2 = (Button) findViewById(R.id.btn_more2);
        btnroof2 = (Button) findViewById(R.id.btnroof);
        final TextView roofview = (TextView) findViewById(R.id.textView5);
        final EditText rooftype = (EditText) findViewById(R.id.editText3);
        final EditText area = (EditText) findViewById(R.id.area);
        final EditText numer = (EditText) findViewById(R.id.editText7);
        final EditText codst2 = (EditText) findViewById(R.id.editText8);

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

        if (!ch1.equals("")){
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
        }
        chk1 = (CheckBox) findViewById(R.id.checkBox12);
        chk2 = (CheckBox) findViewById(R.id.checkBox14);
        chk3 = (CheckBox) findViewById(R.id.checkBox15);
        chk4 = (CheckBox) findViewById(R.id.checkBox16);
        chk5 = (CheckBox) findViewById(R.id.checkBox17);
        chk6 = (CheckBox) findViewById(R.id.checkBox13);
        chk7 = (CheckBox) findViewById(R.id.checkBox18);
        chk8 = (CheckBox) findViewById(R.id.checkBox19);
        chk9= (CheckBox) findViewById(R.id.checkBox20);
        chk10= (CheckBox) findViewById(R.id.checkBox22);
        chk11= (CheckBox) findViewById(R.id.checkBox23);

        //chk10=(CheckBox) findViewById(R.id.checkBox15);

        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m=0;
                m++;

                if (chk1.isChecked()&& m>0) {
                    totalC = c1;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = speci1;
                    TotalSpecification = speciA + "(" + String.valueOf(c1) + "/Sq.m BD)";


                } if(!chk1.isChecked()) {
                    m--;
                    totalC = totalC - c1;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk2.isChecked()&& m>0) {

                    totalC = totalC + c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci2;
                    TotalSpecification = TotalSpecification + ", " + speciB + "(" + String.valueOf(c2) + "/Sq.m BD)";
                    String s = "v";

                }
                if (chk3.isChecked()&& m>0) {
                    totalC = totalC + c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci3;
                    TotalSpecification = TotalSpecification + ", " + speciC + "(" + String.valueOf(c3) + "/Sq.m BD)";

                }
                if (chk4.isChecked()&& m>0) {
                    totalC = totalC + c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci4;
                    TotalSpecification = TotalSpecification + ", " + speciD + "(" + String.valueOf(c4) + "/Sq.m BD)";
                }
                if (chk5.isChecked()&& m>0) {
                    totalC = totalC + c5;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci5;
                    TotalSpecification = TotalSpecification + ", " + speciE + "(" + String.valueOf(c5) + "/Sq.m BD)";
                }
                if (chk6.isChecked()&& m>0) {
                    totalC = totalC + c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci6;
                    TotalSpecification = TotalSpecification + ", " + speciF + "(" + String.valueOf(c6) + "/Sq.m BD)";
                }
                if (chk7.isChecked()&& m>0) {
                    totalC = totalC + c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci7;
                    TotalSpecification = TotalSpecification + ", " + speciG + "(" + String.valueOf(c7) + "/Sq.m BD)";
                }
                if (chk8.isChecked()&& m>0) {
                    totalC = totalC + c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci8;
                    TotalSpecification = TotalSpecification + ", " + speciH + "(" + String.valueOf(c8) + "/Sq.m BD)";
                }
                if (chk9.isChecked()&& m>0) {
                    totalC = totalC + c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci9;
                    TotalSpecification = TotalSpecification + ", " + speciI + "(" + String.valueOf(c9) + "/Sq.m BD)";
                }
                if (chk10.isChecked()&& m>0) {
                    totalC = totalC + c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci10;
                    TotalSpecification = TotalSpecification + ", " + speciJ + "(" + String.valueOf(c10) + "/Sq.m BD)";
                }
                if (chk11.isChecked()&& m>0) {
                    totalC = totalC + c11;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci11;
                    TotalSpecification = TotalSpecification + ", " + speciK + "(" + String.valueOf(c11) + "/Sq.m BD)";
                }

              /*  chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }

        });

        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                i++;
                if (chk2.isChecked()&& i>0) {
                    totalC=c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci2;
                    TotalSpecification=speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }

                if(!chk2.isChecked()) {
                    i--;
                    totalC=totalC-c2;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked()&& i>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                    String s="v";


                }
                if ( chk3.isChecked()&& i>0) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk4.isChecked()&& i>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked()&& i>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked()&& i>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked()&& i>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked()&& i>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked()&& i>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && i>0) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && i>0) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
                /*chk1.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int j=0;
                j++;
                if (chk3.isChecked() && j>0) {
                    totalC=c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci3;
                    TotalSpecification=speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }if (!chk3.isChecked()){
                    j--;
                    totalC=totalC-c3;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && j>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && j>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && j>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+" /Sq.m BD)";
                }
                if (chk5.isChecked() && j>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && j>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && j>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD )";
                }
                if (chk8.isChecked() && j>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && j>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && j>0 ) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && j>0) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
            }


       /* chk1.setChecked(false);
        chk2.setChecked(false);
        chk4.setChecked(false);
        chk5.setChecked(false);
        chk6.setChecked(false);
        chk7.setChecked(false);
        chk8.setChecked(false);
        chk9.setChecked(false);
        chk10.setChecked(false);
        chk11.setChecked(false);*/


        });

        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int k=0;
                k++;
                if (chk4.isChecked() && k>0) {
                    totalC=c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci4;
                    TotalSpecification=speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }if (! chk4.isChecked()){
                    k--;
                    totalC=totalC-c4;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && k>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
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
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && k>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && k>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && k>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && k>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && k>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && k>0) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && k>0) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
                /*chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });

        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l=0;
                l++;
                if (chk5.isChecked()&& l>0) {
                    totalC=c5;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci5;
                    TotalSpecification=speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }if (! chk5.isChecked()){
                    l--;
                    totalC=totalC-c5;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked()&& l>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked()&& l>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked()&& l>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk3.isChecked()&& l>0) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk6.isChecked()&& l>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked()&& l>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked()&& l>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked()&& l>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && l>0) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && l>0) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
                /*chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });
        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n=0;
                n++;
                if (chk6.isChecked()&& n>0) {
                    totalC=c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci6;
                    TotalSpecification=speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }if (! chk6.isChecked()){
                    n--;
                    totalC=totalC-c6;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked()&& n>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked()&& n>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked()&& n>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked()&& n>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk3.isChecked()&& n>0) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk7.isChecked()&& n>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked()&& n>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked()&& n>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && n>0) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && n>0) {
                    totalC = c11 + totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification = totalSpecification + ", " + speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
              /*  chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });

        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int o=0;
                o++;
                if (chk7.isChecked() && o>0) {
                    totalC=c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci7;
                    TotalSpecification=speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }if (!chk7.isChecked()){
                    o--;
                    totalC=totalC-c7;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && o>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && o>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && o>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && o>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && o>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && o>0) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && o>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && o>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && o>0 ) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && o>0 ) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
            /*    chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });

        chk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p=0;
                p++;
                if (chk8.isChecked() && p>0) {
                    totalC=c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci8;
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }if (!chk8.isChecked()){
                    p--;
                    totalC=totalC-c8;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && p>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && p>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && p>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && p>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && p>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && p>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && p>0) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && p>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked()  && p>0) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && p>0) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
              /*  chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });

        chk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q=0;
                q++;
                if (chk9.isChecked() && q>0) {
                    totalC=c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci9;
                    TotalSpecification=speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }if (!chk9.isChecked()){
                    q--;
                    totalC=totalC-c9;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && q>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && q>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && q>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && q>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && q>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && q>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && q>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && q>0) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk10.isChecked()  && q>0) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk11.isChecked() && q>0 ) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
               /* chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);*/
            }
        });


        chk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int r=0;
                r++;
                if (chk10.isChecked() && r>0) {
                    totalC=c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci10;
                    TotalSpecification=speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }if (!chk10.isChecked()){
                    totalC=totalC-c10;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && r>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && r>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && r>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && r>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && r>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && r>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && r>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && r>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && r>0 ) {
                    totalC=totalC+c3;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
                if (chk11.isChecked()  && r>0) {
                    totalC=c11+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci11;
                    TotalSpecification=TotalSpecification+", "+speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }
               /* chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk11.setChecked(false);*/
            }
        });
        chk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s=0;
                s++;
                if (chk11.isChecked() && s>0) {
                    totalC=c11;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=speci11;
                    TotalSpecification=speciK+"("+String.valueOf(c11)+"/Sq.m BD)";
                }if (!chk11.isChecked()){
                    s--;
                    totalC=totalC-c11;
                    codst2.setText(String.valueOf(totalC));
                }
                if (chk1.isChecked() && s>0) {
                    totalC=c1+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci1;
                    TotalSpecification=TotalSpecification+", "+speciA+"("+String.valueOf(c1)+"/Sq.m BD)";
                }
                if ( chk2.isChecked() && s>0) {
                    totalC=totalC+c2;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci2;
                    TotalSpecification=TotalSpecification+", "+speciB+"("+String.valueOf(c2)+"/Sq.m BD)";
                }
                if (chk4.isChecked() && s>0) {
                    totalC=totalC+c4;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci4;
                    TotalSpecification=TotalSpecification+", "+speciD+"("+String.valueOf(c4)+"/Sq.m BD)";
                }
                if (chk5.isChecked() && s>0) {
                    totalC=totalC+c5;
                    codst2.setText(String.valueOf( totalC));
                    totalSpecification=totalSpecification+", "+speci5;
                    TotalSpecification=TotalSpecification+", "+speciE+"("+String.valueOf(c5)+"/Sq.m BD)";
                }
                if (chk6.isChecked() && s>0) {
                    totalC=totalC+c6;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci6;
                    TotalSpecification=TotalSpecification+", "+speciF+"("+String.valueOf(c6)+"/Sq.m BD)";
                }
                if (chk7.isChecked() && s>0) {
                    totalC=totalC+c7;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci7;
                    TotalSpecification=TotalSpecification+", "+speciG+"("+String.valueOf(c7)+"/Sq.m BD)";
                }
                if (chk8.isChecked() && s>0) {
                    totalC=totalC+c8;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci8;
                    TotalSpecification=TotalSpecification+", "+speciH+"("+String.valueOf(c8)+"/Sq.m BD)";
                }
                if (chk9.isChecked() && s>0) {
                    totalC=totalC+c9;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci9;
                    TotalSpecification=TotalSpecification+", "+speciI+"("+String.valueOf(c9)+"/Sq.m BD)";
                }
                if (chk10.isChecked() && s>0 ) {
                    totalC=totalC+c10;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci10;
                    TotalSpecification=TotalSpecification+", "+speciJ+"("+String.valueOf(c10)+"/Sq.m BD)";
                }
                if (chk3.isChecked() && s>0 ) {
                    totalC=c3+totalC;
                    codst2.setText(String.valueOf(totalC));
                    totalSpecification=totalSpecification+", "+speci3;
                    TotalSpecification=TotalSpecification+", "+speciC+"("+String.valueOf(c3)+"/Sq.m BD)";
                }
               /* chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);*/
            }
        });


        moreroof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sType = rooftype.getText().toString();
                String sArea = area.getText().toString();
                String sNum = numer.getText().toString();
                String sCost = codst2.getText().toString();
                if (sNum.equals("") || sCost.equals("") || sType.equals("") || sArea.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Roof2.this);
                    builder.setMessage("Please fill all the details")
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                } else {
                    try {
                        // prefRoofView = getSharedPreferences(OneRoof.KEY_PREFS_VIEW, Context.MODE_PRIVATE);
                        prefsRooftype = getSharedPreferences(Roof2.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
                        prefsArea = getSharedPreferences(Roof2.PREFS_AREA, Context.MODE_PRIVATE);
                        prefsNumber = getSharedPreferences(Roof2.PREFS_NUMBER, Context.MODE_PRIVATE);
                        prefsSpecification = getSharedPreferences(Roof2.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
                        prefsFullSpecification = getSharedPreferences(Roof2.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);
                        prefscost = getSharedPreferences(Roof2.PREFS_COST, Context.MODE_PRIVATE + Context.MODE_PRIVATE);
                        SharedPreferences.Editor privateEdit = prefsRooftype.edit();
                        SharedPreferences.Editor worldReadEdit = prefsArea.edit();
                        SharedPreferences.Editor worldWriteEdit = prefsNumber.edit();
                        SharedPreferences.Editor worldReadWriteEdit = prefscost.edit();
                        SharedPreferences.Editor worldReadWriteSpecEdit = prefsSpecification.edit();
                        SharedPreferences.Editor worldReadWriteFullSpecEdit = prefsFullSpecification.edit();
                        //       SharedPreferences.Editor worlldView = prefRoofView.edit();

                        privateEdit.putString(Roof2.KEY_ROOFTYPE2, rooftype.getText().toString());
                        worldReadEdit.putString(Roof2.KEY_AREA2, area.getText().toString());
                        worldWriteEdit.putString(Roof2.KEY_NUMBER2, numer.getText().toString());
                        worldReadWriteEdit.putString(Roof2.KEY_COST2, codst2.getText().toString());
                        worldReadWriteSpecEdit.putString(Roof2.KEY_SPECIFICATION2, totalSpecification);
                        worldReadWriteFullSpecEdit.putString(Roof2.KEY_FULL_SPECIFICATION2, TotalSpecification);
                        //worlldView.putString(OneRoof.KEY_PREFS_VIEW, roofview.getText().toString());
                        //Commit the sharedPreferences into a file
                        privateEdit.commit();
                        worldReadEdit.commit();
                        worldWriteEdit.commit();
                        worldReadWriteEdit.commit();
                        worldReadWriteSpecEdit.commit();
                        worldReadWriteFullSpecEdit.commit();
                    } catch (Exception e) {
                    }
                    //  worlldView.commit();
                    //Intent oneroof = new Intent(Roof2.this, Roof3.class);
                    startActivity(new Intent(Roof2.this, Roof3.class));

                }
            }
        });

        btnroof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sType= rooftype.getText().toString();
                String sArea= area.getText().toString();
                String sNum= numer.getText().toString();
                String sCost= codst2.getText().toString();
                if (sNum.equals("") || sCost.equals("") || sType.equals("") || sArea.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Roof2.this);
                    builder.setMessage("Please fill all the details")
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else {
                    prefsRooftype = getSharedPreferences(Roof2.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
                    prefsArea = getSharedPreferences(Roof2.PREFS_AREA, Context.MODE_PRIVATE);
                    prefsNumber = getSharedPreferences(Roof2.PREFS_NUMBER, Context.MODE_PRIVATE);
                    prefsSpecification = getSharedPreferences(Roof2.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
                    prefsFullSpecification = getSharedPreferences(Roof2.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);
                    prefscost = getSharedPreferences(Roof2.PREFS_COST, Context.MODE_PRIVATE + Context.MODE_PRIVATE);
                    SharedPreferences.Editor privateEdit = prefsRooftype.edit();
                    SharedPreferences.Editor worldReadEdit = prefsArea.edit();
                    SharedPreferences.Editor worldWriteEdit = prefsNumber.edit();
                    SharedPreferences.Editor worldReadWriteEdit = prefscost.edit();
                    SharedPreferences.Editor worldReadWriteSpecEdit = prefsSpecification.edit();
                    SharedPreferences.Editor worldReadWriteFullSpecEdit = prefsFullSpecification.edit();
                    //       SharedPreferences.Editor worlldView = prefRoofView.edit();

                    privateEdit.putString(Roof2.KEY_ROOFTYPE2, rooftype.getText().toString());
                    worldReadEdit.putString(Roof2.KEY_AREA2, area.getText().toString());
                    worldWriteEdit.putString(Roof2.KEY_NUMBER2, numer.getText().toString());
                    worldReadWriteEdit.putString(Roof2.KEY_COST2, codst2.getText().toString());
                    worldReadWriteSpecEdit.putString(Roof2.KEY_SPECIFICATION2, totalSpecification);
                    worldReadWriteFullSpecEdit.putString(Roof2.KEY_FULL_SPECIFICATION2, TotalSpecification);
                    //worlldView.putString(OneRoof.KEY_PREFS_VIEW, roofview.getText().toString());
                    //Commit the sharedPreferences into a file
                    privateEdit.commit();
                    worldReadEdit.commit();
                    worldWriteEdit.commit();
                    worldReadWriteEdit.commit();
                    worldReadWriteSpecEdit.commit();
                    worldReadWriteFullSpecEdit.commit();
                    //      worlldView.commit();

                    Intent done = new Intent(Roof2.this, OrderDetails.class);
                    startActivity(done);

                }


            }
        });
    }
}