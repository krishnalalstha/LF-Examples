package com.lf.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by krishna on 11/20/15.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
// this 5000 means it will delay the 5 second to go to next activity
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoNextActivity();
            }
        }, 2000);
    }


    private void gotoNextActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
