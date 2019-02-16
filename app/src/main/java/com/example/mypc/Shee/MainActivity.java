package com.example.mypc.Shee;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.mypc.Shee.Helper.HomeActivity;


public class MainActivity extends AppCompatActivity {
   private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent LoginActivityIntent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(LoginActivityIntent);
                finish();
            }

        },SPLASH_TIME_OUT);


   }


}



