package com.baskom.masakini.model;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Castor on 12/28/2017.
 */

public class DeleteItemKeranjangRequest extends StringRequest {
    private static final String DELETEITEMKERANJANG_REQUEST_URL = "http://masakini.xyz/masakiniapi/DeleteItemKeranjang.php";
    private Map<String, String> params;

    public DeleteItemKeranjangRequest(String email, String judulResep,Response.Listener<String> listener) {
        super(Method.POST, DELETEITEMKERANJANG_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("judulResep", judulResep);
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
