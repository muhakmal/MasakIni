package com.baskom.masakini.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Intent;


import com.baskom.masakini.R;
import com.baskom.masakini.fragment.WelcomeFragment;
import com.github.paolorotolo.appintro.AppIntro;

public class WelcomeActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", false);
        if (firstRun == false){
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("firstRun", false);
            editor.commit();

            addSlide(WelcomeFragment.newInstance(R.layout.splash_1));
            addSlide(WelcomeFragment.newInstance(R.layout.splash_2));
            addSlide(WelcomeFragment.newInstance(R.layout.splash_3));
            addSlide(WelcomeFragment.newInstance(R.layout.splash_4));

            setBarColor(Color.parseColor("#fa9d3b"));
            setSeparatorColor(Color.parseColor("#2196F3"));

            setDoneText("Mulai");
            // Hide Skip/Done button.
            showSkipButton(false);
            setProgressButtonEnabled(true);
        }else {
            Intent intent = new Intent(this, MasukActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        Intent btnMulai = new Intent(WelcomeActivity.this, MasukActivity.class);
        WelcomeActivity.this.startActivity(btnMulai);
        finish();
    }


}