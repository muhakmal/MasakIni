package com.baskom.masakini.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Castor on 2/12/2018.
 */

public class TambahTransaksiRequest extends StringRequest{
    private static final String TAMBAHTRANSAKSI_REQUEST_URL = "http://masakini.xyz/masakiniapi/TambahItemTransaksi.php";
    private Map<String, String> params;

    public TambahTransaksiRequest(String email, Response.Listener<String> listener) {
        super(Method.POST, TAMBAHTRANSAKSI_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
