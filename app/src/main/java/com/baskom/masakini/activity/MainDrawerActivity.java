package com.baskom.masakini.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.adapter.ItemKeranjangAdapter;
import com.baskom.masakini.adapter.MainViewPagerAdapter;
import com.baskom.masakini.request.MasukRequest;
import com.mikepenz.actionitembadge.library.ActionItemBadge;

import org.json.JSONException;
import org.json.JSONObject;


public class MainDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String DRAWER_REQUEST = "http://masakini.xyz/masakiniapi/Infoakun.php?email=";
    String email;

    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private String[] pageTitle = {"RESEP", "VIDEO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //number of view pager pages
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 2; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        final TextView namaDrawer = header.findViewById(R.id.tv_selamat_datang_nama_side_drawer);

        email = MasukRequest.getEmail();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    namaDrawer.setText(jsonObject.getString("name"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                namaDrawer.setText("NULL");
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, DRAWER_REQUEST + email, responseListener, errorListener);
        queue.add(request);

        //set viewpager adapter
        MainViewPagerAdapter pagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //change tab selection when swipe viewpager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //change view pager page when tab selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        MenuItem item = menu.findItem(R.id.cart);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cart) {
            Intent intent = new Intent(MainDrawerActivity.this, ItemKeranjangActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("masih kosong")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_beranda) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.nav_info_akun) {
            Intent infoAkun = new Intent(MainDrawerActivity.this, InfoAkunActivity.class);
            startActivity(infoAkun);
            finish();
        } else if (id == R.id.nav_riwayat_order) {
            Intent riwayatOrder = new Intent(MainDrawerActivity.this, RiwayatOrderActivity.class);
            startActivity(riwayatOrder);
            finish();
        } else if (id == R.id.nav_kontak_kami) {
            try {
                Intent emailIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "kontak@masakini.xyz"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kontak MasakIni | ");
                startActivity(emailIntent);
                finish();
            } catch (ActivityNotFoundException e) {
                //nothing
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /*public class SessionManagerPreferences {
        private Context context = null;
        private SharedPreferences sharedPreferences = null;
        private SharedPreferences.Editor editor = null;

        public SessionManagerPreferences(Context context){
            this.context = context;
            this.sharedPreferences = this.context.getSharedPreferences();
            this.editor = this.sharedPreferences.edit();
        }

        public void login(){
            this.editor.putBoolean(Globals.KEY_LOGGED_IN, true);
            this.editor.commit();
        }

        public void logout() {
            this.editor.clear();
            this.editor.commit();

            Intent newIntent = new Intent(this.context, LoginActivity.class);

            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            this.context.startActivity(newIntent);
        }

        public boolean isLoggedIn(){
            return this.sharedPreferences.getBoolean(Globals.KEY_LOGGED_IN, false);
        }
    }*/

}



