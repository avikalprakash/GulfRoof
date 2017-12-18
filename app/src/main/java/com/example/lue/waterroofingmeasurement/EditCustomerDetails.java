package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class EditCustomerDetails extends AppCompatActivity implements View.OnClickListener {
    String id, username, mobile, email, fax, land_line, houseNo, roadNo, blockNo, address, lat, longitude;
    EditText newcustomername, newmobileno, customeremail, customerfax, customerlandline, house_no, road_no, block_no, location;
    String GET_CUSTOMER_INFO="http://gulfroof.com/api/edit_customer";
    String UPDATE_CUSTOMER_INFO="http://gulfroof.com/api/update_customer";
    String DELETE_CUSTOMER_INFO="http://gulfroof.com/api/delete_customer";
    Button updatebutton, deletebutton;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer_details);
        newcustomername=(EditText)findViewById(R.id.newcustomername);
        newmobileno=(EditText)findViewById(R.id.newmobileno);
        customeremail=(EditText)findViewById(R.id.customeremail);
        customerfax=(EditText)findViewById(R.id.customerfax);
        customerlandline=(EditText)findViewById(R.id.customerlandline);
        house_no=(EditText)findViewById(R.id.house_no);
        road_no=(EditText)findViewById(R.id.road_no);
        block_no=(EditText)findViewById(R.id.block_no);
        location=(EditText)findViewById(R.id.location);
        updatebutton=(Button)findViewById(R.id.updatebutton);
        deletebutton=(Button)findViewById(R.id.deletebutton);
        updatebutton.setOnClickListener(this);
        deletebutton.setOnClickListener(this);
        id=getIntent().getStringExtra("id");
        lat=getIntent().getStringExtra("lat");
        longitude=getIntent().getStringExtra("longitude");

        new GetCustomerInfo().execute();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.updatebutton:
               new UpdateCustomerInfo().execute();
                break;
            case R.id.deletebutton:
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditCustomerDetails.this);
                LayoutInflater layoutInflater = LayoutInflater.from(EditCustomerDetails.this);
                View eulaLayout = layoutInflater.inflate(R.layout.alert_dialog, null);
                checkBox=(CheckBox)eulaLayout.findViewById(R.id.checkbox);
                alertDialog.setView(eulaLayout);
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (checkBox.isChecked()) {
                            new DeleteCustomerInfo().execute();
                        }else {
                            alertDialog.setCancelable(false);
                            Toast.makeText(getApplicationContext(), "Please select the checkbox to delete", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.create().show();
                break;
        }
    }

    class GetCustomerInfo extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditCustomerDetails.this);
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
                HttpPost httpPost = new HttpPost(GET_CUSTOMER_INFO);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditCustomerDetails.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                    JSONArray jsonArray = objone.getJSONArray("message");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id=jsonObject.getString("id");
                        username=jsonObject.getString("user_name");
                        mobile=jsonObject.getString("mobile");
                        email=jsonObject.getString("email");
                        fax=jsonObject.getString("fax");
                        land_line=jsonObject.getString("land_line");
                        lat=jsonObject.getString("lat");
                        longitude=jsonObject.getString("longitude");
                        houseNo=jsonObject.getString("house_no");
                        roadNo=jsonObject.getString("road_no");
                        blockNo=jsonObject.getString("block_no");
                        address=jsonObject.getString("location");
                    }
                    newcustomername.setText(username);
                    newmobileno.setText(mobile);
                    customeremail.setText(email);
                    customerfax.setText(fax);
                    customerlandline.setText(land_line);
                    house_no.setText(houseNo);
                    road_no.setText(roadNo);
                    block_no.setText(blockNo);
                    location.setText(address);
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

        String customer_name = newcustomername.getText().toString().trim();
        String customer_mobile = newmobileno.getText().toString().trim();
        String customer_email = customeremail.getText().toString().trim();
        String customer_fax = customerfax.getText().toString().trim();
        String customer_landline = customerlandline.getText().toString().trim();
        String customer_houseNo = house_no.getText().toString().trim();
        String customer_roadNo = road_no.getText().toString().trim();
        String customer_blockNo = block_no.getText().toString().trim();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditCustomerDetails.this);
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
                HttpPost httpPost = new HttpPost(UPDATE_CUSTOMER_INFO);
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("id", id);
                jsonObject.accumulate("user_name", customer_name);
                jsonObject.accumulate("mobile", customer_mobile);
                jsonObject.accumulate("email", customer_email);
                jsonObject.accumulate("fax", customer_fax);
                jsonObject.accumulate("land_line", customer_landline);
                jsonObject.accumulate("house_no", customer_houseNo);
                jsonObject.accumulate("road_no", customer_roadNo);
                jsonObject.accumulate("block_no", customer_blockNo);



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
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditCustomerDetails.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                   String message = objone.getString("message");
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), CustomerList.class));
                    finish();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class DeleteCustomerInfo extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditCustomerDetails.this);
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
                HttpPost httpPost = new HttpPost(DELETE_CUSTOMER_INFO);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditCustomerDetails.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else {
                    String message = objone.getString("message");
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), CustomerList.class));
                    finish();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), CustomerList.class));
        finish();
    }
}
