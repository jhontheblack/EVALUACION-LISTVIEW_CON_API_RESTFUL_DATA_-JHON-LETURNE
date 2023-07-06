package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.deserialize;

import android.util.Log;

import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.Revistas;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.Volumen;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.user;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class deserialize_json {

    private String response;
    private List<user> lst_users;
    private user users;
    private user user_res;
    private Revistas revistas;
    private List<Revistas> lstrevistas;

    public deserialize_json(String response,Boolean band)
    {
        this.response=response;
        //if(band)
        //    deserialize_json_array();
        //else
        //    deserialize_json();
        lstrevistas=new ArrayList<>();
    }

    //deserializar json array
    private void deserialize_json_array()
    {
        try {
            List<user> lst_use=new ArrayList<>();
            JSONObject json_object = new JSONObject(getResponse());
            JSONArray json_array=json_object.getJSONArray("data");
            for(int x=0;x<json_array.length();x++)
            {
                user_res=new user();
                JSONObject json_object_for_user=json_array.getJSONObject(x);
                user_res.setId(json_object_for_user.getString("id"));
                user_res.setEmail(json_object_for_user.getString("email"));
                user_res.setFirst_name(json_object_for_user.getString("first_name"));
                user_res.setLast_name(json_object_for_user.getString("last_name"));
                user_res.setAvatar(json_object_for_user.getString("avatar"));
                lst_use.add(user_res);
            }
            setLst_users(lst_use);
        }
        catch (Exception ex)
        {
            Log.i("Error",ex.getMessage());
        }
    }


    private void deserialize_json()
    {
        try{
            user_res=new user();
            JSONObject json_object_user=new JSONObject(getResponse()).getJSONObject("data");
            user_res.setId(json_object_user.getString("id"));
            user_res.setEmail(json_object_user.getString("email"));
            user_res.setFirst_name(json_object_user.getString("first_name"));
            user_res.setLast_name(json_object_user.getString("last_name"));
            user_res.setAvatar(json_object_user.getString("avatar"));
            setUsers(user_res);
        }
        catch (Exception ex)
        {
            Log.i("Error",ex.getMessage());
        }
    }

    public void deserialize_json_array_not()
    {
        try {
            List<user> lst_use=new ArrayList<>();
            JSONArray jsonArray = new JSONArray(getResponse());
            for(int x=0;x<jsonArray.length();x++)
            {
                revistas =new Revistas();
                JSONObject json_object_for_user=jsonArray.getJSONObject(x);
                revistas.setJournal_id(json_object_for_user.getString("journal_id"));
                revistas.setPortada(json_object_for_user.getString("portada"));
                revistas.setName(json_object_for_user.getString("name"));
                lstrevistas.add(revistas);
            }
            setLstrevistas(lstrevistas);
        }
        catch (Exception ex)
        {
            Log.i("Error",ex.getMessage());
        }
    }

    Volumen vol;
    List<Volumen> lstvol;

    public void deserialize_json_array_not_volume()
    {
        try {
            List<Volumen> lst_use=new ArrayList<>();
            JSONArray jsonArray = new JSONArray(getResponse());
            for(int x=0;x<jsonArray.length();x++)
            {
                vol =new Volumen();
                JSONObject json_object_for_user=jsonArray.getJSONObject(x);
                vol.setVolume(json_object_for_user.getString("volume"));
                vol.setNumber(json_object_for_user.getString("number"));
                vol.setCover(json_object_for_user.getString("cover"));
                lst_use.add(vol);
            }
            setLstvol(lst_use);
        }
        catch (Exception ex)
        {
            Log.i("Error",ex.getMessage());
        }
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<user> getLst_users() {
        return lst_users;
    }

    public void setLst_users(List<user> lst_users) {
        this.lst_users = lst_users;
    }

    public user getUsers() {
        return users;
    }

    public void setUsers(user users) {
        this.users = users;
    }


    public Revistas getRevistas() {
        return revistas;
    }

    public void setRevistas(Revistas revistas) {
        this.revistas = revistas;
    }

    public List<Revistas> getLstrevistas() {
        return lstrevistas;
    }

    public void setLstrevistas(List<Revistas> lstrevistas) {
        this.lstrevistas = lstrevistas;
    }

    public Volumen getVol() {
        return vol;
    }

    public void setVol(Volumen vol) {
        this.vol = vol;
    }

    public List<Volumen> getLstvol() {
        return lstvol;
    }

    public void setLstvol(List<Volumen> lstvol) {
        this.lstvol = lstvol;
    }
}
