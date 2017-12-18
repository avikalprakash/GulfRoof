package com.example.lue.waterroofingmeasurement;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.test.mock.MockPackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import Adapter.LocationAddress;
import Adapter.ReadResponseClass;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

/**
 * Created by lue on 11-09-2017.
 */

public class CustomerRegistration extends AppCompatActivity implements View.OnClickListener {
    EditText editcustname, editmobile, editmail, editfax, editlandline;
    //private ProgressBar pDialog;
    String customername, mail, Mobile, fax, landline, house_no;
    private JSONObject json;
    private int success = 0;
    Person person;
    //private String strcustname = "", strMobile = "", strmail = "", strfax = "", strhouseno = "", strroadno = "", strblockno= "", strlandline = "",strlocation="";
    //Initialize webservice URL
    private static final String REGISTER_URL = "http://gulfroof.com/api/customer-reg";
    Button getlocation, btnreg;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    String lat = "28.704059";
    String longi = "77.10249";
    Button publishBtn;
    Context context;
    String locationName = "";
    String latitude = "";
    String longitude = "";
    Double Latitude;
    Double Longitude;
    String errorMsg = "";
    LocationManager mlocManager;
    AlertDialog.Builder alert;
    ProgressDialog progressDialog;
    TextView locationText;
    boolean isLocation;
    MMPermission permission;
    //  MapView mMapView;
    String locality;
    private GoogleMap googleMap;
    String giiglemap_adress;
    LocationAddress locationAddress;
    EditText house_noText, road_no, block_no, address;
    String location="";
    String street="";
    String city="";
    String state="";
    String country="";
    String user_name="";
    String mobile="";
    String email="";
    String fax_s="";
    String landline_s="";
    String house="";
    String road_s="";
    String block_s="";
    public static final String USERNAME = "user_name";
    public static final String MOBILE = "mobile";
    public static final String EMAIL = "email";
    public static final String FAX = "fax";
    public static final String LANDLINE = "landline";
    public static final String HOUSE = "house";
    public static final String ROAD = "road";
    public static final String BLOCK = "block";
    public static final String MyPref = "MyPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        alert = new AlertDialog.Builder(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait for location");
        context=this;

        editcustname = (EditText) findViewById(R.id.newcustomername);
        editmobile = (EditText) findViewById(R.id.newmobileno);
        editmail = (EditText) findViewById(R.id.customeremail);
        editfax = (EditText) findViewById(R.id.customerfax);
        editlandline = (EditText) findViewById(R.id.customerlandline);
        house_noText = (EditText) findViewById(R.id.house_no);
        road_no = (EditText) findViewById(R.id.road_no);
        block_no = (EditText) findViewById(R.id.block_no);
        address = (EditText) findViewById(R.id.location);
        getlocation = (Button) findViewById(R.id.getlocation);
        btnreg = (Button) findViewById(R.id.registerbutton);
        btnreg.setOnClickListener(this);
        getlocation.setOnClickListener(this);
        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getIntent().getStringExtra("city")!=null){
            location=getIntent().getStringExtra("city");
            address.setText(location);
        }
        sharedpreferences = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedpreferences.edit();

        sharedpreferences=getSharedPreferences(MyPref,Context.MODE_PRIVATE);
        user_name = sharedpreferences.getString(USERNAME, "");
        mobile = sharedpreferences.getString(MOBILE, "");
        email = sharedpreferences.getString(EMAIL, "");
        fax_s = sharedpreferences.getString(FAX, "");
        landline_s = sharedpreferences.getString(LANDLINE, "");
        house = sharedpreferences.getString(HOUSE, "");
        road_s = sharedpreferences.getString(ROAD, "");
        block_s = sharedpreferences.getString(BLOCK, "");
        if (user_name!=null) {
            editcustname.setText(user_name);
        }
        if (mobile!=null){
            editmobile.setText(mobile);
        }
        if (email!=null){
            editmail.setText(email);
        }
        if (fax_s!=null){
            editfax.setText(fax_s);
        }
        if (landline_s!=null){
            editlandline.setText(landline_s);
        }
        if (house!=null){
            house_noText.setText(house);
        }
        if (road_s!=null){
            road_no.setText(road_s);
        }
        if (block_s!=null){
            block_no.setText(block_s);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerbutton:
                 new Register().execute();
                break;
            case R.id.getlocation:

                user_name = editcustname.getText().toString().trim();
                mobile = editmobile.getText().toString().trim();
                email= editmail.getText().toString().trim();
                fax_s = editfax.getText().toString().trim();
                landline_s=editlandline.getText().toString().trim();
                house=house_noText.getText().toString().trim();
                road_s=road_no.getText().toString().trim();
                block_s=block_no.getText().toString().trim();



                editor.putString("user_name", user_name);
                editor.putString("mobile", mobile);
                editor.putString("email", email);
                editor.putString("fax", fax_s);
                editor.putString("landline", landline_s);
                editor.putString("house", house);
                editor.putString("road", road_s);
                editor.putString("block", block_s);
                editor.commit();

                startActivity(new Intent(getApplicationContext(), MapActivity.class));
                finish();
                break;
        }
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            Log.d("addresdd"," "+locationAddress);
            // adresstext.setText(locationAddress);
            giiglemap_adress=locationAddress;
        }
    }

    class Register extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;

        String user_name = editcustname.getText().toString().trim();
        String mobile = editmobile.getText().toString().trim();
        String  email= editmail.getText().toString().trim();
        String fax = editfax.getText().toString().trim();
        String landline=editlandline.getText().toString().trim();
        String house=house_noText.getText().toString().trim();
        String road_s=road_no.getText().toString().trim();
        String block_s=block_no.getText().toString().trim();
        String location_s=address.getText().toString().trim();



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CustomerRegistration.this);
            pDialog.setMessage("Please Wait ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... args) {
            String s = "";


            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(REGISTER_URL);
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("user_name", user_name);
                jsonObject.accumulate("mobile", mobile);
                jsonObject.accumulate("email", email);
                jsonObject.accumulate("fax", fax);
                jsonObject.accumulate("land_line", landline);
                jsonObject.accumulate("lat", latitude);
                jsonObject.accumulate("longitude", longitude);
                jsonObject.accumulate("house_no", house);
                jsonObject.accumulate("road_no", road_s);
                jsonObject.accumulate("block_no", block_s);
                jsonObject.accumulate("location", location_s);



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
                    String message = objone.getString("message");
                    AlertDialog.Builder builder = new AlertDialog.Builder(CustomerRegistration.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                    JSONArray jsonArray = objone.getJSONArray("message");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id=jsonObject.getString("id");
                        String user_name=jsonObject.getString("user_name");
                        String mobile=jsonObject.getString("mobile");
                        String email=jsonObject.getString("email");
                        String fax=jsonObject.getString("fax");
                        String land_line=jsonObject.getString("land_line");
                        String block_no=jsonObject.getString("lat");
                        String road_no=jsonObject.getString("longitude");

                    }
                    Toast.makeText(getApplicationContext(),"Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), CustomerDetails.class));
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

    public String setCriteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        String provider = mlocManager.getBestProvider(criteria, true);
        return provider;
    }
    private void registerForGPS() {
      /*  Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(true);*/


        mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            alert.setTitle("GPS");
            alert.setMessage("GPS is turned OFF...\nDo U Want Turn On GPS..");
            alert.setPositiveButton("Turn on GPS",
                    new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {

                            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                return;
                            }
                            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                                    (float) 0.01, (android.location.LocationListener) listener);
                            setCriteria();

                            mlocManager.requestLocationUpdates(
                                    LocationManager.NETWORK_PROVIDER, 0, (float)
                                            0.01, (android.location.LocationListener) listener);

                            Intent I = new Intent(
                                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(I);

                        }
                    });

            alert.show();
        }

        else {

            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                    (float) 0.01, listener);
            mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,
                    (float) 0.01, listener);
            if(!progressDialog.isShowing())progressDialog.show();
        }
    }

    private void unregisterForGPS() {
        mlocManager.removeUpdates(listener);
    }

    private final LocationListener listener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {

            if (location.getLatitude() > 0.0) {
                if (location.getAccuracy()>0 && location.getAccuracy()<1000) {
                    if(progressDialog.isShowing()) progressDialog.dismiss();
                    if(!isLocation)
                    {
                        latitude=String.valueOf(location.getLatitude());
                        longitude=String.valueOf(location.getLongitude());
                        Latitude=location.getLatitude();
                        Longitude=location.getLongitude();
                        locationName=getAddress(location.getLatitude(),location.getLongitude());
                        //  editlocation.setText(locationName);
                        // getMap();
                        Toast.makeText(getApplicationContext(), locationName, Toast.LENGTH_LONG).show();
                        unregisterForGPS();
                    }
                    isLocation=true;
                } else {
                    if(!progressDialog.isShowing()) progressDialog.show();
                }
            }
        }
        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    };


    private  String getAddress(double lat,double lang)
    {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        String address="";

        try {
            addresses = geocoder.getFromLocation(lat,lang,1);
            address=addresses.get(0).getSubLocality()+","+addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        editor.clear().commit();
    }
}
