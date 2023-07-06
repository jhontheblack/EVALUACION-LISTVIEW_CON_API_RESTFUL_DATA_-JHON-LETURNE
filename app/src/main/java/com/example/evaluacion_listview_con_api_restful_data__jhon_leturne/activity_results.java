package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.deserialize.deserialize_json;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.volley_request.volley_request;

public class activity_results extends AppCompatActivity {

    private volley_request request_response_user;
    private deserialize_json des_json;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Bundle bundle = this.getIntent().getExtras();
        id=bundle.getString("id");
        //request_response_user=new volley_request("https://reqres.in/api/users?id="+id,this);
        //init_request();
        Log.i("pepaaaaa",id);
    }


    private void init_request()
    {
        request_response_user.get_request_volley();
        thread_response_data_user();
    }

    private void thread_response_data_user()
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
                        des_json=new deserialize_json(request_response_user.getResponse(),false);
                        runOnUiThread(new Runnable() { //ejecuta la funcion o el proceso en el hilo principal
                            @Override
                            public void run() {
                                update_ui_data();
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


    private void update_ui_data()
    {
        ImageView img_avatar=findViewById(R.id.img_avatar);
        TextView txt_id=findViewById(R.id.txt_id);
        TextView txt_first_name=findViewById(R.id.txt_first_name);
        TextView txt_last_name=findViewById(R.id.txt_last_name);
        TextView txt_email=findViewById(R.id.txt_email);
        //añadir imagen
        Glide.with(activity_results.this).load(des_json.getUsers().getAvatar()).into(img_avatar);
        //datos
        txt_id.setText(des_json.getUsers().getId());
        txt_first_name.setText(des_json.getUsers().getFirst_name());
        txt_last_name.setText(des_json.getUsers().getLast_name());
        txt_email.setText(des_json.getUsers().getEmail());
    }


}