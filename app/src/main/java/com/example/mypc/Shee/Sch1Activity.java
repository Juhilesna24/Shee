package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Sch1Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch1);
        textView = (TextView) findViewById(R.id.edu1);
        String s1="Google Anita Borg Memorial Scholarship\n\n" +
                "\n" +
                "Purpose- In fond memory of Ms. Anita Borg, this scholarship aims to encourage women to excel in computing and technology. The vision is to build role models & leaders in the field of Computer science.\n" +
                "\n" +
                "Award- Tuition and education-related expenses\n" +
                "Eligibility- Female graduates and post graduates [computer science, computer engineering or related technical field] with strong academic background can apply.\n" +
                "Apply-Online\n" +
                "Application- April, May\n";
        textView.setText(s1);
        textView.setMovementMethod(new ScrollingMovementMethod());

    }
    public  void b1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.b4s.in/UID/GABMS"));
        startActivity(browserIntent);
    }

}
