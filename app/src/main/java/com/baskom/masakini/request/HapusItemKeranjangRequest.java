package com.baskom.masakini.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by akmalmuhamad on 27/12/17.
 */
public class HapusItemKeranjangRequest extends StringRequest{
    private static final String DELETE_ITEMKERANJANG_REQUEST_URL = "http://masakini.xyz/masakiniapi/DeleteItemKeranjang.php";
    public HapusItemKeranjangRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public HapusItemKeranjangRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }
}
