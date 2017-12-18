package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Adapter.CustomerItemDetails;
import Adapter.SellerItemDetails;
import Adapter.ServiceHandler;

public class SalesOption extends AppCompatActivity  implements SalerListFragment.OnListFragmentInteractionListener{
    public static List<SellerItemDetails> sellerItemDetailses = new ArrayList<>();
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_option);
        pDialog = new ProgressDialog(SalesOption.this);
        new SellerList().execute();
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
        Intent intent = new Intent(getApplicationContext(), Profile.class);
        intent.putExtra("id", item.getId());
        startActivity(intent);

    }

    private class SellerList extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog.setMessage("Loading...");
            pDialog.show();
            pDialog.setCancelable(false);
            sellerItemDetailses=new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall("http://gulfroof.com/api/get_sales_user_list", ServiceHandler.GET);
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
                            sellerItemDetailses.add(new SellerItemDetails((JSONObject)jsonArray.get(i)));
                        }
                        if (sellerItemDetailses.size()>0) {

                            Collections.sort(sellerItemDetailses, new Comparator<SellerItemDetails>()
                            {
                                @Override
                                public int compare(SellerItemDetails lhs, SellerItemDetails rhs) {
                                    return (rhs.getId()).compareTo(lhs.getId());
                                }
                            });
                        }
                    }
                    SalerListFragment paidItemFragment=new SalerListFragment();
                    FragmentTransaction fm=getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.frameSalerList,paidItemFragment);
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
