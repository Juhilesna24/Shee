package com.example.mypc.Shee.Helper;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.Shee.BasicformsActivity;
import com.example.mypc.Shee.EducationActivity;
import com.example.mypc.Shee.EnterpreneursActivity;
import com.example.mypc.Shee.Health;
import com.example.mypc.Shee.R;
import com.example.mypc.Shee.SafetyActivity;
import com.example.mypc.Shee.SchemesActivity;

import io.paperdb.Paper;


public class HomeActivity extends AppCompatActivity {
    TextView textView;
    Button Education,Enterpreners,Others,Basicforms,Schemes;
    //ViewPager viewPager;
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
       /* Spinner Spinner = (Spinner) findViewById(R.id.Lang);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(adapter);*/




    public void m2(View view){
        Intent bo=new Intent(this,EducationActivity.class);
        startActivity(bo);
    }
    public void m3(View view){
        Intent bo=new Intent(this,EnterpreneursActivity.class);
        startActivity(bo);
    }
    public void m4(View view){
        Intent bo=new Intent(this,SchemesActivity.class);
        startActivity(bo);
    }
    public void m5(View view){
        Intent bo=new Intent(this,BasicformsActivity.class);
        startActivity(bo);
    }
    public void m6(View view){
        Intent bo=new Intent(this,Health.class);
        startActivity(bo);
    }
    public void m7(View view){
        Intent bo=new Intent(this,SafetyActivity.class);
        startActivity(bo);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:9585094960"));

            Toast.makeText(getApplicationContext(), "SOS ACTIVATED", Toast.LENGTH_SHORT).show();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return super.dispatchKeyEvent(event);
            }
            startActivity(i);
            return true;
        }

        return super.dispatchKeyEvent(event);
    }

}


