package com.example.mypc.Shee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class SeniorCitizenActivity extends AppCompatActivity {


    TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_citizen);

        textView = (TextView) findViewById(R.id.text);
       String text="";
        try{
            InputStream inputStream=getAssets().open("senior.txt");
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




}
