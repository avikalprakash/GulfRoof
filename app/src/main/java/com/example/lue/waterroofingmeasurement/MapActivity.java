package com.example.lue.waterroofingmeasurement;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Adapter.GeocodingLocation;
import Adapter.LocationAddress;

import static com.example.lue.waterroofingmeasurement.AddressSearch.autocomplete;

public class MapActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    MapView mMapView;
    String locality;
    private GoogleMap googleMap;
    String giiglemap_adress;
    LocationAddress locationAddress;
    String latitude = "";
    String longitude = "";
    double Latitude;
    double Longitude;
    MMPermission permission;
    LocationManager mlocManager;
    AlertDialog.Builder alert;
    ProgressDialog progressDialog;
    Context context;
    boolean isLocation;
    String locationName = "";
    String pincode="";
    String street="";
    String city="";
    String state="";
    String country="";
    String address1="";
    String project_name="";
    String user_name="";
    String mobile="";
    String email="";
    String fax_s="";
    String landline_s="";
    String house="";
    String road_s="";
    String block_s="";
    MarkerOptions markerOptions;
    Button search;
    AutoCompleteTextView mSearch;
    ImageView assressSearch;
    Button selectAddress;
    //,mdistrict,mcittvilag,mblock;

    private ProgressDialog pDialog;

    private static final String LOG_TAG = "Google Places Autocomplete";
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";
    private static final String API_KEY = "AIzaSyD7_gkB6R8Tn2SVAgis-rrYJnB2KZtWbbQ";
   // private static final String API_KEY = "AIzaSyB5Y231ElrB3uv8GPq_olnQKxflqfTpfas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mMapView = (MapView)findViewById(R.id.map);
        mSearch = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        selectAddress = (Button)findViewById(R.id.selectAddress);
        mSearch.setAdapter(new GooglePlacesAutocompleteAdapter(getApplicationContext(), R.layout.autocomplete));
        mSearch.setOnItemClickListener(this);
        assressSearch=(ImageView)findViewById(R.id.assressSearch);
        assressSearch.setOnClickListener(this);
        selectAddress.setOnClickListener(this);
        context=this;
        project_name=getIntent().getStringExtra("project_name");
        user_name=getIntent().getStringExtra("user_name");
        mobile=getIntent().getStringExtra("mobile");
        email=getIntent().getStringExtra("email");
        fax_s=getIntent().getStringExtra("fax");
        landline_s=getIntent().getStringExtra("landline");
        house=getIntent().getStringExtra("house");
        road_s=getIntent().getStringExtra("road");
        block_s=getIntent().getStringExtra("block");

        alert = new AlertDialog.Builder(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait for location");
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        permission = new MMPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permission.result == -1 || permission.result == 0) {
            try {
                registerForGPS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (permission.result == 1) {
            registerForGPS();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    public static ArrayList autocomplete(String input) {

        Log.d("chala00","chal");
        ArrayList resultList = null;
        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + API_KEY);
            sb.append("&components=country:in");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));
            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {

            return resultList;

        } catch (IOException e) {

            return resultList;
        } finally {
            if (conn != null) {

                conn.disconnect();
            }
        }
        try {

            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

            resultList = new ArrayList(predsJsonArray.length());
            Log.d("arrjs00", String.valueOf(predsJsonArray));
            for (int i = 0; i < predsJsonArray.length(); i++) {
                System.out.println(predsJsonArray.getJSONObject(i).getString("description"));
                System.out.println("============================================================");
                resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
            }
        } catch(JSONException e){

        }
        return resultList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

      Toast.makeText(getApplicationContext(), String.valueOf(l), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.assressSearch:
                String address = mSearch.getText().toString();
                GeocodingLocation locationAddress = new GeocodingLocation();
                locationAddress.getAddressFromLocation(address,
                        getApplicationContext(), new GeocoderHandler());
                break;

            case R.id.selectAddress:
                Intent i= new Intent(getApplicationContext(), Registration.class);
                i.putExtra("pincode", pincode);
                i.putExtra("street", street);
                i.putExtra("address1", address1);
                i.putExtra("state", state);
                i.putExtra("city", city);
                i.putExtra("country", country);
                i.putExtra("lat", latitude);
                i.putExtra("long", longitude);

                i.putExtra("project_name", project_name);
                i.putExtra("user_name", user_name);
                i.putExtra("mobile", mobile);
                i.putExtra("email", email);
                i.putExtra("fax", fax_s);
                i.putExtra("landline", landline_s);
                i.putExtra("house", house);
                i.putExtra("road", road_s);
                i.putExtra("block", block_s);
                startActivity(i);
                finish();
                break;
        }
    }


    class GooglePlacesAutocompleteAdapter extends ArrayAdapter implements android.widget.Filterable {
        private ArrayList resultList;
        public GooglePlacesAutocompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }
        @Override
        public int getCount() {
            return resultList.size();
        }
        @Override
        public String getItem(int index) {
            return resultList.get(index).toString();
        }
        @Override
        public android.widget.Filter getFilter() {
            android.widget.Filter filter = new android.widget.Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {

                        resultList = autocomplete(constraint.toString());

                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }
                    return filterResults;
                }
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
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
                        getMap();
                       // Toast.makeText(getApplicationContext(), locationName, Toast.LENGTH_LONG).show();
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



    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    latitude = bundle.getString("lat");
                    longitude = bundle.getString("lang");
                    if (latitude != null && longitude != null) {
                       // Toast.makeText(getApplicationContext(), latitude + ", " + longitude, Toast.LENGTH_LONG).show();
                        Latitude = Double.parseDouble(latitude);
                        Longitude = Double.parseDouble(longitude);
                        getMap();
                    }else {
                    }
                    break;
                default:
                    locationAddress = null;
            }
        }
    }

    private class GeocoderHandler2 extends Handler {
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

    private  String getAddress(double lat,double lang)
    {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        String address="";

        try {
            addresses = geocoder.getFromLocation(lat,lang,1);
            pincode=addresses.get(0).getPostalCode();
            street=addresses.get(0).getSubLocality();
            city=addresses.get(0).getLocality();
            state=addresses.get(0).getAdminArea();
            country=addresses.get(0).getCountryName();
            address1 = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

            Log.d("TAG", "getAddress:  address" + address1);
            Log.d("TAG", "getAddress:  city" + city);
            Log.d("TAG", "getAddress:  state" + state);
            Log.d("TAG", "getAddress:  postalCode" + postalCode);
            Log.d("TAG", "getAddress:  knownName" + knownName);
          //  address=addresses.get(0).getSubLocality()+","+addresses.get(0).getLocality()+", "+addresses.get(0).getPostalCode()
              //      +", "+addresses.get(0).getCountryName()+", "+addresses.get(0).getAdminArea();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }
    public void getMap(){
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
                    public void onMapClick(LatLng point){
                        Latitude=point.latitude;
                        Longitude=point.longitude;
                        latitude=String.valueOf(Latitude);
                        longitude=String.valueOf(Longitude);


                        googleMap.clear();

                        // Animating to the touched position
                        googleMap.animateCamera(CameraUpdateFactory.newLatLng(point));

                        markerOptions = new MarkerOptions();

                        // Setting the position for the marker
                        markerOptions.position(point);

                        // Placing a marker on the touched position
                        googleMap.addMarker(markerOptions);
                      //  Toast.makeText(getApplicationContext(),point.latitude + ", " + point.longitude,Toast.LENGTH_SHORT).show();
                        locationName=getAddress(Latitude,Longitude);
                        Toast.makeText(getApplicationContext(), "Your loaction has been selected", Toast.LENGTH_LONG).show();
                    }
                });
                // Add a marker in Sydney, Australia, and move the camera.

                LatLng LatLong = new LatLng(Latitude, Longitude);
                Log.d("valueinProductPage","  "+Longitude+" "+Latitude);
                locationAddress.getAddressFromLocation(Latitude, Longitude,
                        getApplicationContext(), new GeocoderHandler2());
                giiglemap_adress = latitude+" "+longitude;
                googleMap.addMarker(new MarkerOptions().position(LatLong).title(giiglemap_adress).position(LatLong));

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLong));
                googleMap.animateCamera( CameraUpdateFactory.zoomTo( 8.0f ) );

                googleMap.getMaxZoomLevel();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i= new Intent(getApplicationContext(), Registration.class);
        i.putExtra("pincode", pincode);
        i.putExtra("street", street);
        i.putExtra("address1", address1);
        i.putExtra("state", state);
        i.putExtra("city", city);
        i.putExtra("country", country);
        i.putExtra("lat", latitude);
        i.putExtra("long", longitude);

        i.putExtra("project_name", project_name);
        i.putExtra("user_name", user_name);
        i.putExtra("mobile", mobile);
        i.putExtra("email", email);
        i.putExtra("fax", fax_s);
        i.putExtra("landline", landline_s);
        i.putExtra("house", house);
        i.putExtra("road", road_s);
        i.putExtra("block", block_s);
        startActivity(i);
        finish();
    }
}
