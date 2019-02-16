package com.example.mypc.Shee;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SafetyActivity extends AppCompatActivity {
    final int REQUEST_PHONE_CALL=1;

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        b=(Button)findViewById(R.id.call);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9360252095"));
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if (ContextCompat.checkSelfPermission(SafetyActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(SafetyActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                    }
                    else {
                        //------------------places the call------------------
                        startActivity(callIntent);
                    }
                }
            }
        });
    }

    }
