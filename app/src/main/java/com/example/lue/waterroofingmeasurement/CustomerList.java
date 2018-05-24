package com.example.lue.waterroofingmeasurement;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class CustomerList extends AppCompatActivity implements CustomerListFragment2.OnListFragmentInteractionListener{
    RecycleAdapter madapter;
    public static ArrayList<CustomerItemDetails> customerItemDetailses = new ArrayList<>();
    ProgressDialog pDialog;
    CustomerListAdaptor customerListAdaptor;
    SharedPreferences pref;
    String id;
    ListView listCustomer;
    private static final int SHOW_PROCESS_DIALOG = 1;
    private static final int HIDE_PROCESS_DIALOG = 0;
    Context context;
    Dialog dialog;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        listCustomer=(ListView)findViewById(R.id.listCustomer);
        pDialog = new ProgressDialog(CustomerList.this);
        pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
        context=this;
        dialog = new Dialog(CustomerList.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fill_dialog);
        listCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), EditCustomerDetails.class);
                intent.putExtra("id", customerItemDetailses.get(i).getId());
                intent.putExtra("lat", customerItemDetailses.get(i).getLat());
                intent.putExtra("longitude", customerItemDetailses.get(i).getLang());
                startActivity(intent);
                finish();
            }
        });


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        new CustomersList().execute();

    }
    @Override
    public void onListFragmentInteraction(CustomerItemDetails item) {
       /* Intent intent = new Intent(getApplicationContext(), EditCustomerDetails.class);
        intent.putExtra("id", item.getId());
        intent.putExtra("lat", item.getLat());
        intent.putExtra("longitude", item.getLang());
        startActivity(intent);
        finish();*/
    }
    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch(message.what){
                case SHOW_PROCESS_DIALOG :
                    // pb.setVisibility(View.VISIBLE);
                    dialog.show();
                    break;
                case HIDE_PROCESS_DIALOG :
                    //  pb.setVisibility(View.GONE);
                    dialog.hide();
                    break;
            }
            return false;
        }
    });


    private class CustomersList extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CustomerList.this);
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
            customerListAdaptor = new CustomerListAdaptor(CustomerList.this, customerItemDetailses);
            listCustomer.setAdapter(customerListAdaptor);
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }
}
