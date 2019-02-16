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

public class Ent3Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent3);
        textView = (TextView) findViewById(R.id.scm3);
        String text="";
        try{
            InputStream inputStream=getAssets().open("bharathiya mahila bank.txt");
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
        textView.setMovementMethod(new ScrollingMovementMethod());}
    public  void d3(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wishfin.com/bharatiya-mahila-bank-home-loan/"));
        startActivity(browserIntent);
    }
}
