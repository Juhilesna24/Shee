package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Sch3Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch3);
        textView = (TextView) findViewById(R.id.edu3);
        String s1="AICTE-Scholarship Scheme to Girl Child (SSGC) under Pragati\n" +
                "\n" +
                "Purpose- An endeavour from AICTE to promote technical education (Engg., Architecture, Pharmacy, applied arts etc.) at Degree and Diploma levels to a girl child. The scheme is to support one girl per family.\n" +
                "Award- INR 50,000 per annum for full course [4,000 Scholarships will be provided.]\n" +
                "Eligibility- Only one girl per family who has taken admission in regular, full-time undergraduate degree/diploma course during academic year 2015-16. Annual Family income should be less than INR 6 lac. \n" +
                "Apply- Online\n" +
                "Application- October, November\n";
        textView.setText(s1);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public  void b3(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.b4s.in/UID/ASSGC"));
        startActivity(browserIntent);
    }
}
