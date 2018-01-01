package com.baskom.masakini.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjangRequest extends StringRequest {
    private static final String ITEMKERANJANG_REQUEST_URL = "http://masakini.xyz/masakiniapi/ItemKeranjang.php";
    private Map<String, String> params;

    public ItemKeranjangRequest(String email, Response.Listener<String> listener) {
        super(Method.POST, ITEMKERANJANG_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
