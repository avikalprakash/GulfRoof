package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Adapter.ReadResponseClass;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class AdminRegister extends AppCompatActivity implements View.OnClickListener {
    EditText username,mobileno,email,reEmail,landline;
    Button registerbutton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String REGISTER_URL = "http://gulfroof.com/api/sales-reg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);
        username=(EditText)findViewById(R.id.username);
        mobileno=(EditText)findViewById(R.id.mobileno);
        email=(EditText)findViewById(R.id.email);
        reEmail=(EditText)findViewById(R.id.reEmail);
        landline=(EditText)findViewById(R.id.landline);
        registerbutton=(Button) findViewById(R.id.registerbutton);
        registerbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.registerbutton:

              new Register().execute();

              break;
      }
    }


    class Register extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;

        String user_name = username.getText().toString().trim();
        String mobile = mobileno.getText().toString().trim();
        String  Email= email.getText().toString().trim();
        String re_email = reEmail.getText().toString().trim();
        String line=landline.getText().toString().trim();




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AdminRegister.this);
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
                HttpPost httpPost = new HttpPost(REGISTER_URL);
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("user_name", user_name);
                jsonObject.accumulate("mobile", mobile);
                jsonObject.accumulate("email", Email);
                jsonObject.accumulate("password", re_email);
                jsonObject.accumulate("line", line);


                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPost.setEntity(stringEntity);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                s = ReadResponseClass.readadsResponse(httpResponse);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminRegister.this);
                    builder.setMessage(message)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{

                    JSONArray jsonArray = objone.getJSONArray("message");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id=jsonObject.getString("id");
                        String user_name=jsonObject.getString("user_name");
                        String mobile=jsonObject.getString("mobile");
                        String email=jsonObject.getString("email");
                        String fax=jsonObject.getString("password");
                        String land_line=jsonObject.getString("line");
                        SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = pref.edit();
                        editor2.putString("id", id);
                        editor2.commit();
                        //  Intent nextactivity=new Intent(Registration.this,OneRoof.class);
                        //  Toast.makeText(getApplicationContext(), id+user_name+mobile+email+fax+land_line+house_no+block_no+road_no+location, Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminRegister.this);
                    builder.setMessage("Register Successful")
                            .setNegativeButton("ok", null)
                            .create()
                            .show();

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
