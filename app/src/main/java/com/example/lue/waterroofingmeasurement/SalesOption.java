package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Adapter.CustomerItemDetails;
import Adapter.CustomerListAdaptor;
import Adapter.SellerItemDetails;
import Adapter.SellerListAdaptor;
import Adapter.ServiceHandler;

public class SalesOption extends AppCompatActivity  implements SalerListFragment.OnListFragmentInteractionListener{
    public static ArrayList<SellerItemDetails> sellerItemDetailses = new ArrayList<>();
    ProgressDialog pDialog;
    SellerListAdaptor sellerListAdaptor;
    ListView listCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_option);
        listCustomer=(ListView)findViewById(R.id.listCustomer);
        pDialog = new ProgressDialog(SalesOption.this);
        new SellerList().execute();
        listCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ProfileInAdmin.class);
                intent.putExtra("id", sellerItemDetailses.get(i).getId());
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_saller_list, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                startActivity(new Intent(getApplicationContext(), AdminRegister.class));
                break;
        }
        return true;
    }

    @Override
    public void onListFragmentInteraction(SellerItemDetails item) {
      /*  Intent intent = new Intent(getApplicationContext(), ProfileInAdmin.class);
        intent.putExtra("id", item.getId());
        startActivity(intent);
        finish();*/
    }



    private class SellerList extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SalesOption.this);
            pDialog.setMessage("loading...");
            pDialog.setIndeterminate(false);
            pDialog.show();
            sellerItemDetailses=new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall("http://gulfroof.com/api/get_sales_user_list", ServiceHandler.GET);
            if(json!=null)
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    boolean error = jsonObject.getBoolean("error");

                    if (!error) {
                        JSONArray jsonArray = jsonObject.getJSONArray("message");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jobject = jsonArray.getJSONObject(i);
                            SellerItemDetails customerItemDetails = new SellerItemDetails();
                            customerItemDetails.setId(jobject.getString("id"));
                            customerItemDetails.setUser_name(jobject.getString("user_name"));
                            customerItemDetails.setMobile(jobject.getString("mobile"));
                            customerItemDetails.setEmail(jobject.getString("email"));
                           /* customerItemDetails.setAddress(jobject.getString("location"));
                            customerItemDetails.setLang(jobject.getString("lat"));
                            customerItemDetails.setLat(jobject.getString("longitude"));*/
                            sellerItemDetailses.add(customerItemDetails);
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
            sellerListAdaptor = new SellerListAdaptor(SalesOption.this, sellerItemDetailses);
            listCustomer.setAdapter(sellerListAdaptor);
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }
}
