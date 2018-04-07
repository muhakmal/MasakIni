package com.baskom.masakini.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.adapter.DalamProsesAdapter;
import com.baskom.masakini.model.ItemTransaksi;
import com.baskom.masakini.request.MasukRequest;
import com.baskom.masakini.request.TransaksiRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DalamProsesFragment extends Fragment {
    private List<ItemTransaksi> itemTransaksiList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DalamProsesAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dalam_proses, container, false);
        adapter = new DalamProsesAdapter(itemTransaksiList);
        progressBar = rootView.findViewById(R.id.progressBar_dalamProses);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = rootView.findViewById(R.id.recycler_view_dalam_proses);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(adapter);
        getItemTransaksiList();
        return rootView;
    }

    public void getItemTransaksiList(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<ItemTransaksi>>(){}.getType();
                itemTransaksiList = new Gson().fromJson(jsonResponse,listType);
                adapter.setItemTransaksiList(itemTransaksiList);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error Response", error.toString());
            }
        };

        TransaksiRequest request = new TransaksiRequest(MasukRequest.getEmail(), responseListener, responseErrorListener);
        Volley.newRequestQueue(getContext().getApplicationContext()).add(request);
    }
}
