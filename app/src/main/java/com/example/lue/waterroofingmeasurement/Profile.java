package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
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

/**
 * Created by lue on 11-09-2017.
 */

public class Profile extends AppCompatActivity implements View.OnClickListener {

    EditText username,mobileno,email,reEmail,landline;
    String id, user_name, mobile_no, user_email, user_landline;
    private static final String GET_SELLER_INFO = "http://gulfroof.com/api/sales_edit";
    private static final String UPDATE_SELLER_INFO = "http://gulfroof.com/api/sales_update";
    Button update, edit;
    public static final String ID = "id";
    public static final String MyPref = "MyPref";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        username=(EditText)findViewById(R.id.username);
        mobileno=(EditText)findViewById(R.id.mobileno);
        email=(EditText)findViewById(R.id.email);
        landline=(EditText)findViewById(R.id.landline);
        update=(Button)findViewById(R.id.update);
        edit=(Button)findViewById(R.id.edit);
        update.setOnClickListener(this);
        edit.setOnClickListener(this);
        sharedpreferences=getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        id=sharedpreferences.getString(ID,"");
        if (id.equals("")){
            id="2";
        }
        if (getIntent().getStringExtra("id")!=null){
            id=getIntent().getStringExtra("id");
        }
        new GetCustomerInfo().execute();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.update:
                new UpdateCustomerInfo().execute();
                break;

            case R.id.edit:
                username.setEnabled(true);
                mobileno.setEnabled(true);
                email.setEnabled(true);
                landline.setEnabled(true);
                break;
        }
    }

    class GetCustomerInfo extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Profile.this);
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
                HttpPost httpPost = new HttpPost(GET_SELLER_INFO);
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("id", id);



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
                    AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                    JSONArray jsonArray = objone.getJSONArray("message");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        user_name=jsonObject.getString("user_name");
                        mobile_no=jsonObject.getString("mobile");
                        user_email=jsonObject.getString("email");
                        user_landline=jsonObject.getString("line");
                    }
                    username.setText(user_name);
                    mobileno.setText(mobile_no);
                    email.setText(user_email);
                    landline.setText(user_landline);
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

    class UpdateCustomerInfo extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;

        String usern_name = username.getText().toString().trim();
        String mobile_no = mobileno.getText().toString().trim();
        String email_id = email.getText().toString().trim();
        String land_line = landline.getText().toString().trim();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Profile.this);
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
                HttpPost httpPost = new HttpPost(UPDATE_SELLER_INFO);
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("id", id);
                jsonObject.accumulate("user_name", usern_name);
                jsonObject.accumulate("mobile", mobile_no);
                jsonObject.accumulate("email", email_id);
                jsonObject.accumulate("line", land_line);



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
                    AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                    String message = objone.getString("message");
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
