package com.baskom.masakini.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akmalmuhamad on 02/01/18.
 */

public class TransaksiRequest extends StringRequest {
    private static final String TRANSAKSI_REQUEST_URL = "http://masakini.xyz/masakiniapi/ItemTransaksi.php";
    private Map<String, String> params;

    public TransaksiRequest(String email, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, TRANSAKSI_REQUEST_URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
