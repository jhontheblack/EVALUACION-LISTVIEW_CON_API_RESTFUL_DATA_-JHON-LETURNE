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
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.Revistas;
import com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.models.Volumen;

import java.util.List;

public class adapter_volumenes extends ArrayAdapter<Volumen> {
    public adapter_volumenes(@NonNull Context context, int resource, @NonNull List<Volumen> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_volumne, null);

        TextView txt_volumen=item.findViewById(R.id.txt_volumen);
        TextView txt_number=item.findViewById(R.id.txt_number);
        ImageView img=item.findViewById(R.id.img_portada_vol);
        txt_volumen.setText(getItem(position).getVolume());
        txt_number.setText(getItem(position).getNumber());
        Glide.with(getContext()).load(getItem(position).getCover()).into(img);
        return item;
    }
}
