package com.lf.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krish on 22/11/15.
 */
public class WebServiceVolleyExample extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private void init() {
        mListView = (ListView) findViewById(R.id.listview);
    }

    private void webserviceCall() {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, "url here", new JSONObject(), onSuccess, onError) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                // add header here if needed
                return headerMap;
            }
        };
    }


    private Response.Listener<JSONObject> onSuccess = new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {
        // on Successful callback
        }

    };
    private Response.ErrorListener onError = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            // on Error Call back


        }

    };

}
