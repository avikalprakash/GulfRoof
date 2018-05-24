package Adapter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fujitsu on 02-11-2017.
 */

public class SellerItemDetails {

    String id="";
    String user_name="";
    String mobile="";
    String email="";

    public SellerItemDetails() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {

        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public SellerItemDetails(JSONObject jsonObject) {

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
    }
}
