package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.WebService;


import org.json.JSONException;

public interface Asynchtask {
    /**
     * ESta funcion retorna los datos devueltos por el ws
     * @param result
     */
    void processFinish(String result) throws JSONException;

}
