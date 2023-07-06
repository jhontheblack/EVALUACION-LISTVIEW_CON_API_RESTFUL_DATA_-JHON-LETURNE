package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.R;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.user;

import java.util.List;

public class adapter_users_principal extends ArrayAdapter<user> {


    public adapter_users_principal(@NonNull Context context, int resource, @NonNull List<user> users) {
        super(context, resource, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.items_principal, null);
        //referencia a textview
        TextView nombre=item.findViewById(R.id.txt_nombre);
        TextView email=item.findViewById(R.id.txt_correo);
        Log.i("estaeslaclase",getItem(position).getFirst_name());
        //asignacion de valores
        nombre.setText(getItem(position).getFirst_name());
        email.setText(getItem(position).getEmail());
        return (item);
    }


}
