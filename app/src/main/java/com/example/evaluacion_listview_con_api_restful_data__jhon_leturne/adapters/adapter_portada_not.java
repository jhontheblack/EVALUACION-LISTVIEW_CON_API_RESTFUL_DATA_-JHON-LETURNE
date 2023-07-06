package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.R;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.activity_results;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.Revistas;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.user;

import java.util.List;

public class adapter_portada_not extends ArrayAdapter<Revistas> {


    public adapter_portada_not(@NonNull Context context, int resource, @NonNull List<Revistas> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.revista_principal_portada, null);

        TextView txt_nombre=item.findViewById(R.id.txt_nombre);
        TextView txt_id=item.findViewById(R.id.txt_id);
        ImageView img=item.findViewById(R.id.img_portada);
        txt_nombre.setText(getItem(position).getName());
        txt_id.setText(getItem(position).getJournal_id());
        Glide.with(getContext()).load(getItem(position).getPortada()).into(img);
        return item;
    }
}
