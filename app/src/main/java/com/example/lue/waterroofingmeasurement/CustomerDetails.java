package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Adapter.CustomerItemDetails;
import Adapter.RecycleAdapter;
import Adapter.ServiceHandler;
import SetterGetter.ItemRecyclerObject;

/**
 * Created by lue on 12-09-2017.
 */

public class CustomerDetails extends AppCompatActivity implements CustomerListFragment.OnListFragmentInteractionListener{
    RecycleAdapter madapter;
    public static List<CustomerItemDetails> customerItemDetailses = new ArrayList<>();
    ProgressDialog pDialog;
    SharedPreferences pref;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerdetails);
        pDialog = new ProgressDialog(CustomerDetails.this);
        pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
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
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog.setMessage("Loading...");
            pDialog.show();
            pDialog.setCancelable(false);
            customerItemDetailses=new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall("http://gulfroof.com/api/get_customer_list", ServiceHandler.GET);
            if(json!=null)
            {
                try {
                    JSONObject jsonObject=new JSONObject(json);
                    boolean error=jsonObject.getBoolean("error");

                    if(!error)
                    {
                        JSONArray jsonArray=jsonObject.getJSONArray("message");
                        for(int i=0;i<jsonArray.length();i++)
                        {
                            customerItemDetailses.add(new CustomerItemDetails((JSONObject)jsonArray.get(i)));
                        }
                        if (customerItemDetailses.size()>0) {

                            Collections.sort(customerItemDetailses, new Comparator<CustomerItemDetails>()
                            {
                                @Override
                                public int compare(CustomerItemDetails lhs, CustomerItemDetails rhs) {
                                    return (rhs.getId()).compareTo(lhs.getId());
                                }
                            });
                        }
                    }
                    CustomerListFragment paidItemFragment=new CustomerListFragment();
                    FragmentTransaction fm=getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.frameCustomerList,paidItemFragment);
                    fm.commitAllowingStateLoss();
                } catch (JSONException e) {}
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }
}
