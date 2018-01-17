package com.baskom.masakini.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.adapter.VideoCardAdapter;
import com.baskom.masakini.model.Video;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class VideoTabFragment extends android.support.v4.app.Fragment {
    private static final String VIDEO_LIST_REQUEST= "http://masakini.xyz/masakiniapi/Videolist.php";
    RecyclerView recyclerView;
    VideoCardAdapter adapter;
    List<Video> videoList;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        progressBar = rootView.findViewById(R.id.progressBar_video);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = rootView.findViewById(R.id.recycler_view_video);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        getVideoList();
        return rootView;
    }

    public void getVideoList(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<Video>>(){}.getType();
                videoList = new Gson().fromJson(jsonResponse,listType);
                adapter = new VideoCardAdapter(videoList);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("response", error.toString());
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.GET, VIDEO_LIST_REQUEST, responseListener, responseErrorListener);
        queue.add(request);
    }
}