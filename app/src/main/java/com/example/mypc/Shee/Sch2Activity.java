package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Sch2Activity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch2);
        textView = (TextView) findViewById(R.id.edu2);
        String s1="Lady Meherbai D Tata Education Scholarship\n" +
                "\n" +
                "Purpose- This scholarship is provided by the Tata Trust group for Indian women who wish to pursue higher education in US, UK or Europe in the following areas:\n" +
                "\n" +
                "Award- Financial assistance will be provided.\n" +
                "Eligibility- Female candidates who have completed their graduation & have consistently remarkable academic record are eligible to apply.\n" +
                "Apply- Application can be submitted by post or email\n" +
                "Application- March, April\n";
        textView.setText(s1);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public  void b2(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.b4s.in/UID/LMDTET"));
        startActivity(browserIntent);
    }
}
