package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url="https://api.covid19india.org/data.json";
    Adapter fadapter;
    RecyclerView feedbackRCV;
    ArrayList<data> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedbackRCV = (RecyclerView)findViewById(R.id.rcv);
        //
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jso = new JSONObject(response);
                    List= new ArrayList<>();
                    List.clear();
                    JSONArray jr = jso.getJSONArray("statewise");
                    for(int i = 0;i<jr.length();i++) {
                        JSONObject jso1 = jr.getJSONObject(i);
                        if(jso1.getString("confirmed") != "0"){
                        data gf = new data();
                        gf.setState(jso1.getString("state"));
                        gf.setConfirmed(jso1.getString("confirmed"));
                        gf.setActive(jso1.getString("active"));
                        gf.setRecovered(jso1.getString("recovered"));
                        gf.setDeaths(jso1.getString("deaths"));
                        gf.setNewcases(jso1.getString("deltaconfirmed"));
                        gf.setNrecovered(jso1.getString("deltarecovered"));
                        gf.setNdeath(jso1.getString("deltadeaths"));
                        List.add(gf);
                        System.out.print(List.get(i).getState());
                        System.out.println(jso1.getString("confirmed"));
                        }
                    }

                    fadapter = new Adapter(MainActivity.this,List);
                    feedbackRCV.setAdapter(fadapter);
                    feedbackRCV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    System.out.print(jso.toString());
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                }

        );
//Create a Queue
        RequestQueue reqQueue= Volley.newRequestQueue(this);
        //add a request to the queue
        reqQueue.add(stringRequest);


    }
}

