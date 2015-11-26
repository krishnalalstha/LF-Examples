package com.lf.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lf.example.app.MyApplication;
import com.lf.example.model.UserInfo;
import com.lf.example.utility.Utility;
import com.zykyanphotography.mylibrary.Test;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krish on 22/11/15.
 */
public class WebServiceVolleyExample extends AppCompatActivity {
    ListView mListView;

    String url="http://api.androidhive.info/contacts/";

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myApplication= (MyApplication) getApplication();


        if(Utility.checkNetworkAvailability(this)){
            try {
                webserviceCall();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this,"No internet",Toast.LENGTH_SHORT).show();
        }


    }


    private void init() {
        mListView = (ListView) findViewById(R.id.listview);
    }

    private void webserviceCall() throws JSONException {


        JSONObject params=new JSONObject();
        params.put("username","test");
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, "http://jsonstub.com/api/login", params , onSuccess, onError) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                // add header here if needed

                headerMap.put("Content-Type", "application/json");
                headerMap.put("JsonStub-User-Key","1f226e05-b153-42f9-8cd3-1b6c55f7a41c");
                headerMap.put("JsonStub-Project-Key","4bcb2598-a50e-4204-803e-db9ce057b6f5");
                return headerMap;
            }
        };

        myApplication.getVolleyInstace().add(jsObjRequest);


    }


    private Response.Listener<JSONObject> onSuccess = new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {

            Log.e("respose",response.toString());

            Gson gson = new GsonBuilder().create();
            UserInfo p = gson.fromJson(response.toString(), UserInfo.class);
            System.out.println(p.userName +"::"+p.address);

        // on Successful callback
        }

    };
    private Response.ErrorListener onError = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            // on Error Call back

            Log.e("error","error aayo");




        }

    };

}
