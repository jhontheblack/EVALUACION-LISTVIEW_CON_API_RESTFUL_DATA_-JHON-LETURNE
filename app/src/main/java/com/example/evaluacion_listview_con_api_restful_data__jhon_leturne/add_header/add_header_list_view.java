package com.example.evaluacion_listview_con_api_restful_data__jhon_leturne.add_header;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class add_header_list_view {

    private Context context;
    private ListView lst_views;
    private int resource;


    public add_header_list_view(int resource, Context context, ListView lst_views)
    {
        this.context=context;
        this.resource=resource;
        this.lst_views=lst_views;
        add_header();
    }

    private void add_header()
    {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View header=inflater.inflate(getResource(),null);
        getLst_views().addHeaderView(header);
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ListView getLst_views() {
        return lst_views;
    }

    public void setLst_views(ListView lst_views) {
        this.lst_views = lst_views;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
