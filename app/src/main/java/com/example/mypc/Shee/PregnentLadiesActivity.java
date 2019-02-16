package com.example.mypc.Shee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class PregnentLadiesActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnent_ladies);
        textView = (TextView) findViewById(R.id.pre);
        String text="";
        try{
            InputStream inputStream=getAssets().open("pregnant.txt");
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
       // textView.setMovementMethod(new ScrollingMovementMethod());

    }
}
