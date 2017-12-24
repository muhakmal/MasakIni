package com.baskom.masakini.model;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akmalmuhamad on 19/11/17.
 */

public class BuatAkunRequest extends StringRequest {
    private static final String BUATAKUN_REQUEST_URL = "http://masakini.xyz/masakiniapi/Register.php";
    private Map<String, String> params;

    public BuatAkunRequest(String nama, String email, String password, String no_hp, String alamat_lengkap, Response.Listener<String> listener) {
        super(Method.POST, BUATAKUN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nama", nama);
        params.put("email", email);
        params.put("password", password);
        params.put("no_hp", no_hp);
        params.put("alamat_lengkap", alamat_lengkap);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
