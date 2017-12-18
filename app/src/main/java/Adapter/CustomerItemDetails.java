package Adapter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fujitsu on 20-09-2017.
 */

public class CustomerItemDetails {
    String id="";
    String user_name="";
    String mobile="";
    String email="";
    String address="";
    String lat="";
    String lang="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAddress() {

        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLang() {
        return lang;
    }



    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerItemDetails(JSONObject jsonObject) {

        try {
            this.id=jsonObject.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.user_name=jsonObject.getString("user_name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.mobile=jsonObject.getString("mobile");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.email=jsonObject.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.address=jsonObject.getString("location");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.lat=jsonObject.getString("lat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.lang=jsonObject.getString("longitude");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
