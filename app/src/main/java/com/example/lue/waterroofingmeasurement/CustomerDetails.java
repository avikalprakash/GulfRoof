package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Adapter.CustomerItemDetails;
import Adapter.CustomerListAdaptor;
import Adapter.RecycleAdapter;
import Adapter.ServiceHandler;
import SetterGetter.ItemRecyclerObject;

/**
 * Created by lue on 12-09-2017.
 */

public class CustomerDetails extends AppCompatActivity implements CustomerListFragment.OnListFragmentInteractionListener{
    RecycleAdapter madapter;
    public static ArrayList<CustomerItemDetails> customerItemDetailses = new ArrayList<>();
    ProgressDialog pDialog;
    SharedPreferences pref;
    ListView listCustomer;
    SharedPreferences.Editor editor ;
    CustomerListAdaptor customerListAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerdetails);
        listCustomer=(ListView)findViewById(R.id.listCustomer);
        pDialog = new ProgressDialog(CustomerDetails.this);
        pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        listCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), OneRoof.class));
                editor.putString("email", customerItemDetailses.get(i).getEmail());
                editor.putString("user_name", customerItemDetailses.get(i).getUser_name());
                editor.putString("mobile", customerItemDetailses.get(i).getMobile());
                editor.putString("address", customerItemDetailses.get(i).getAddress());
                editor.putString("lat", customerItemDetailses.get(i).getLat());
                editor.putString("long", customerItemDetailses.get(i).getLang());
                editor.commit();
            }
        });
        new CustomersList().execute();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
              startActivity(new Intent(getApplicationContext(), CustomerRegistration.class));
                editor.clear().commit();
                break;
            case R.id.search:
             startActivity(new Intent(getApplicationContext(), SearchCustomer.class));
                break;
        }
        return true;
    }
    @Override
    public void onListFragmentInteraction(CustomerItemDetails item) {
        startActivity(new Intent(getApplicationContext(), OneRoof.class));
        editor.putString("email", item.getEmail());
        editor.putString("user_name", item.getUser_name());
        editor.putString("mobile", item.getMobile());
        editor.putString("address", item.getAddress());
        editor.putString("lat", item.getLat());
        editor.putString("long", item.getLang());
        editor.commit();
    }

    private class CustomersList extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CustomerDetails.this);
            pDialog.setMessage("loading...");
            pDialog.setIndeterminate(false);
            pDialog.show();
            customerItemDetailses=new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall("http://gulfroof.com/api/get_customer_list", ServiceHandler.GET);
            if(json!=null)
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    boolean error = jsonObject.getBoolean("error");

                    if (!error) {
                        JSONArray jsonArray = jsonObject.getJSONArray("message");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jobject = jsonArray.getJSONObject(i);
                            CustomerItemDetails customerItemDetails = new CustomerItemDetails();
                            customerItemDetails.setId(jobject.getString("id"));
                            customerItemDetails.setUser_name(jobject.getString("user_name"));
                            customerItemDetails.setMobile(jobject.getString("mobile"));
                            customerItemDetails.setEmail(jobject.getString("email"));
                            customerItemDetails.setAddress(jobject.getString("location"));
                            customerItemDetails.setLang(jobject.getString("lat"));
                            customerItemDetails.setLat(jobject.getString("longitude"));
                            customerItemDetailses.add(customerItemDetails);
                            // promotionDetailses.add(new PromotionDetails((JSONObject)jsonArray.get(i)));
                        }


                    }
                } catch (JSONException e) {
                }
            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            customerListAdaptor = new CustomerListAdaptor(CustomerDetails.this, customerItemDetailses);
            listCustomer.setAdapter(customerListAdaptor);
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }


}
