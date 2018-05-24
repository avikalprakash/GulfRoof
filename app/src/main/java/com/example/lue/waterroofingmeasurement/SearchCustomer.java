package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Adapter.CustomerItemDetails;
import Adapter.CustomerListAdaptor;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class SearchCustomer extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<CustomerItemDetails> customerItemDetailses = new ArrayList<>();
    ListView listCustomer;
    CustomerListAdaptor customerListAdaptor;
    ImageView searchItem;
    String user_name,mobile, email;
    TextView emailText, usernameTxt, mobileTxt, emailTxt ;
    RelativeLayout relative;
    String SEARCH_CUSTOMER="http://gulfroof.com/api/get_search_list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_customer);
        listCustomer=(ListView)findViewById(R.id.listCustomer);
        searchItem=(ImageView)findViewById(R.id.searchItem);
        emailText=(TextView) findViewById(R.id.emailText);
       /* usernameTxt=(TextView) findViewById(R.id.username);
        mobileTxt=(TextView) findViewById(R.id.mobile);
        emailTxt=(TextView) findViewById(R.id.email);
        relative=(RelativeLayout)findViewById(R.id.relative);*/
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
        searchItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
     new SearchCustom().execute();

    }


    class SearchCustom extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;

        String email_enter = emailText.getText().toString().trim();



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SearchCustomer.this);
            pDialog.setMessage("Please Wait ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
            customerItemDetailses.clear();

        }

        @Override
        protected String doInBackground(String... args) {
            String s = "";


            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://gulfroof.com/api/get_search_list");
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("email", email_enter);




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
                    AlertDialog.Builder builder = new AlertDialog.Builder(SearchCustomer.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                    JSONArray jsonArray = objone.getJSONArray("message");
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
                   /* relative.setVisibility(View.VISIBLE);
                    usernameTxt.setText(user_name);
                    mobileTxt.setText(mobile);
                    emailTxt.setText(email);*/
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            customerListAdaptor = new CustomerListAdaptor(SearchCustomer.this, customerItemDetailses);
            listCustomer.setAdapter(customerListAdaptor);
            if (pDialog.isShowing())
                pDialog.dismiss();
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

}
