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
import android.view.Window;
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

public class CustomerList extends AppCompatActivity implements CustomerListFragment2.OnListFragmentInteractionListener{
    RecycleAdapter madapter;
    public static List<CustomerItemDetails> customerItemDetailses = new ArrayList<>();
    ProgressDialog pDialog;
    SharedPreferences pref;
    String id;
    private static final int SHOW_PROCESS_DIALOG = 1;
    private static final int HIDE_PROCESS_DIALOG = 0;
    Context context;
    Dialog dialog;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        pDialog = new ProgressDialog(CustomerList.this);
        pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
        context=this;
        dialog = new Dialog(CustomerList.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fill_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        new CustomersList().execute();

    }
    @Override
    public void onListFragmentInteraction(CustomerItemDetails item) {
        Intent intent = new Intent(getApplicationContext(), EditCustomerDetails.class);
        intent.putExtra("id", item.getId());
        intent.putExtra("lat", item.getLat());
        intent.putExtra("longitude", item.getLang());
        startActivity(intent);
        finish();
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
                    CustomerListFragment2 paidItemFragment=new CustomerListFragment2();
                    FragmentTransaction fm=getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.customerList,paidItemFragment);
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
