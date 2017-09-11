package com.mostafaabdel_fatah.volleydemo4;

import android.app.DownloadManager;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMError;

import java.util.ArrayList;

/**
 * Created by Mostafa AbdEl_Fatah on 9/8/2017.
 */

public class JsonFetchBackgroundTask {
    private Context context;
    ArrayList<Doctor> doctorArrayList = new ArrayList<>();
    String jsonArray_Url = "http://10.0.2.2/MyWebSites/doctors.php" ;

    public JsonFetchBackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Doctor> getArrayList() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, jsonArray_Url, (String) null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("doctors");
                    for (int i = 0 ; i < jsonArray.length() ; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        doctorArrayList.add(new Doctor(jsonObject.getString("name")
                                , jsonObject.getString("spec"), jsonObject.getString("address")
                                , jsonObject.getString("phone")));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        SingleTon.getsInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectRequest);
        return doctorArrayList;
    }
}
