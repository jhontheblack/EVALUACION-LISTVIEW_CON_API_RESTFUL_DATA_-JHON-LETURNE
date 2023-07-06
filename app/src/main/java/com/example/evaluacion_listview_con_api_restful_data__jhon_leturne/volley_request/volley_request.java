package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.volley_request;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class volley_request {

    public static String ERROR="Ha ocurrido un error";
    private Context context;
    private String response;
    private String url;


    public void get_request_volley()
    {
        try{
            RequestQueue queue = Volley.newRequestQueue(getContext());
            StringRequest stringRequest = new StringRequest(Request.Method.GET, getUrl(), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    setResponse(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    setResponse(ERROR);
                }
            });
            queue.add(stringRequest);
        }
        catch (Exception ex){
            setResponse(ERROR);
        }
    }


    //constructor
    public volley_request(String url,Context context)
    {
        this.context=context;
        this.url=url;
        setResponse("");
    }



    //Getters y Setters

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
