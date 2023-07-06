package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.event_clic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.activity_results;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.Revistas;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.user;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.resultados_volumne;

public class list_view_event_clic implements AdapterView.OnItemClickListener {

    private Context context;

    public list_view_event_clic(Context context)
    {
        this.context=context;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*Log.i("id_control",view.getId()+"-");
        user user_item=(user)parent.getAdapter().getItem(position);
        Log.i("id_control",user_item.getEmail());
        changed_activity(user_item.getId());*/

        Revistas revistas=(Revistas)parent.getAdapter().getItem(position);

        Log.i("holaaaaaaaaa",revistas.getName());

        changed_activity_two(revistas.getJournal_id());


    }


    private void changed_activity_two(String id)
    {
        Intent intent = new Intent(getContext(), resultados_volumne.class);
        Bundle b=new Bundle();
        b.putString("id",id);
        intent.putExtras(b);
        getContext().startActivity(intent);
    }



    private void changed_activity(String id)
    {
        Intent intent = new Intent(getContext(), activity_results.class);
        Bundle b=new Bundle();
        b.putString("id",id);
        intent.putExtras(b);
        getContext().startActivity(intent);
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
