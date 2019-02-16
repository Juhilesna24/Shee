package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BasicformsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicforms);


    }
    public void o1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bankbazaar.com/?variantOptions=mobileRequired&WT.mc_id=bbcampaign_sem_BB|BB_Brand|brandExact|E_bankbazaar|c&gclid=Cj0KCQjwqM3VBRCwARIsAKcekb0wgB2ZI4k059ROaDgZmMQJqHzVFafcF6Ie2BC3UjD8uojsgHXQeyEaAgwNEALw_wcB"));
        startActivity(browserIntent);
    }
    public void o2(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.indianrail.gov.in/enquiry/TBIS/TrainBetweenImportantStations.jsp"));
        startActivity(browserIntent);
    }
    public void o3(View view){
        Intent bo=new Intent(this,ExamActivity.class);
        startActivity(bo);
    }
    public void o4(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://uidai.gov.in/"));
        startActivity(browserIntent);
    }
}
