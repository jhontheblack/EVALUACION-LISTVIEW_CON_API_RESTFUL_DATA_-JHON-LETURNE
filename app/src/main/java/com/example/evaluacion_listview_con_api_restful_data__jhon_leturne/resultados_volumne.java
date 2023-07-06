package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.WebService.Asynchtask;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.WebService.WebService;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.adapters.adapter_portada_not;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.adapters.adapter_volumenes;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.deserialize.deserialize_json;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class resultados_volumne extends AppCompatActivity implements Asynchtask {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_volumne);
        Bundle bundle = this.getIntent().getExtras();
        id=bundle.getString("id");
        http_request_ev();
    }

    private void http_request_ev()
    {
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+id,
                datos, resultados_volumne.this, resultados_volumne.this);
        ws.execute("GET");
    }

    private deserialize_json des_json;
    @Override
    public void processFinish(String result) throws JSONException {
        des_json=new deserialize_json(result,true);
        des_json.deserialize_json_array_not_volume();
        adapter_volumenes adapter_revista=new adapter_volumenes(resultados_volumne.this,R.layout.activity_volumne,des_json.getLstvol());
        ListView lst_view_users=findViewById(R.id.volumen);
        lst_view_users.setAdapter(adapter_revista);

    }
}