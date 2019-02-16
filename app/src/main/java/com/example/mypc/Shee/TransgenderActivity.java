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

public class TransgenderActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transgender);
        textView = (TextView) findViewById(R.id.trans);
        String text="";
        try{
            InputStream inputStream=getAssets().open("transgender.txt");
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
       // textView.setMovementMethod(new ScrollingMovementMethod());
          }

    public void t1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://economictimes.indiatimes.com/articleshow/50749264.cms?utm_source=contentofinterest&utm_medium=text&utm_campaign=cppst"));
        startActivity(browserIntent);
    }
}
