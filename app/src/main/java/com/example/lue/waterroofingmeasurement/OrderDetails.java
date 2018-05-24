package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class OrderDetails extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences prefsRooftype;
    private SharedPreferences prefsArea;
    private SharedPreferences prefsNumber;
    private SharedPreferences prefscost;
    private SharedPreferences prefsSpecification;
    private SharedPreferences prefsFullSpecification;
    SharedPreferences.Editor editor;
    Double a1Int;
    Double c1Int;
    Double sp1Int;
    Double a2Int;
    Double c2Int;
    Double sp2Int;
    Double a3Int;
    Double c3Int;
    Double sp3Int;
    Double a4Int;
    Double c4Int;
    Double sp4Int;
    Double a5Int;
    Double c5Int;
    Double sp5Int;
    String spec_name1,spec_name2,spec_name3,spec_name4,spec_name5,spec_name6,spec_name7,spec_name8,spec_name9,spec_name10,spec_name11;
    int spec_cost1=0,spec_cost2=0,spec_cost3=0,spec_cost4=0,spec_cost5=0,spec_cost6=0,spec_cost7=0,spec_cost8=0,spec_cost9=0,spec_cost10=0,spec_cost11=0;
    EditText rooof1type,area1, number, cost1, totalCost1,rooof2type, area2, numbersec, cost2, totalCost2, rooof3type,
            area3, numberthree,cost3, totalCost3,rooof4type,area4,numberfour, cost4, totalCost4,rooof5type, area5,
            numberfive,cost5, totalCost5, validity, specification1, specification2, specification3, specification4, specification5;
    Double total1=0.0;
    Double total2=0.0;
    Double total3=0.0;
    Double total4=0.0;
    Double total5=0.0;
    Double finalTotal=0.0;
    Double i;
    String spe1, spe2, spe3, spe4, spe5;
    String fSpe1, fSpe2,fSpe3, fSpe4,fSpe5;
    Button buttonSend, buttonback;
    EditText totalfinalCost;
    public static final String EMAIL = "email";
    public static final String SELLER_EMAIL_ID = "seller_email_id";
    public static final String SELLER_NAME = "seller_name";
    public static final String SELLER_CONTACT = "seller_contact";
    public static final String USERNAME = "user_name";
    public static final String MOBILE = "mobile";
    public static final String ADDRESS = "address";
    public static final String LATITUDE = "lat";
    public static final String LONGITUDE = "long";
    public static final String MyPref = "MyPref";
    SharedPreferences sharedpreferences;
    String email, seller_email_id, user_name, mobile, address, lat, lang, seller_name, seller_contact;
    TextView termsCondition;
    String ORDER_DETAILS="http://gulfroof.com/api/mail_to_customer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotationpfd);
        buttonSend=(Button)findViewById(R.id.buttonSendCustomer);
        buttonback=(Button)findViewById(R.id.buttonback);
        totalfinalCost=(EditText)findViewById(R.id.totalfinalCost);
        termsCondition=(TextView)findViewById(R.id.termsCondition);
        termsCondition.setOnClickListener(this);
        sharedpreferences=getSharedPreferences(MyPref,Context.MODE_PRIVATE);
        email=sharedpreferences.getString(EMAIL,"");
        seller_email_id=sharedpreferences.getString(SELLER_EMAIL_ID,"");
        user_name=sharedpreferences.getString(USERNAME,"");
        mobile=sharedpreferences.getString(MOBILE,"");
        address=sharedpreferences.getString(ADDRESS,"");
        lat=sharedpreferences.getString(LATITUDE,"");
        lang=sharedpreferences.getString(LONGITUDE,"");
        seller_email_id=sharedpreferences.getString(SELLER_EMAIL_ID,"");
        seller_name=sharedpreferences.getString(SELLER_NAME,"");
        seller_contact=sharedpreferences.getString(SELLER_CONTACT,"");
        buttonback.setOnClickListener(this);
        buttonSend.setOnClickListener(this);
        prefsRooftype=getSharedPreferences(OneRoof.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
        prefsArea=getSharedPreferences(OneRoof.PREFS_AREA, Context.MODE_PRIVATE);
        prefsNumber=getSharedPreferences(OneRoof.PREFS_NUMBER, Context.MODE_PRIVATE);
        prefscost=getSharedPreferences(OneRoof.PREFS_COST, Context.MODE_PRIVATE);
        prefsSpecification=getSharedPreferences(OneRoof.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
        prefsFullSpecification=getSharedPreferences(OneRoof.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);
        editor = prefsRooftype.edit();
        editor = prefsArea.edit();
        editor = prefsNumber.edit();
        editor = prefscost.edit();
        editor = prefsSpecification.edit();

        rooof1type=(EditText)findViewById(R.id.rooftypeinput1);
        area1=(EditText)findViewById(R.id.areainput1);
        number=(EditText)findViewById(R.id.numberinput1);
        cost1=(EditText)findViewById(R.id.specificationcost);
        specification1=(EditText)findViewById(R.id.specificationinput1);
        totalCost1=(EditText)findViewById(R.id.totalCost1);

        rooof2type=(EditText)findViewById(R.id.rooftypeinput2);
        area2=(EditText)findViewById(R.id.areainput2);
        numbersec=(EditText)findViewById(R.id.numberinput2);
        cost2=(EditText)findViewById(R.id.specificationcost2);
        specification2=(EditText)findViewById(R.id.specificationinput2);
        totalCost2=(EditText)findViewById(R.id.totalCost2);

        rooof3type=(EditText)findViewById(R.id.rooftypeinput3);
         area3=(EditText)findViewById(R.id.areainput3);
        numberthree=(EditText)findViewById(R.id.numberinput3);
         cost3=(EditText)findViewById(R.id.specificationcost3);
        specification3=(EditText)findViewById(R.id.specificationinput3);
         totalCost3=(EditText)findViewById(R.id.totalCost3);

         rooof4type=(EditText)findViewById(R.id.rooftypeinput4);
        area4=(EditText)findViewById(R.id.areainput4);
         numberfour=(EditText)findViewById(R.id.numberinput4);
        cost4=(EditText)findViewById(R.id.specificationcost4);
        specification4=(EditText)findViewById(R.id.specificationinput4);
        totalCost4=(EditText)findViewById(R.id.totalCost4);

         rooof5type=(EditText)findViewById(R.id.rooftypeinput5);
        area5=(EditText)findViewById(R.id.areainput5);
        numberfive=(EditText)findViewById(R.id.numberinput5);
        cost5=(EditText)findViewById(R.id.specificationcost5);
        totalCost5=(EditText)findViewById(R.id.totalCost5);
        specification5=(EditText)findViewById(R.id.specificationinput5);
        validity=(EditText)findViewById(R.id.validity);
        rooof1type.setText(prefsRooftype.getString(OneRoof.KEY_ROOFTYPE, "NA"));
        area1.setText(prefsArea.getString(OneRoof.KEY_AREA, "NA"));
        try{
            a1Int= Double.parseDouble(prefsArea.getString(OneRoof.KEY_AREA, "NA"));
        }catch (Exception e){}
        try{
            c1Int = Double.parseDouble(prefscost.getString(OneRoof.KEY_COST, "NA"));
        }catch (Exception e){}
        try{
            sp1Int=a1Int*c1Int;
        }catch (Exception e){}
        try{
            String sp1FInt = String.format("%.03f", sp1Int);
            cost1.setText(String.valueOf(sp1FInt));
        }catch (Exception e){}


        number.setText(prefsNumber.getString(OneRoof.KEY_NUMBER, "NA"));
       // cost1.setText(prefscost.getString(OneRoof.KEY_COST, "NA"));

        specification1.setText(prefsSpecification.getString(OneRoof.KEY_SPECIFICATION, "NA"));
        spe1=specification1.getText().toString().trim();
        fSpe1=prefsFullSpecification.getString(OneRoof.KEY_FULL_SPECIFICATION, "NA");
        String s = fSpe1;

        String[] arr = s.split(", ");
        try {
            if (!arr[0].isEmpty()){
                spec_name1= arr[0];
            }
        }catch (Exception e){
            spec_name1= "";
        }
        try {
            if (!arr[1].isEmpty()){
                spec_name2= arr[1];
            }
        }catch (Exception e){
            spec_name2= "";
        }
        try {
            if (!arr[2].isEmpty()){
                spec_name3= arr[2];
            }
        }catch (Exception e){
            spec_name3= "";
        }
        try {
            if (!arr[3].isEmpty()){
                spec_name4= arr[3];
            }
        }catch (Exception e){
            spec_name4= "";
        }
        try {
            if (!arr[4].isEmpty()){
                spec_name5= arr[4];
            }
        }catch (Exception e){
            spec_name5= "";
        }
        try {
            if (!arr[5].isEmpty()){
                spec_name6= arr[5];
            }
        }catch (Exception e){
            spec_name6= "";
        }
        try {
            if (!arr[6].isEmpty()){
                spec_name7= arr[6];
            }
        }catch (Exception e){
            spec_name7= "";
        }
        try {
            if (!arr[7].isEmpty()){
                spec_name8= arr[7];
            }
        }catch (Exception e){
            spec_name8= "";
        }
        try {
            if (!arr[8].isEmpty()){
                spec_name9= arr[8];
            }
        }catch (Exception e){
            spec_name9= "";
        }
        try {
            if (!arr[9].isEmpty()){
                spec_name10= arr[9];
            }
        }catch (Exception e){
            spec_name10= "";
        }
        try {
            if (!arr[10].isEmpty()){
                spec_name11= arr[10];
            }
        }catch (Exception e){
            spec_name11= "";
        }

      /*  if (spec_name1.equals("Torch Applied membrane single layer")){
            spec_cost1=500;
        }
        if (spec_name2.equals("Light weight foam screed 75mm")){
            spec_cost2=700;
        }
        if (spec_name3.equals("Polyurethane foam 35mm")){
            spec_cost3=300;
        }
        if (spec_name4.equals("polyurethane foam coating")){
            spec_cost4=500;
        }
        if (spec_name5.equals("Polystrene board 50mm")){
            spec_cost5=300;
        }
        if (spec_name6.equals("Geotextile 100gsm")){
            spec_cost6=500;
        }
        if (spec_name7.equals("Torch Applied membrane double layer")){
            spec_cost7=300;
        }
        if (spec_name8.equals("Light weight foam screed 100mm")){
            spec_cost8=700;
        }
        if (spec_name9.equals("Polyurethane foam 50mm")){
            spec_cost9=400;
        }
        if (spec_name10.equals("Liquid membrane")){
            spec_cost10=400;
        }
        if (spec_name11.equals("Liquid reinforced membrane")){
            spec_cost11=300;
        }*/

       // Toast.makeText(getApplicationContext(), String.valueOf(spec_cost1)+", "+String.valueOf(spec_cost2), Toast.LENGTH_LONG).show();

        String at1=prefsNumber.getString(OneRoof.KEY_NUMBER, "NA");
        String bt1=prefscost.getString(OneRoof.KEY_COST, "NA");
        if (at1.equals("NA") || at1.equals("")){
            totalCost1.setText("NA");
            rooof1type.setText("NA");
            area1.setText("NA");
            number.setText("NA");
            cost1.setText("NA");
        }else {
            total1=Double.parseDouble(at1)*sp1Int;
            String fTotal1 = String.format("%.03f", total1);
            totalCost1.setText(String.valueOf(fTotal1));
        }



        prefsRooftype=getSharedPreferences(Roof2.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
        prefsArea=getSharedPreferences(Roof2.PREFS_AREA, Context.MODE_PRIVATE);
        prefsNumber=getSharedPreferences(Roof2.PREFS_NUMBER, Context.MODE_PRIVATE);
        prefscost=getSharedPreferences(Roof2.PREFS_COST, Context.MODE_PRIVATE);
        prefsSpecification=getSharedPreferences(Roof2.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
        prefsFullSpecification=getSharedPreferences(Roof2.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);


            rooof2type.setText(prefsRooftype.getString(Roof2.KEY_ROOFTYPE2, "NA"));
            area2.setText(prefsArea.getString(Roof2.KEY_AREA2, "NA"));
            numbersec.setText(prefsNumber.getString(Roof2.KEY_NUMBER2, "NA"));
           // cost2.setText(prefscost.getString(Roof2.KEY_COST2, "NA"));
            specification2.setText(prefsSpecification.getString(Roof2.KEY_SPECIFICATION2, "NA"));
            spe2=specification2.getText().toString().trim();
            fSpe2=prefsFullSpecification.getString(Roof2.KEY_FULL_SPECIFICATION2, "NA");
        try{
            a2Int= Double.parseDouble(prefsArea.getString(Roof2.KEY_AREA2, "NA"));
        }catch (Exception e){}
        try{
            c2Int = Double.parseDouble(prefscost.getString(Roof2.KEY_COST2, "NA"));
        }catch (Exception e){}
        try{
            sp2Int=a2Int*c2Int;
        }catch (Exception e){}
        try{
            String fSp2Int = String.format("%.03f", sp2Int);
            cost2.setText(String.valueOf(fSp2Int));
        }catch (Exception e){}

        if (fSpe2.equals("NA")){
            fSpe2="";
        }
            String at2=prefsNumber.getString(Roof2.KEY_NUMBER2, "NA");
            String bt2=prefscost.getString(Roof2.KEY_COST2, "NA");
        if (at2.equals("NA") || at2.equals("") || bt2.equals("NA") || bt2.equals("")){
            totalCost2.setText("NA");
            rooof2type.setText("NA");
            area2.setText("NA");
            numbersec.setText("NA");
            cost2.setText("NA");
        }else {
            total2=Double.parseDouble(at2)*sp2Int;
            String fTotal2 = String.format("%.03f", total2);
            totalCost2.setText(String.valueOf(fTotal2));
        }


        prefsRooftype=getSharedPreferences(Roof3.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
        prefsArea=getSharedPreferences(Roof3.PREFS_AREA, Context.MODE_PRIVATE);
        prefsNumber=getSharedPreferences(Roof3.PREFS_NUMBER, Context.MODE_PRIVATE);
        prefscost=getSharedPreferences(Roof3.PREFS_COST, Context.MODE_PRIVATE);
        prefscost=getSharedPreferences(Roof3.PREFS_COST, Context.MODE_PRIVATE);
        prefsSpecification=getSharedPreferences(Roof3.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
        prefsFullSpecification=getSharedPreferences(Roof3.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);


        rooof3type.setText(prefsRooftype.getString(Roof3.KEY_ROOFTYPE3, "NA"));
        area3.setText(prefsArea.getString(Roof3.KEY_AREA3, "NA"));
        numberthree.setText(prefsNumber.getString(Roof3.KEY_NUMBER3, "NA"));
       // cost3.setText(prefscost.getString(Roof3.KEY_COST3, "NA"));
        specification3.setText(prefsSpecification.getString(Roof3.KEY_SPECIFICATION3, "NA"));
        spe3=specification3.getText().toString().trim();
        fSpe3=prefsFullSpecification.getString(Roof3.KEY_FULL_SPECIFICATION3, "NA");

        try{
            a3Int= Double.parseDouble(prefsArea.getString(Roof3.KEY_AREA3, "NA"));
        }catch (Exception e){}
        try{
            c3Int = Double.parseDouble(prefscost.getString(Roof3.KEY_COST3, "NA"));
        }catch (Exception e){}
        try{
            sp3Int=a3Int*c3Int;
        }catch (Exception e){}
        try{
            String fsp3Int = String.format("%.03f", sp3Int);
            cost3.setText(String.valueOf(fsp3Int));
        }catch (Exception e){}

        if (fSpe3.equals("NA")){
            fSpe3="";
        }
        String at3=prefsNumber.getString(Roof3.KEY_NUMBER3, "NA");
        String bt3=prefscost.getString(Roof3.KEY_COST3, "NA");
        if (at3.equals("NA") || at3.equals("")){
            totalCost3.setText("NA");
            rooof3type.setText("NA");
            area3.setText("NA");
            numberthree.setText("NA");
            cost3.setText("NA");
        }else {
            total3=Double.parseDouble(at3)*sp3Int;
            String fTotal2 = String.format("%.03f", total3);
            totalCost3.setText(String.valueOf(fTotal2));
        }



        prefsRooftype=getSharedPreferences(Roof4.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
        prefsArea=getSharedPreferences(Roof4.PREFS_AREA, Context.MODE_PRIVATE);
        prefsNumber=getSharedPreferences(Roof4.PREFS_NUMBER, Context.MODE_PRIVATE);
        prefscost=getSharedPreferences(Roof4.PREFS_COST, Context.MODE_PRIVATE);
        prefsSpecification=getSharedPreferences(Roof4.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
        prefsFullSpecification=getSharedPreferences(Roof4.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);


        rooof4type.setText(prefsRooftype.getString(Roof4.KEY_ROOFTYPE4, "NA"));
        area4.setText(prefsArea.getString(Roof4.KEY_AREA4, "NA"));
        numberfour.setText(prefsNumber.getString(Roof4.KEY_NUMBER4, "NA"));
       // cost4.setText(prefscost.getString(Roof4.KEY_COST4, "NA"));
        specification4.setText(prefsSpecification.getString(Roof4.KEY_SPECIFICATION4, "NA"));
        spe4=specification4.getText().toString().trim();
        fSpe4=prefsFullSpecification.getString(Roof4.KEY_FULL_SPECIFICATION4, "NA");

        try{
            a4Int= Double.parseDouble(prefsArea.getString(Roof4.KEY_AREA4, "NA"));
        }catch (Exception e){}
        try{
            c4Int = Double.parseDouble(prefscost.getString(Roof4.KEY_COST4, "NA"));
        }catch (Exception e){}
        try{
            sp4Int=a4Int*c4Int;
        }catch (Exception e){}
        try{
            String fsp4Int = String.format("%.03f", sp4Int);
            cost4.setText(String.valueOf(fsp4Int));
        }catch (Exception e){}

        if (fSpe4.equals("NA")){
            fSpe4="";
        }
        String at4=prefsNumber.getString(Roof4.KEY_NUMBER4, "NA");
        String bt4=prefscost.getString(Roof4.KEY_COST4, "NA");
        if (at4.equals("NA")  || at4.equals("")){
            totalCost4.setText("NA");
            rooof4type.setText("NA");
            area4.setText("NA");
            numberfour.setText("NA");
            cost4.setText("NA");
        }else {
            total4=Double.parseDouble(at4)*sp4Int;
            String fTotal4 = String.format("%.03f", total4);
            totalCost4.setText(String.valueOf(fTotal4));
        }

        prefsRooftype=getSharedPreferences(Roof5.PREFS_ROOFTYPE, Context.MODE_PRIVATE);
        prefsArea=getSharedPreferences(Roof5.PREFS_AREA, Context.MODE_PRIVATE);
        prefsNumber=getSharedPreferences(Roof5.PREFS_NUMBER, Context.MODE_PRIVATE);
        prefscost=getSharedPreferences(Roof5.PREFS_COST, Context.MODE_PRIVATE);
        prefsSpecification=getSharedPreferences(Roof5.PREFS_SPECIFICATION, Context.MODE_PRIVATE);
        prefsFullSpecification=getSharedPreferences(Roof5.PREFS_FULL_SPECIFICATION, Context.MODE_PRIVATE);


        rooof5type.setText(prefsRooftype.getString(Roof5.KEY_ROOFTYPE5, "NA"));
        area5.setText(prefsArea.getString(Roof5.KEY_AREA5, "NA"));
        numberfive.setText(prefsNumber.getString(Roof5.KEY_NUMBER5, "NA"));
       // cost5.setText(prefscost.getString(Roof5.KEY_COST5, "NA"));
        specification5.setText(prefsSpecification.getString(Roof5.KEY_SPECIFICATION5, "NA"));
        spe5=specification5.getText().toString().trim();
        fSpe5=prefsFullSpecification.getString(Roof5.KEY_FULL_SPECIFICATION5, "NA");

        try{
            a5Int= Double.parseDouble(prefsArea.getString(Roof5.KEY_AREA5, "NA"));
        }catch (Exception e){}
        try{
            c5Int = Double.parseDouble(prefscost.getString(Roof5.KEY_COST5, "NA"));
        }catch (Exception e){}
        try{
            sp5Int=a5Int*c5Int;
        }catch (Exception e){}
        try{
            String fsp5Int = String.format("%.03f", sp5Int);
            cost5.setText(String.valueOf(fsp5Int));
        }catch (Exception e){}

        if (fSpe5.equals("NA")){
            fSpe5="";
        }
        String at5=prefsNumber.getString(Roof5.KEY_NUMBER5, "NA");
        String bt5=prefscost.getString(Roof5.KEY_COST5, "NA");
        if (at5.equals("NA") || at5.equals("")){
            totalCost5.setText("NA");
            rooof5type.setText("NA");
            area5.setText("NA");
            numberfive.setText("NA");
            cost5.setText("NA");
        }else {
            total5=Double.parseDouble(at5)*sp5Int;
            String fTotal5 = String.format("%.03f", total5);
            totalCost5.setText(String.valueOf(fTotal5));
        }

        finalTotal=total1+total2+total3+total4+total5;
        String FINALCOST = String.format("%.03f", finalTotal);
        totalfinalCost.setText(String.valueOf(FINALCOST));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSendCustomer:
                //Toast.makeText(getApplicationContext(), "Details is send to customer", Toast.LENGTH_LONG).show();
                if(validity.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(OrderDetails.this);
                    builder.setMessage("Please set validity")
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else if (!validity.getText().toString().equals("")){
                    new OrderSend().execute();
                }
                break;
            case R.id.buttonback:
              /*  startActivity(new Intent(getApplicationContext(), Home.class));
                finish();*/
               finish();
                editor.clear().commit();
                break;
            case R.id.termsCondition:
                openWebPage("http://gulfroof.com/api/terms&con.html");
                break;
        }
    }

    class OrderSend extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;

        String r1 = rooof1type.getText().toString().trim();
        String a1 = area1.getText().toString().trim()+" Sq.m";
        String  num1= number.getText().toString().trim();
        String c1 = cost1.getText().toString().trim()+" BD";
       // String spe1 = specification1.getText().toString().trim();
        String tc1=totalCost1.getText().toString().trim()+" BD";
        String r2=rooof2type.getText().toString().trim();
        String a2 = area2.getText().toString().trim()+" Sq.m";
        String  num2= numbersec.getText().toString().trim();
        String c2 = cost2.getText().toString().trim()+" BD";
       // String spe2 = specification2.getText().toString().trim();
        String tc2=totalCost2.getText().toString().trim()+" BD";
        String r3=rooof3type.getText().toString().trim();
        String a3 = area3.getText().toString().trim()+" Sq.m";
        String  num3= numberthree.getText().toString().trim();
        String c3 = cost3.getText().toString().trim()+" BD";
      //  String spe3 = specification3.getText().toString().trim();
        String tc3=totalCost3.getText().toString().trim()+" BD";
        String r4=rooof4type.getText().toString().trim();
        String a4 = area4.getText().toString().trim()+" Sq.m";
        String  num4= numberfour.getText().toString().trim();
        String c4 = cost4.getText().toString().trim()+" BD";
      //  String spe4 = specification4.getText().toString().trim();
        String tc4=totalCost4.getText().toString().trim()+" BD";
        String r5=rooof5type.getText().toString().trim();
        String a5 = area5.getText().toString().trim()+" Sq.m";
        String  num5= numberfive.getText().toString().trim();
        String c5 = cost5.getText().toString().trim()+" BD";
      //  String spe5 = specification5.getText().toString().trim();
        String tc5=totalCost5.getText().toString().trim()+" BD";
        String tfc=totalfinalCost.getText().toString().trim()+" BD";
        String val=validity.getText().toString().trim()+" Days";




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(OrderDetails.this);
            pDialog.setMessage("Please Wait ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... args) {
            String s = "";
            if (r2.equals("NA")){
                r2="";
            }
            if (a2.equals("NA")){
                a2="";
            }
            if (num2.equals("NA")){
                num2="";
            }
            if (tc2.equals("NA")){
                tc2="";
            }
            if (r3.equals("NA")){
                r3="";
            }
            if (a3.equals("NA")){
                a3="";
            }
            if (num3.equals("NA")){
                num3="";
            }
            if (c3.equals("NA")){
                c3="";
            }
            if (tc3.equals("NA")){
                tc3="";
            }
            if (r4.equals("NA")){
                r4="";
            }
            if (a4.equals("NA")){
                a4="";
            }
            if (num4.equals("NA")){
                num4="";
            }
            if (c4.equals("NA")){
                c4="";
            }
            if (tc4.equals("NA")){
                tc4="";
            }
            if (r5.equals("NA")){
                r5="";
            }
            if (a5.equals("NA")){
                a5="";
            }
            if (num5.equals("NA")){
                num5="";
            }
            if (c5.equals("NA")){
                c5="";
            }
            if (tc5.equals("NA")){
                tc5="";
            }

            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(ORDER_DETAILS);
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("rooftype1", r1);
                jsonObject.accumulate("area1", a1);
                jsonObject.accumulate("number1", num1);
                jsonObject.accumulate("specf1", fSpe1);
                jsonObject.accumulate("specf1_cost1", c1);
                jsonObject.accumulate("total_cost1", tc1);
                jsonObject.accumulate("rooftype2", r2);
                jsonObject.accumulate("area2", a2);
                jsonObject.accumulate("number2", num2);
                jsonObject.accumulate("specf2", fSpe2);
                jsonObject.accumulate("specf1_cost2", c2);
                jsonObject.accumulate("total_cost2", tc2);
                jsonObject.accumulate("rooftype3", r3);
                jsonObject.accumulate("area3", a3);
                jsonObject.accumulate("number3", num3);
                jsonObject.accumulate("specf3", fSpe3);
                jsonObject.accumulate("specf1_cost3", c3);
                jsonObject.accumulate("total_cost3", tc3);
                jsonObject.accumulate("rooftype4", r4);
                jsonObject.accumulate("area4", a4);
                jsonObject.accumulate("number4", num4);
                jsonObject.accumulate("specf4", fSpe4);
                jsonObject.accumulate("specf1_cost4", c4);
                jsonObject.accumulate("total_cost4", tc4);
                jsonObject.accumulate("rooftype5", r5);
                jsonObject.accumulate("area5", a5);
                jsonObject.accumulate("number5", num5);
                jsonObject.accumulate("specf5", fSpe5);
                jsonObject.accumulate("specf1_cost5", c5);
                jsonObject.accumulate("total_cost5", tc5);
                jsonObject.accumulate("final_cost", tfc);
                jsonObject.accumulate("lat", lat);
                jsonObject.accumulate("long", lang);
                jsonObject.accumulate("email", email+", "+seller_email_id);
                jsonObject.accumulate("user_name", user_name);
                jsonObject.accumulate("mobile", mobile);
                jsonObject.accumulate("validity", val);
                jsonObject.accumulate("seller_name", seller_name);
                jsonObject.accumulate("seller_contact", seller_contact);


                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPost.setEntity(stringEntity);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                s = readadsResponse(httpResponse);
                Log.d("tag1", " " + s);
            } catch (Exception exception) {
                exception.printStackTrace();

                Log.d("espone",exception.toString());

            }

            return s;

        }
        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
            pDialog.dismiss();
            try {
                JSONObject objone = new JSONObject(json);
                boolean check  = objone.getBoolean("error");
                if(check) {
                    String message = objone.getString("msg");
                    AlertDialog.Builder builder = new AlertDialog.Builder(OrderDetails.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{
                    String message = objone.getString("msg");
                   /* JSONArray jsonArray = objone.getJSONArray("msg");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                    }*/
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Order created Successfully", Toast.LENGTH_SHORT).show();
                    prefsRooftype.edit().clear().commit();
                    prefsArea.edit().clear().commit();
                    prefscost.edit().clear().commit();
                    prefsNumber.edit().clear().commit();
                    prefsSpecification.edit().clear().commit();
                    finish();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String readadsResponse(HttpResponse httpResponse) {

        InputStream is = null;
        String return_text = "";
        try {
            is = httpResponse.getEntity().getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return_text = sb.toString();
            Log.d("return1230", "" + return_text);
        } catch (Exception e) {

        }
        return return_text;
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        prefsRooftype.edit().clear().commit();
        prefsArea.edit().clear().commit();
        prefscost.edit().clear().commit();
        prefsNumber.edit().clear().commit();
        prefsSpecification.edit().clear().commit();
    }
}

