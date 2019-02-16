package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DifferentlyAbledActivity extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_differently_abled);
        textView = (TextView) findViewById(R.id.disable);
        String text="";
        try{
            InputStream inputStream=getAssets().open("differentlyabled.txt");
            int size=inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text=new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        textView.setText(text);
        textView.setTextIsSelectable(true);
        //textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void dis(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/search?q=Deendyal+Disabled+Rehabilitation+Scheme+(DDRS)&rlz=1C1CHBD_enIN788IN789&oq=Deendyal+Disabled+Rehabilitation+Scheme+(DDRS)&aqs=chrome..69i57j0.1686j0j7&sourceid=chrome&ie=UTF-8"));
        startActivity(browserIntent);
    }
}
