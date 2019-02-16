package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
    }
    public void q1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upsc.gov.in/apply-online"));
        startActivity(browserIntent);
    }

    public void q2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rrb.gov.in/rrbs.html"));
        startActivity(browserIntent);
    }

    public void bb1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://scoop.eduncle.com/upcoming-bank-exam"));
        startActivity(browserIntent);
    }
}
