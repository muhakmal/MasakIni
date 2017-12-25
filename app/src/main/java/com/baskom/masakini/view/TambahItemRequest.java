package com.baskom.masakini.view;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Castor on 12/25/2017.
 */

public class TambahItemRequest extends StringRequest {
    private static final String TAMBAHITEM_REQUEST_URL = "http://masakini.xyz/masakiniapi/TambahItemKeranjang.php";
    private Map<String, String> params;

    public TambahItemRequest(String email, String judulResep, int jumlahPaket, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.GET, TAMBAHITEM_REQUEST_URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("judulResep", judulResep);
        params.put("jumlahPaket", Integer.toString(jumlahPaket));
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
