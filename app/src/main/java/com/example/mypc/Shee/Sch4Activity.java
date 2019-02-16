package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Sch4Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch4);
        textView = (TextView) findViewById(R.id.edu4);
        String s1=" UDAAN - A Programme to Give Wings to Girl Students\n" +
                "\n" +
                "Purpose- Project powered by CBSE to address the teaching gap between school education and engineering entrance by enriching the teaching and learning of Science and Mathematics at School level. The project provides free online resources to girl students of Class XI and Class XII for preparation of admission test for the premier engineering colleges in the country.\n" +
                "Award- Provide free online resources to girl students\n" +
                "Eligibility- Female students of Class XI [Science]\n" +
                "Apply- Online\n" +
                "Application- July, August\n";
        textView.setText(s1);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public  void b4(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.b4s.in/UID/UDAAN"));
        startActivity(browserIntent);
    }
}
