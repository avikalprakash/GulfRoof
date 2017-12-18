package com.example.lue.waterroofingmeasurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Adapter.ReadResponseClass;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static Adapter.ReadResponseClass.readadsResponse;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener {
    EditText inputusername,editPassword;
    TextView textForgot;

    String ADMIN_LOGIN="http://gulfroof.lueinfoservices.com/admin-login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Button btnlogin=(Button)findViewById(R.id.btnlogin);
        inputusername=(EditText) findViewById(R.id.inputusername);
        editPassword=(EditText) findViewById(R.id.editPassword);
        textForgot=(TextView)findViewById(R.id.textForgot);
        textForgot.setOnClickListener(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inputusername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
           //new LoginAdmin().execute();
                new LoginAdmin().execute(username, password);

            }
        });
    }
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), AdminForgotPassword.class));
    }

    private class LoginAdmin extends AsyncTask<String, String, String>
    {
        ProgressDialog pdLoading = new ProgressDialog(AdminLogin.this);

        HttpURLConnection conn;
        URL url = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("Please Wait ...");
            pdLoading.show();
        }
        @Override
        protected String doInBackground(String... params) {
            String return_text="";
            try{
                HttpClient httpClient=new DefaultHttpClient();
                HttpPost httpPost=new HttpPost("http://gulfroof.com/api/admin-login");
                JSONObject jsonObject=new JSONObject();
                Log.d("params====",""+params.toString());
                jsonObject.accumulate("email",params[0]);
                jsonObject.accumulate("password",params[1]);
                StringEntity httpiEntity=new StringEntity(jsonObject.toString());
                httpPost.setEntity(httpiEntity);
                HttpResponse httpResponse=httpClient.execute(httpPost);
                return_text=readResponse(httpResponse);
            }catch(Exception e){
                e.printStackTrace();
            }
            return return_text;
        }
        public String readResponse(HttpResponse res) {
            InputStream is=null;
            String return_text="";
            try {
                is=res.getEntity().getContent();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
                String line="";
                StringBuffer sb=new StringBuffer();
                while ((line=bufferedReader.readLine())!=null)
                {
                    sb.append(line);
                }
                return_text=sb.toString();
            } catch (Exception e)
            {
            }
            return return_text;
        }
        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
            pdLoading.dismiss();
            try {
                JSONObject objone = new JSONObject(json);
                boolean check  = objone.getBoolean("error");
                if(check) {
                    String msg=objone.getString("message");
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminLogin.this);
                    builder.setMessage(msg)
                            .setNegativeButton("ok", null)
                            .create()
                            .show();
                }else{
                    JSONArray jsonArray = objone.getJSONArray("message");
                    for (int i=0; jsonArray.length()>0; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id=jsonObject.getString("id");
                        String email=jsonObject.getString("email");
                        Toast.makeText(getApplicationContext(), id+" "+email, Toast.LENGTH_LONG).show();

                        startActivity(new Intent(AdminLogin.this, SalesOption.class));
                        finish();
                    }
                    // session.createUserLoginSession(userid);
                    // SaveUserId.getInstance(getApplicationContext()).saveuserId(userid);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
