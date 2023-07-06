package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.WebService.Asynchtask;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.WebService.WebService;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.adapters.adapter_portada_not;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.adapters.adapter_users_principal;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.add_header.add_header_list_view;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.deserialize.deserialize_json;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.event_clic.list_view_event_clic;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.volley_request.volley_request;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    private volley_request request_response_user;
    private deserialize_json des_json;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //request_response_user=new volley_request("https://revistas.uteq.edu.ec/ws/journals.php",this);
        //init_request();
        http_request_ev();
    }


    private void init_request()
    {
        request_response_user.get_request_volley();
        thread_response_data_users();
    }


    private void thread_response_data_users()
    {
        Thread thread_response=new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    while (request_response_user.getResponse()=="")
                    {
                        Log.i("responseData", "Getting data from " + request_response_user.getUrl());
                        Thread.sleep(500);
                    }
                    if(request_response_user.getResponse()!=volley_request.ERROR)
                    {
                        Log.i("responseData", request_response_user.getResponse());
                        des_json=new deserialize_json(request_response_user.getResponse(),true);
                        Log.i("responseData",des_json.getLst_users().get(0).getEmail());
                        runOnUiThread(new Runnable() { //ejecuta la funcion o el proceso en el hilo principal
                            @Override
                            public void run() {
                                init_adapter();
                            }
                        });
                    }
                }
                catch (Exception ex){
                    Log.i("Error",ex.getMessage());
                }
            }

        });
        thread_response.start();
    }


    private void init_adapter()
    {
        Log.i("responseData",des_json.getLst_users().size()+"");
        adapter_users_principal adapter_principal_users=
                new adapter_users_principal(MainActivity.this,
                        R.layout.items_principal,des_json.getLst_users());
        ListView lst_view_users=findViewById(R.id.lst_users_view);
        lst_view_users.setAdapter(adapter_principal_users);
        //añade el header
        new add_header_list_view(R.layout.list_view_header_principal,MainActivity.this,lst_view_users);
        //añadir evento click
        lst_view_users.setOnItemClickListener(new list_view_event_clic(MainActivity.this));
    }


    private void change_activity()
    {
       // Intent intent = new Intent(this, null);
      //  Bundle b=new Bundle();
      //  b.putString("id",);
    }

    //nuevo*********************
    private void http_request_ev()
    {
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        des_json=new deserialize_json(result,true);
        des_json.deserialize_json_array_not();
        adapter_portada_not adapter_revista=new adapter_portada_not(MainActivity.this,R.layout.revista_principal_portada,des_json.getLstrevistas());
        ListView lst_view_users=findViewById(R.id.lst_users_view);
        lst_view_users.setAdapter(adapter_revista);
        new add_header_list_view(R.layout.list_view_header_principal,MainActivity.this,lst_view_users);
        lst_view_users.setOnItemClickListener(new list_view_event_clic(MainActivity.this));

    }



}